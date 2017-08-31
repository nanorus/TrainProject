package com.example.nanorus.trainproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button mBtnCustomView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnCustomView = (Button) findViewById(R.id.activity_main_btn_custom_view);
        mBtnCustomView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_main_btn_custom_view:
                startActivity(new Intent(this, CustomViewActivity.class));
                break;
        }
    }
}
