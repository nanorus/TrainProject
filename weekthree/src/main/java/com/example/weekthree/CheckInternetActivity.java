package com.example.weekthree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.weekthree.utils.CheckInternet;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckInternetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_internet);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.activity_check_internet_btn_check})
    void onClick(){
        String message;
        if (CheckInternet.getInstance().isOnline())
            message = "Internet is working. Online";
        else
            message = "No internet. Offline";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
