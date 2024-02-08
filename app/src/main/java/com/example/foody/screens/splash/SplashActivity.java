package com.example.foody.screens.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foody.R;
import com.example.foody.screens.onBoarding.ViewPagerActivity;

public class SplashActivity extends AppCompatActivity {
    Button startCooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startCooking=findViewById(R.id.signInbtn);
        startCooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, ViewPagerActivity.class);
                startActivity(intent);
            }
        });
    }
}