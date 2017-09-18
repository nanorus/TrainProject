package com.example.weekthree;

import android.app.Application;


public class App extends Application {

    private static App sInstance = null;

    public App(){
        sInstance = this;
    }

    public static App getInstance() {
        return sInstance;
    }

}
