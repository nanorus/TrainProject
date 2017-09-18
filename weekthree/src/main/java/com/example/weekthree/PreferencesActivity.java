package com.example.weekthree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.weekthree.data.preferences.PreferencesManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PreferencesActivity extends AppCompatActivity {

    @BindView(R.id.activity_preferences_et_string)
    EditText et_string;
    @BindView(R.id.activity_preferences_tv_string)
    TextView tv_string;
    @BindView(R.id.activity_preferences_btn_save)
    Button btn_save;
    @BindView(R.id.activity_preferences_btn_load)
    Button btn_load;

    PreferencesManager mPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        ButterKnife.bind(this);

        mPreferencesManager = PreferencesManager.getInstance();
    }

    @OnClick(value = {R.id.activity_preferences_btn_save, R.id.activity_preferences_btn_load})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.activity_preferences_btn_save:
                if (et_string.getText() != null)
                    mPreferencesManager.saveMyString(et_string.getText().toString());
                break;
            case R.id.activity_preferences_btn_load:
                tv_string.setText(mPreferencesManager.loadMyString());
                break;
            default:
                break;
        }
    }
}
