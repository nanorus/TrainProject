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

public class BroadcastEventBusSecondActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.activity_broadcast_event_bus_second_btn_bind)
    Button mBtnBind;
    @BindView(R.id.activity_broadcast_event_bus_second_btn_unbind)
    Button mBtnUnbind;

    ServiceConnection mServiceConnection;
    Intent mIntent;
    boolean isServiceBounded = false;
    BroadcastReceiver mBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_event_bus_second);

        ButterKnife.bind(this);
        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, intent.getStringExtra("message"), Toast.LENGTH_SHORT).show();
            }
        };
        IntentFilter intentFilter = new IntentFilter("testing.broadcast.reciever.action");
        registerReceiver(mBroadcastReceiver, intentFilter);
        mBtnBind.setOnClickListener(this);
        mBtnUnbind.setOnClickListener(this);

        mIntent = new Intent(this, TestNormalBroadcastRecieverService.class);

        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Snackbar.make(mBtnBind.getRootView(), "Service Connected", Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Snackbar.make(mBtnBind.getRootView(), "Service Disonnected", Snackbar.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_broadcast_event_bus_second_btn_bind:
                Snackbar.make(mBtnBind.getRootView(), "Try to bind", Snackbar.LENGTH_SHORT).show();
                isServiceBounded = true;
                bindService(mIntent, mServiceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.activity_broadcast_event_bus_second_btn_unbind:
                if (isServiceBounded)
                    unbindService(mServiceConnection);
                isServiceBounded = false;
                break;
        }
    }
}
