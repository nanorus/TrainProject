package com.example.weekthree;

import android.app.Application;

import io.realm.Realm;


public class App extends Application {

    private static App sInstance = null;

    public App(){
        sInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }

    public static App getInstance() {
        return sInstance;
    }

}
