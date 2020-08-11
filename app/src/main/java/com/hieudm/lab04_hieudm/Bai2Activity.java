package com.hieudm.lab04_hieudm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Bai2Activity extends AppCompatActivity {
    private Button btnNetWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);


        btnNetWork = (Button) findViewById(R.id.btnNetWork);

        btnNetWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkNetworkStatus();
            }

        });
    }

    private void checkNetworkStatus() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        boolean isWifi = networkInfo.isConnected();

        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        boolean isMobile = networkInfo.isConnected();


        if (isWifi) Toast.makeText(this,
                "Wifi Connected!!!", Toast.LENGTH_SHORT).show();

        if (isMobile) Toast.makeText(this,
                "Mobile Connected!!!", Toast.LENGTH_SHORT).show();

    }
}
