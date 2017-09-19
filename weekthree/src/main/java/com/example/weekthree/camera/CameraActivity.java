package com.example.weekthree.camera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.weekthree.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CameraActivity extends AppCompatActivity {

    @BindView(R.id.activity_camera_btn_app)
    Button btnCameraApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.activity_camera_btn_app})
    void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_camera_btn_app:
                startActivityForResult(new Intent(this, TakePhotoActivity.class), 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // this is received image
        byte[] imageBytes = getIntent().getByteArrayExtra("image");
        Toast.makeText(this, "image successful received", Toast.LENGTH_SHORT).show();

        // save image

        // load image

    }
}
