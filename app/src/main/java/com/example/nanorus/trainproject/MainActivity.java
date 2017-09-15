package com.example.nanorus.trainproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.nanorus.trainproject.broadcast_eventbus.BroadCastRecieverTestingActivity;
import com.example.nanorus.trainproject.broadcast_eventbus.BroadcastEventBusTrainingActivity;
import com.example.nanorus.trainproject.dialogs.DialogsActivity;
import com.example.nanorus.trainproject.fragments_lifecycle.FragmentsLifecycleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.activity_main_btn_custom_view)
    Button mBtnCustomView;
    @BindView(R.id.activity_main_btn_fragments_lifecycle)
    Button mBtnFragmentsLifecycle;
    @BindView(R.id.activity_main_btn_dialogs)
    Button mBtnDialogs;
    @BindView(R.id.activity_main_btn_broadcast)
    Button mBtnBroadcast;
    @BindView(R.id.activity_main_btn_images_dpi)
    Button mImagesDpi;
    @BindView(R.id.activity_main_btn_broadcast_eventbus)
    Button mBtnBroadCastEventbus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBtnCustomView.setOnClickListener(this);
        mBtnFragmentsLifecycle.setOnClickListener(this);
        mBtnDialogs.setOnClickListener(this);
        mBtnBroadcast.setOnClickListener(this);
        mImagesDpi.setOnClickListener(this);
        mBtnBroadCastEventbus.setOnClickListener(this);

        showBoxingExample();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_main_btn_custom_view:
                startActivity(new Intent(this, CustomViewActivity.class));
                break;
            case R.id.activity_main_btn_fragments_lifecycle:
                startActivity(new Intent(this, FragmentsLifecycleActivity.class));
                break;
            case R.id.activity_main_btn_dialogs:
                startActivity(new Intent(this, DialogsActivity.class));
                break;
            case R.id.activity_main_btn_broadcast:
                startActivity(new Intent(this, BroadCastRecieverTestingActivity.class));
                break;
            case R.id.activity_main_btn_images_dpi:
                startActivity(new Intent(this, ImagesDpiActivity.class));
                break;
            case R.id.activity_main_btn_broadcast_eventbus:
                startActivity(new Intent(this, BroadcastEventBusTrainingActivity.class));
                break;
        }
    }

    private void showBoxingExample() {
        System.out.println("Autoboxing example: ");
        Integer a1 = 26;
        Integer a2 = 25;
        Integer b1 = 1001;
        Integer b2 = 1000;

        Integer a3 = 25;
        Integer b3 = 1000;

        if (a1 > a2)
            System.out.println(a1 + " > " + a2);
        else
            System.out.println(a1 + " < " + a2);

        if (b1 > b2)
            System.out.println(b1 + " > " + b2);
        else
            System.out.println(b1 + " < " + b2);


        if (a3 == a2)
            System.out.println(a3 + " == " + a2);
        else
            System.out.println(a3 + " != " + a2);

        if (b3 == b2)
            System.out.println(b3 + " == " + b2);
        else
            System.out.println(b3 + " != " + b2);
    }

/*
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("testParcelable", new ParcelableTestPojo(5, "hello", 8.8));
        HashMap<Integer, NotSerializableTestClass> hashMap  = new HashMap<>();
        hashMap.put(0, new NotSerializableTestClass());
        outState.putSerializable("testSerializable", hashMap);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        HashMap<Integer, NotSerializableTestClass> hashMap = (   HashMap<Integer, NotSerializableTestClass>) savedInstanceState.getSerializable("testSerializable");
        Toast.makeText(this,String.valueOf((NotSerializableTestClass) hashMap.get(0).getI()) , Toast.LENGTH_SHORT).show();
    }
*/

}
