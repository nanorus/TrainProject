package com.example.weekthree.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.weekthree.App;

public class PreferencesManager {

    private static PreferencesManager sInstance;
    private static SharedPreferences sPreferences;

    public PreferencesManager() {
        if (sPreferences == null)
            sPreferences = App.getInstance().getApplicationContext()
                    .getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }

    public static PreferencesManager getInstance() {
        if (sInstance == null)
            sInstance = new PreferencesManager();
        return sInstance;
    }

    public void setMyString(String string) {
        sPreferences.edit().putString("my_string", string).apply();
    }

    public String getMyString() {
        return sPreferences.getString("my_string", "null");
    }

    public void setDbType(int dbType) {
        sPreferences.edit().putInt("db_type", dbType).apply();
    }

    public int getDbType() {
        return sPreferences.getInt("db_type", 0);
    }
}
