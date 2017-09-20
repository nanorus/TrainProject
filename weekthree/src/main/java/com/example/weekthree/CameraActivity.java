package com.example.weekthree;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CameraActivity extends AppCompatActivity {
    final int REQUEST_IMAGE_CAPTURE = 1;
     String APP_DIRECTORY = null;

    @BindView(R.id.activity_camera_iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.activity_camera_btn_default)
    Button btnCameraDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        APP_DIRECTORY = this.getApplicationInfo().dataDir + "/";
        ButterKnife.bind(this);

        ivPhoto.setImageBitmap(loadImage());

    }

    @OnClick({R.id.activity_camera_btn_default})
    void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_camera_btn_default:
                dispatchTakePictureIntent();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            saveImage(imageBitmap);
            ivPhoto.setImageBitmap(loadImage());
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void saveImage(Bitmap data) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(APP_DIRECTORY + "avatar.png");
            data.compress(Bitmap.CompressFormat.PNG, 100, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Bitmap loadImage() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeFile(APP_DIRECTORY + "avatar.png", options);
    }
}
