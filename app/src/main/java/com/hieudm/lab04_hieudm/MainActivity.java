package com.hieudm.lab04_hieudm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnBai1;
    private Button btnBai2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBai1 = (Button) findViewById(R.id.btnBai1);
        btnBai2 = (Button) findViewById(R.id.btnBai2);

        final Intent intent = new Intent(MainActivity.this, Bai1Activity.class);
        final Intent intent1 = new Intent(MainActivity.this, Bai2Activity.class);





        btnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
    }
}


