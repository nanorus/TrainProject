package com.example.weekthree.routes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.weekthree.R;
import com.example.weekthree.data.api.RoutesRetrofitClient;
import com.example.weekthree.data.api.pojo.DatumPojo;
import com.example.weekthree.data.api.pojo.RequestPojo;
import com.example.weekthree.data.api.service.GetAllRoutesService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import rx.Single;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RoutesActivity extends AppCompatActivity {

    SaveRoutesFragment mSaveRoutesFragment;

    @BindView(R.id.activity_routes_rv_routes)
    RecyclerView mRecyclerViewRoutes;
    @BindView(R.id.activity_routes_rl_progress)
    RelativeLayout mRlProgress;
    @BindView(R.id.activity_routes_pb_progress)
    ProgressBar mPbProgress;

    RoutesAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    Single<RequestPojo> mRequestPojoSingle;
    Subscription mRequestPojoSubscription;
    List<DatumPojo> mDatumPojos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);
        ButterKnife.bind(this);
        showLoadingProgressbar(false);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerViewRoutes.setLayoutManager(mLayoutManager);
        Retrofit retrofit = RoutesRetrofitClient.getInstance();
        GetAllRoutesService service = retrofit.create(GetAllRoutesService.class);
        mRequestPojoSingle = service.getAllRoutesRequestPojoSingle();

        mSaveRoutesFragment = (SaveRoutesFragment) getSupportFragmentManager().findFragmentByTag("SAVE_ROUTES_FRAGMENT");
        if (mSaveRoutesFragment != null) {
            // activity recreated
            mDatumPojos = mSaveRoutesFragment.getDatumPojos();
            mAdapter = new RoutesAdapter(mDatumPojos);
            mRecyclerViewRoutes.setAdapter(mAdapter);
            if (mDatumPojos == null || mDatumPojos.size() == 0) {
                loadOnline();
            }

        } else {
            // activity created
            mDatumPojos = new ArrayList<>();
            mAdapter = new RoutesAdapter(mDatumPojos);
            mRecyclerViewRoutes.setAdapter(mAdapter);
            loadOnline();
        }
        mSaveRoutesFragment = new SaveRoutesFragment();
        getSupportFragmentManager().beginTransaction().add(mSaveRoutesFragment, "SAVE_ROUTES_FRAGMENT").commit();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRequestPojoSubscription != null && !mRequestPojoSubscription.isUnsubscribed())
            mRequestPojoSubscription.unsubscribe();

        mSaveRoutesFragment.setDatumPojos(mDatumPojos);
    }

    private void loadOnline() {
        if (mRequestPojoSubscription != null && !mRequestPojoSubscription.isUnsubscribed())
            mRequestPojoSubscription.unsubscribe();
        mRequestPojoSubscription = mRequestPojoSingle
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> showLoadingProgressbar(true))
                .subscribe(
                        requestPojo -> {
                            mDatumPojos.clear();
                            mDatumPojos.addAll(requestPojo.getData());
                            mAdapter.notifyDataSetChanged();
                            showLoadingProgressbar(false);
                        },
                        throwable -> {
                            throwable.printStackTrace();
                            showLoadingProgressbar(false);
                        });
    }

    private void showLoadingProgressbar(boolean willShow) {
        if (willShow) {
            mRlProgress.setVisibility(View.VISIBLE);
            mPbProgress.setActivated(true);
        } else {
            mPbProgress.setActivated(false);
            mRlProgress.setVisibility(View.INVISIBLE);
        }
    }

/*
private void saveData(data){

}

private data restoreData(){

}
*/
}
