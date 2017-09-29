package com.example.weekthree;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.X;

public class LocationActivity extends AppCompatActivity {

    @BindView(R.id.activity_location_tv_test)
    TextView tv_test;

    private LocationManager locationManager;
    StringBuilder location;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        ButterKnife.bind(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        location = new StringBuilder();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // permission granted
            requestLocationUpdates();
        } else {
            // deny
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION
            }, 0);
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(locationListener);
        tv_test.setText("Отключено");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 0 && grantResults.length == 2) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                requestLocationUpdates();
            } else {
                tv_test.setText("Нет прав");
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }

    private void requestLocationUpdates() {
        tv_test.setText("Ищем координаты..");
        if (locationManager.getAllProviders().contains(LocationManager.GPS_PROVIDER))
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        else {
            Toast.makeText(this, "Нет провайдера GPS", Toast.LENGTH_SHORT).show();
        }
        if (locationManager.getAllProviders().contains(LocationManager.NETWORK_PROVIDER))
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000 * 60 * 1, 0, locationListener);
        else
            Toast.makeText(this, "Нет провайдера NETWORK", Toast.LENGTH_SHORT).show();
    }

    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Double longitute = location.getLongitude();
            Double latitude = location.getLatitude();
            Double altitide = location.getAltitude();
            LocationActivity.this.location.setLength(0);
            LocationActivity.this.location
                    .append("X: ").append(String.valueOf(longitute))
                    .append("\nY: ").append(String.valueOf(latitude))
                    .append("\nZ: ").append(String.valueOf(altitide));
            Geocoder geocoder = new Geocoder(LocationActivity.this, Locale.getDefault());
            List<Address> addresses = null;

            try {
                addresses = geocoder.getFromLocation(latitude, longitute, 1);
                if (addresses.size() > 0) {
                    LocationActivity.this.location.append(addresses.get(0).getLocality());
                } else {
                    LocationActivity.this.location.append("no city");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            tv_test.setText(LocationActivity.this.location);
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

}
