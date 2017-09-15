package com.example.weekthree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_btn_task_1)
    Button btnTask1;
    @BindView(R.id.main_btn_task_2)
    Button btnTask2;
    @BindView(R.id.main_btn_task_3)
    Button btnTask3;
    @BindView(R.id.main_btn_task_4)
    Button btnTask4;
    @BindView(R.id.main_btn_task_5)
    Button btnTask5;
    @BindView(R.id.main_btn_task_6)
    Button btnTask6;
    @BindView(R.id.main_btn_task_7)
    Button btnTask7;
    @BindView(R.id.main_btn_task_8)
    Button btnTask8;
    @BindView(R.id.main_btn_task_9)
    Button btnTask9;
    @BindView(R.id.main_btn_task_10)
    Button btnTask10;
    @BindView(R.id.main_btn_task_11)
    Button btnTask11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.main_btn_task_1, R.id.main_btn_task_2, R.id.main_btn_task_3, R.id.main_btn_task_4,
            R.id.main_btn_task_5, R.id.main_btn_task_6, R.id.main_btn_task_7, R.id.main_btn_task_8,
            R.id.main_btn_task_9, R.id.main_btn_task_10, R.id.main_btn_task_11})
    public void onClickTaskButton(Button button) {
        Intent intent;
        switch (button.getId()) {
            case R.id.main_btn_task_1:

                break;
            case R.id.main_btn_task_2:

                break;
            case R.id.main_btn_task_3:

                break;
            case R.id.main_btn_task_4:

                break;
            case R.id.main_btn_task_5:

                break;
            case R.id.main_btn_task_6:

                break;
            case R.id.main_btn_task_7:

                break;
            case R.id.main_btn_task_8:

                break;
            case R.id.main_btn_task_9:

                break;
            case R.id.main_btn_task_10:

                break;
            case R.id.main_btn_task_11:

                break;
        }
    }
}
