package com.example.weekthree.routes.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.SeekBar;

import com.example.weekthree.R;
import com.example.weekthree.data.DataManager;
import com.example.weekthree.data.preferences.PreferencesManager;
import com.example.weekthree.routes.details.RouteDetailsActivity;
import com.example.weekthree.routes.details.RouteDetailsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class RoutesActivity extends AppCompatActivity implements RoutesFragment.OnFragmentInteractionListener, RouteDetailsFragment.OnFragmentInteractionListener {

    static final int SEEKBAR_PROGRESS_SQLITE = 0;
    static final int SEEKBAR_PROGRESS_REALM = 1;

    @BindView(R.id.activity_routes_frame_routes_list)
    FrameLayout mRoutesListFrameLayout;
    @Nullable
    @BindView(R.id.activity_routes_frame_route_details)
    FrameLayout mRouteDetailsFrameLayout;
    @BindView(R.id.seekBar)
    SeekBar mSeekBar;

    RoutesFragment mRoutesFragment;
    RouteDetailsFragment routeDetailsFragment;

    PreferencesManager mPreferencesManager;

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

        mPreferencesManager = PreferencesManager.getInstance();
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (i) {
                    case SEEKBAR_PROGRESS_SQLITE:
                        mPreferencesManager.setDbType(DataManager.DB_TYPE_SQLITE);
                        break;
                    case SEEKBAR_PROGRESS_REALM:
                        mPreferencesManager.setDbType(DataManager.DB_TYPE_REALM);
                        break;
                }
                mRoutesFragment.changeDataManager();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

}
