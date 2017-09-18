package com.example.weekthree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_btn_task_query)
    Button btnQuery;
    @BindView(R.id.main_btn_task_realm)
    Button btnRealm;
    @BindView(R.id.main_btn_task_sqlite)
    Button btnSqlite;
    @BindView(R.id.main_btn_task_preferences)
    Button btnPreferences;
    @BindView(R.id.main_btn_task_internet_connection)
    Button btnInternetConnection;
    @BindView(R.id.main_btn_task_location)
    Button btnLocation;
    @BindView(R.id.main_btn_task_accelerometer)
    Button btnAccelerometer;
    @BindView(R.id.main_btn_task_camera)
    Button btnCamera;
    @BindView(R.id.main_btn_task_custom_view)
    Button btnCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.main_btn_task_query, R.id.main_btn_task_realm, R.id.main_btn_task_sqlite,
            R.id.main_btn_task_preferences, R.id.main_btn_task_internet_connection, R.id.main_btn_task_location,
            R.id.main_btn_task_accelerometer, R.id.main_btn_task_camera, R.id.main_btn_task_custom_view})
    public void onClickTaskButton(Button button) {
        Intent intent = null;
        switch (button.getId()) {
            case R.id.main_btn_task_query:

                break;
            case R.id.main_btn_task_realm:

                break;
            case R.id.main_btn_task_sqlite:

                break;
            case R.id.main_btn_task_preferences:
                intent = new Intent(this, PreferencesActivity.class);
                break;
            case R.id.main_btn_task_internet_connection:

                break;
            case R.id.main_btn_task_location:
                intent = new Intent(this, LocationActivity.class);
                break;
            case R.id.main_btn_task_accelerometer:
                intent = new Intent(this, AccelerometerActivity.class);
                break;
            case R.id.main_btn_task_camera:

                break;
            case R.id.main_btn_task_custom_view:

                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
