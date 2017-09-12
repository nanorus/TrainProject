package com.example.nanorus.trainproject.broadcast_eventbus;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nanorus.trainproject.R;
import com.example.nanorus.trainproject.service.TestNormalBroadcastRecieverService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BroadCastRecieverTestingActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.activity_broadcast_btn_start)
    Button mBtnStart;
    @BindView(R.id.activity_broadcast_btn_stop_bind)
    Button mBtnStopBind;
    @BindView(R.id.activity_broadcast_btn_start_bind)
    Button mBtnStartBind;
    @BindView(R.id.activity_broadcast_btn_new_activity)
    Button mBtnNewActivity;


    BroadcastReceiver mBroadcastReceiver;

    Intent mIntent;
    ServiceConnection mServiceConnection;
    boolean mBounded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_reciever_testing);
        ButterKnife.bind(this);

        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, intent.getStringExtra("message"), Toast.LENGTH_SHORT).show();
            }
        };
        IntentFilter intentFilter = new IntentFilter("testing.broadcast.reciever.action");
        registerReceiver(mBroadcastReceiver, intentFilter);
        mIntent = new Intent(this, TestNormalBroadcastRecieverService.class);
        startService(mIntent);
        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                System.out.println("Service Connected");
                Snackbar.make(mBtnStart.getRootView(), "Service Connected", Snackbar.LENGTH_SHORT).show();
                TestNormalBroadcastRecieverService.MyBinder binder = (TestNormalBroadcastRecieverService.MyBinder) iBinder;
                binder.setCallback(() -> Snackbar.make(mBtnStart.getRootView(), "Message from callback", Snackbar.LENGTH_SHORT).show());
                binder.slowAction();
            }


            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Snackbar.make(mBtnStart.getRootView(), "Service Disconnected", Snackbar.LENGTH_SHORT).show();
            }
        };

        mBtnStart.setOnClickListener(this);
        mBtnStartBind.setOnClickListener(this);
        mBtnStopBind.setOnClickListener(this);
        mBtnNewActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_broadcast_btn_start:
                startService(mIntent);
                break;
            case R.id.activity_broadcast_btn_start_bind:
                bindService(mIntent, mServiceConnection, BIND_AUTO_CREATE);
                mBounded = true;
                break;
            case R.id.activity_broadcast_btn_stop_bind:
                if (mBounded)
                    unbindService(mServiceConnection);
                mBounded = false;
                break;
            case R.id.activity_broadcast_btn_new_activity:
                startActivity(new Intent(this, BroadcastEventBusSecondActivity.class));
                break;
        }
    }
}
