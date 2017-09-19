package com.example.weekthree.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.example.weekthree.App;

public class CheckInternet {

    private static CheckInternet sInstance = null;

    public static CheckInternet getInstance() {
        if (sInstance == null)
            sInstance = new CheckInternet();
        return sInstance;
    }

    public boolean isOnline() {
        return ((ConnectivityManager) App.getInstance().getApplicationContext().getSystemService
                (Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;

    }
}