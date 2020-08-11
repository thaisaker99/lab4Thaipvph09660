package com.hieudm.lab04_hieudm;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bai1Activity extends AppCompatActivity {

    private Button btnLoation;
    private TextView tvLongtitude;
    private TextView tvLatitude;
    private TextView tvCao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);


        btnLoation = (Button) findViewById(R.id.btnLoation);
        tvLongtitude = (TextView) findViewById(R.id.tvLongtitude);
        tvLatitude = (TextView) findViewById(R.id.tvLatitude);
        tvCao = findViewById(R.id.tvcao);
        btnLoation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestMyLocation();
            }
        });
    }

    private void requestMyLocation() {
        // khoi tao class LocationManager de truy cap GPS
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                tvLatitude.setText(location.getLatitude() + "");
                tvLongtitude.setText(location.getLongitude() + "");
                tvCao.setText(location.getAltitude() + "");

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
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {


            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION}
                    , 999);
        } else {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0, 0, locationListener);
        }

        // request vi tri thong qua ham requestLocationUpdates

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.e("onRequestPermissions", "onRequestPermissionsResult : " + requestCode);
    }

}

