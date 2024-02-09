package com.example.foody.screens.onBoarding;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.foody.R;
import com.example.foody.screens.auth.view.SignInActivity;
import com.example.foody.ui.viewPager.VPAdapter;
import com.example.foody.ui.viewPager.ViewPagerItem;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;


import androidx.viewpager2.widget.ViewPager2;


import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    ArrayList<ViewPagerItem> viewPagerItemArrayList;
    Button nextbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = this.getSharedPreferences("YourSharedPreferencesName", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("FirstTime", true)){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("FirstTime", false);
            editor.apply();
        }
        else{
            Intent intent = new Intent(ViewPagerActivity.this, SignInActivity.class);
            startActivity(intent);
        }
        setContentView(R.layout.activity_view_pager);
        viewPager2 = findViewById(R.id.viewPager);
        nextbtn=findViewById(R.id.nextbtn);

        int[] images = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
        String[] heading = {"Baked","Grilled","Dessert","Italian","Shakes"};
        String[] desc = {getString(R.string.a_desc),
                getString(R.string.b_desc),
                getString(R.string.c_desc),
                getString(R.string.d_desc)
                ,getString(R.string.e_desc)};

        viewPagerItemArrayList = new ArrayList<>();

        for (int i =0; i< images.length ; i++){

            ViewPagerItem viewPagerItem = new ViewPagerItem(images[i],heading[i],desc[i]);
            viewPagerItemArrayList.add(viewPagerItem);

        }

        VPAdapter vpAdapter = new VPAdapter(viewPagerItemArrayList);

        viewPager2.setAdapter(vpAdapter);

        viewPager2.setClipToPadding(false);

        viewPager2.setClipChildren(false);

        viewPager2.setOffscreenPageLimit(2);

        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        nextbtn.setOnClickListener(v -> {
            Intent intent = new Intent(ViewPagerActivity.this, SignInActivity.class);
            startActivity(intent);
        });



    }


}