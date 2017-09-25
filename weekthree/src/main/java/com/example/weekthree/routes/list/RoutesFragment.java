package com.example.weekthree.routes.list;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.weekthree.R;
import com.example.weekthree.data.DataManager;
import com.example.weekthree.data.api.RoutesRetrofitClient;
import com.example.weekthree.data.api.pojo.DatumPojo;
import com.example.weekthree.data.api.pojo.RequestPojo;
import com.example.weekthree.data.api.service.GetAllRoutesService;
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


public class RoutesFragment extends Fragment {

    @BindView(R.id.fragment_routes_rv_routes)
    RecyclerView mRecyclerViewRoutes;
    @BindView(R.id.fragment_routes_rl_progress)
    RelativeLayout mRlProgress;
    @BindView(R.id.fragment_routes_pb_progress)
    ProgressBar mPbProgress;
    @BindView(R.id.fragment_routes_swipe)
    SwipeRefreshLayout mSwipe;

    DataManager mDataManager;
    RoutesAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    Single<RequestPojo> mRequestPojoSingle;
    Subscription mRequestPojoSubscription;

    List<DatumPojo> mData;

    private OnFragmentInteractionListener mListener;

    public RoutesFragment() {
        // Required empty public constructor
    }

    public static RoutesFragment newInstance() {
        RoutesFragment fragment = new RoutesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_routes, container, false);
        ButterKnife.bind(this, view);

        initDependencies();
        initListeners();


        mData = new ArrayList<>();
        mData.addAll(mDataManager.loadData(DataManager.DB_TYPE_SQLITE));

        mAdapter = new RoutesAdapter(mData);
        mRecyclerViewRoutes.setAdapter(mAdapter);

        if (mData == null || mData.size() == 0)
            loadOnline();

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        if (mRequestPojoSubscription != null && !mRequestPojoSubscription.isUnsubscribed())
            mRequestPojoSubscription.unsubscribe();

        RecyclerViewItemClickSupport.removeFrom(mRecyclerViewRoutes);
    }

    private void initDependencies() {
        showLoadingProgressbar(false);

        mDataManager = new DataManager();
        mLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
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

        if (mListener.isTablet() && mListener.isLandscape()) {
            RecyclerViewItemClickSupport.addTo(mRecyclerViewRoutes).setOnItemClickListener(
                    (recyclerView, position, v) -> mListener.showRouteDetails(mData.get(position).getId())
            );
        } else {
            RecyclerViewItemClickSupport.addTo(mRecyclerViewRoutes).setOnItemClickListener(
                    (recyclerView, position, v) -> mListener.goRouteDetailsActivity(mData.get(position).getId())
            );
        }

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


    public interface OnFragmentInteractionListener {
        void goRouteDetailsActivity(int id);

        boolean isTablet();

        boolean isLandscape();

        void showRouteDetails(int id);
    }
}
