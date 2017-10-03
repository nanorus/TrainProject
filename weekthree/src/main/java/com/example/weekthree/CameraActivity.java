package com.example.weekthree;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CameraActivity extends AppCompatActivity {

    final int ACTIVITY_RESULT_REQUEST_IMAGE_CAPTURE = 1;
    final int PERMISSION_REQUEST_CODE_TAKE_PHOTO = 1;
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
        if (requestCode == ACTIVITY_RESULT_REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            saveImage(imageBitmap);
            ivPhoto.setImageBitmap(loadImage());
        }
    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                startActivityForResult(takePictureIntent, ACTIVITY_RESULT_REQUEST_IMAGE_CAPTURE);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, PERMISSION_REQUEST_CODE_TAKE_PHOTO);
            }

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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE_TAKE_PHOTO:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    dispatchTakePictureIntent();
                else
                    Toast.makeText(this, "Lets grand the permission for camera!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
