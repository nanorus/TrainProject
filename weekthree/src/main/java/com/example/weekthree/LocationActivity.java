package com.example.weekthree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.activity_location_btn_default, R.id.activity_location_btn_fused})
    void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.activity_location_btn_default:
                intent = new Intent(this, LocationDefaultActivity.class);
                break;
            case R.id.activity_location_btn_fused:
                intent = new Intent(this, LocationGoogleActivity.class);
                break;
        }
        startActivity(intent);
    }


}
