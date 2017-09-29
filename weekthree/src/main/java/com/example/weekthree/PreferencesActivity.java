package com.example.weekthree;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class PreferencesActivity extends PreferenceActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Toast.makeText(this, "text 1: " + preferences.getString("savedText1", "null"), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "text 2: " + preferences.getString("savedText2", "null"), Toast.LENGTH_SHORT).show();
    }
}
