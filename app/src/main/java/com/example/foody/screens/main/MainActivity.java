package com.example.foody.screens.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foody.R;
import com.example.foody.dataSources.api.FoodRemoteDataSource;
import com.example.foody.dataSources.api.MealsItem;
import com.example.foody.dataSources.api.NetworkListener;
import com.example.foody.dataSources.firebase.UserRepository;
import com.example.foody.screens.info.InfoActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NetworkListener {
    private long pressedTime;

    private BottomNavigationView bottomNavigationView;
    NavController navController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FoodRemoteDataSource.getClient().getRandomMeal(this);

    }

    @Override
    public void onBackPressed() {
        if (pressedTime + 10000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            showExitDialog();
        }
        pressedTime = System.currentTimeMillis();
    }




    private void showSuggestedMealDialog(MealsItem meal){
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.layout_suggestion_dialog);

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_window);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        ImageView randomMealImage=dialog.findViewById(R.id.randomMealImg);
        TextView randomMealTitle=dialog.findViewById(R.id.mealTitle);
        randomMealTitle.setText(meal.getStrMeal());
        Glide.with(this).load(meal.getStrMealThumb()).into(randomMealImage);

        Button oK=dialog.findViewById(R.id.btn_cancel);
        oK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("mealID", meal.getIdMeal());

                startActivity(intent);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
    private void showExitDialog(){
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.layout_exit_dialog);

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_window);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        Button cancel=dialog.findViewById(R.id.btn_cancel);
        Button exit=dialog.findViewById(R.id.btn_exit);
        Button signOutAndExit=dialog.findViewById(R.id.btn_sign_out_exit);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        signOutAndExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRepository.getInstance().signOut();
                finishAffinity();
            }
        });


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
    @Override
    public void onDataFetched(List<MealsItem> meals) {
    showSuggestedMealDialog(meals.get(0));
    }

    @Override
    public void onDataFailed() {
        Log.d("randomMeal", "onDataFailed: ");
    }
}