package com.example.nanorus.trainproject.broadcast_eventbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nanorus.trainproject.R;
import com.example.nanorus.trainproject.bus.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BroadcastEventBusTrainingActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.activity_broadcast_btn_send_broadcast)
    Button mBtnSendBroadcast;
    @BindView(R.id.activity_broadcast_btn_send_event)
    Button mBtnSendEvent;

    BroadcastReceiver mBroadcastReceiver;
    //Bus mBus = EventBus.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_from);
        ButterKnife.bind(this);

        mBtnSendBroadcast.setOnClickListener(this);
        mBtnSendEvent.setOnClickListener(this);

        initializeReceiver();
        // mBus.register(this);
        EventBus.getDefault().register(this);
    }

    void sendBroadcastMessageHello() {
        Intent intent = new Intent("nanorus.action.testing.broadcast");
        intent.putExtra("message", "hello from broadcast receiver!");
        sendBroadcast(intent);

    }

    void sendEventMessageHello() {
        //    mBus.post(new MessageEvent("hello from eventbus!"));
        EventBus.getDefault().post(new MessageEvent("hello from eventbus!"));
    }

    //  @Subscribe
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageSubscriber(MessageEvent event) {
        showMessage(event.getMessage());
    }

    void initializeReceiver() {
        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                showMessage(intent.getStringExtra("message"));
            }
        };

        registerReceiver(mBroadcastReceiver, new IntentFilter("nanorus.action.testing.broadcast"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_broadcast_btn_send_broadcast:
                sendBroadcastMessageHello();
                break;
            case R.id.activity_broadcast_btn_send_event:
                sendEventMessageHello();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // mBus.unregister(this);
        EventBus.getDefault().unregister(this);
    }

    void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
