package com.example.weekthree.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.weekthree.App;

public class PreferencesManager {

    private static PreferencesManager sInstance;
    private static SharedPreferences sPreferences;

    public PreferencesManager() {
        sPreferences = App.getInstance().getApplicationContext()
                .getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }

    public static PreferencesManager getInstance() {
        if (sInstance == null)
            sInstance = new PreferencesManager();
        return sInstance;
    }

    public void saveMyString(String string) {
        sPreferences.edit().putString("my_string", string).apply();
    }

    public String loadMyString() {
        return sPreferences.getString("my_string", "null");
    }

}
