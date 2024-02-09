package com.example.foody.screens.info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.foody.R;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent = getIntent();
        if (intent != null) {
            String mealID = intent.getStringExtra("mealID");
            Toast myToast = Toast.makeText(this, "mealID "+mealID, Toast.LENGTH_LONG);
            myToast.show();
        }
    }
}