package com.example.nanorus.trainproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.nanorus.trainproject.custom_views.PlusMinusView;

public class CustomViewActivity extends AppCompatActivity {

    PlusMinusView mPlusMinusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        mPlusMinusView = (PlusMinusView) findViewById(R.id.activity_custom_view_plus_minus);

        mPlusMinusView.setOnClickListener(view -> Toast.makeText(this, "plus minus", Toast.LENGTH_SHORT).show());

    }
}
