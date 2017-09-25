package com.example.weekthree.routes.list;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
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
import com.example.weekthree.routes.details.RouteDetailsFragment;
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

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class RoutesActivity extends AppCompatActivity implements RoutesFragment.OnFragmentInteractionListener, RouteDetailsFragment.OnFragmentInteractionListener {

    @BindView(R.id.activity_routes_frame_routes_list)
    FrameLayout mRoutesListFrameLayout;
    @Nullable
    @BindView(R.id.activity_routes_frame_route_details)
    FrameLayout mRouteDetailsFrameLayout;

    RoutesFragment mRoutesFragment;
    RouteDetailsFragment routeDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);
        ButterKnife.bind(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        mRoutesFragment = RoutesFragment.newInstance();
        fragmentManager.beginTransaction().replace(R.id.activity_routes_frame_routes_list,
                mRoutesFragment, "TAG_FRAGMENT_ROUTES").commit();

        if (isTablet() && isLandscape()) {
            routeDetailsFragment = RouteDetailsFragment.newInstance();
            fragmentManager.beginTransaction().replace(R.id.activity_routes_frame_route_details,
                    routeDetailsFragment, "TAG_FRAGMENT_ROUTE_DETAILS").commit();
        }


    }

    @Override
    public void goRouteDetailsActivity(int id) {
        Intent intent = new Intent(RoutesActivity.this, RouteDetailsActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public boolean isTablet() {
        return mRouteDetailsFrameLayout != null;
    }

    @Override
    public void showRouteDetails(int id) {
        if (routeDetailsFragment != null)
            routeDetailsFragment.showRouteDetails(id);
    }

    @Override
    public boolean isLandscape() {
        return getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE;
    }


/*
private void saveData(data){

}

private data restoreData(){

}
*/
}
