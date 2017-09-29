package com.example.weekthree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.weekthree.custom_view.ShrinkedTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomViewActivity extends AppCompatActivity {

    @BindView(R.id.activity_custom_view_tv_shrinked)
    ShrinkedTextView tvShrinked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ButterKnife.bind(this);
    }
}
