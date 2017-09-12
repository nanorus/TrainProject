package com.example.nanorus.trainproject.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;


public class TestNormalBroadcastRecieverService extends Service {
    MyBinder mBinder;

    public TestNormalBroadcastRecieverService() {
    }


    @Override
    public void onCreate() {
        Intent intent1 = new Intent("testing.broadcast.reciever.action");
        intent1.putExtra("message", "onCreate");
        sendBroadcast(intent1);
        super.onCreate();
    }


    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Intent intent1 = new Intent("testing.broadcast.reciever.action");
        intent1.putExtra("message", "onStartCommand");
        sendBroadcast(intent1);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        Intent intent1 = new Intent("testing.broadcast.reciever.action");
        intent1.putExtra("message", "onStart");
        sendBroadcast(intent1);
        super.onStart(intent, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Intent intent1 = new Intent("testing.broadcast.reciever.action");
        intent1.putExtra("message", "onBind");
        sendBroadcast(intent1);

        mBinder = new MyBinder();
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Intent intent1 = new Intent("testing.broadcast.reciever.action");
        intent1.putExtra("message", "onUnbind");
        sendBroadcast(intent1);
        return true;
    }

    @Override
    public void onDestroy() {
        Intent intent1 = new Intent("testing.broadcast.reciever.action");
        intent1.putExtra("message", "onDestroy");
        sendBroadcast(intent1);
        super.onDestroy();
    }

    @Override
    public void onRebind(Intent intent) {
        Intent intent1 = new Intent("testing.broadcast.reciever.action");
        intent1.putExtra("message", "onRebind");
        sendBroadcast(intent1);
        super.onRebind(intent);
    }

    public class MyBinder extends Binder {
        private MyCallback mMyCallback;

        public void setCallback(MyCallback myCallback) {
            mMyCallback = myCallback;
        }

        public MyCallback getMyCallback() {
            return mMyCallback;
        }


       public void slowAction() {
                this.getMyCallback().showMessageFromCallback();
        }

    }

    public interface MyCallback {
        void showMessageFromCallback();
    }

}
