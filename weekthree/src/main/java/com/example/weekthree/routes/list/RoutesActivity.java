package com.example.weekthree.routes.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.weekthree.R;
import com.example.weekthree.data.DataManager;
import com.example.weekthree.data.api.RoutesRetrofitClient;
import com.example.weekthree.data.api.pojo.DatumPojo;
import com.example.weekthree.data.api.pojo.RequestPojo;
import com.example.weekthree.data.api.service.GetAllRoutesService;
import com.example.weekthree.routes.details.RouteDetailsActivity;
import com.example.weekthree.routes.SaveRoutesFragment;
import com.example.weekthree.ui.RecyclerViewItemClickSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import rx.Single;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RoutesActivity extends AppCompatActivity implements  RoutesFragment.OnFragmentInteractionListener {

    /*
    SaveRoutesFragment mSaveRoutesFragment;
    DataManager mDataManager;

    @BindView(R.id.activity_routes_rv_routes)
    RecyclerView mRecyclerViewRoutes;
    @BindView(R.id.activity_routes_rl_progress)
    RelativeLayout mRlProgress;
    @BindView(R.id.activity_routes_pb_progress)
    ProgressBar mPbProgress;
    @BindView(R.id.activity_routes_swipe)
    SwipeRefreshLayout mSwipe;
    */

    @BindView(R.id.activity_routes_frame_routes_list)
    FrameLayout mRoutesListFrameLayout;

    RoutesFragment mRoutesFragment;

    /*
    RoutesAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    Single<RequestPojo> mRequestPojoSingle;
    Subscription mRequestPojoSubscription;

    List<DatumPojo> mData;

    String SAVE_ROUTES_FRAGMENT_TAG = "SAVE_ROUTES_FRAGMENT";
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);
        ButterKnife.bind(this);

        mRoutesFragment = RoutesFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_routes_frame_routes_list,
                mRoutesFragment, "TAG_FRAGMENT_ROUTES").commit();

        /*
        initDependencies();
        initListeners();

        if (isActivityRecreated()) {
            // restore data
            mData = mSaveRoutesFragment.getDatumPojos();
            mAdapter = new RoutesAdapter(mData);
            mRecyclerViewRoutes.setAdapter(mAdapter);
            if (mData == null || mData.size() == 0) {
                loadOnline();
            }
        } else {
            // load data
            mData = new ArrayList<>();
            mData.addAll(mDataManager.loadData(DataManager.DB_TYPE_SQLITE));

            mAdapter = new RoutesAdapter(mData);
            mRecyclerViewRoutes.setAdapter(mAdapter);

            if (mData == null || mData.size() == 0)
                loadOnline();

            mSaveRoutesFragment = new SaveRoutesFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(mSaveRoutesFragment, SAVE_ROUTES_FRAGMENT_TAG).commit();
        }
*/

    }

    /*
        private void initDependencies() {
            showLoadingProgressbar(false);

            mDataManager = new DataManager();
            mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            Retrofit retrofit = RoutesRetrofitClient.getInstance();
            GetAllRoutesService service = retrofit.create(GetAllRoutesService.class);
            mRequestPojoSingle = service.getAllRoutesRequestPojoSingle();

            mRecyclerViewRoutes.setLayoutManager(mLayoutManager);
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerViewRoutes.getContext(),
                    ((LinearLayoutManager) mLayoutManager).getOrientation());
            mRecyclerViewRoutes.addItemDecoration(dividerItemDecoration);
        }

        private void initListeners() {
            mSwipe.setOnRefreshListener(this::loadOnline);

            RecyclerViewItemClickSupport.addTo(mRecyclerViewRoutes).setOnItemClickListener(
                    (recyclerView, position, v) -> {
                        goRouteDetailsActivity(mData.get(position).getId());
                        Toast.makeText(this, mData.get(position).getFromCity().getName(), Toast.LENGTH_SHORT).show();
                    }
            );
        }
    */
    @Override
    public void goRouteDetailsActivity(int id) {
        Intent intent = new Intent(RoutesActivity.this, RouteDetailsActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
/*
    private boolean isActivityRecreated() {
        mSaveRoutesFragment = (SaveRoutesFragment) getSupportFragmentManager()
                .findFragmentByTag(SAVE_ROUTES_FRAGMENT_TAG);
        return mSaveRoutesFragment != null;
    }
*/
/*
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRequestPojoSubscription != null && !mRequestPojoSubscription.isUnsubscribed())
            mRequestPojoSubscription.unsubscribe();

        mSaveRoutesFragment.setDatumPojos(mData);
        RecyclerViewItemClickSupport.removeFrom(mRecyclerViewRoutes);
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
                            mDataManager.saveData(requestPojo.getData(), DataManager.DB_TYPE_SQLITE);
                            mData.clear();
                            mData.addAll(requestPojo.getData());
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
            if (!mSwipe.isRefreshing())
                mSwipe.setRefreshing(true);
            mRlProgress.setVisibility(View.VISIBLE);
            mPbProgress.setActivated(true);
        } else {
            if (mSwipe.isRefreshing())
                mSwipe.setRefreshing(false);
            mPbProgress.setActivated(false);
            mRlProgress.setVisibility(View.INVISIBLE);
        }
    }
  */
/*
private void saveData(data){

}

private data restoreData(){

}
*/
}
