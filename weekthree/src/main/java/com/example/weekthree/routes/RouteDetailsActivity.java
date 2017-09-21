package com.example.weekthree.routes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.weekthree.R;
import com.example.weekthree.data.DataManager;
import com.example.weekthree.data.api.pojo.DatumPojo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RouteDetailsActivity extends AppCompatActivity {
    private int id = 0;
    DataManager mDataManager;

    @BindView(R.id.activity_route_details_tv_id)
    TextView tvId;
    @BindView(R.id.activity_route_details_tv_from_city)
    TextView tvFromCity;
    @BindView(R.id.activity_route_details_tv_to_city)
    TextView tvToCity;
    @BindView(R.id.activity_route_details_tv_price)
    TextView tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_details);
        ButterKnife.bind(this);
        id = getIntent().getIntExtra("id", 0);

        mDataManager = new DataManager();

        DatumPojo data = mDataManager.loadDetailsData(id, DataManager.DB_TYPE_SQLITE);

        tvId.setText(String.valueOf(data.getId()));
        tvFromCity.setText(data.getFromCity().getName());
        tvToCity.setText(data.getToCity().getName());
        tvPrice.setText(String.valueOf(data.getPrice()));

        // get route by id
        // show  route info

    }
}
