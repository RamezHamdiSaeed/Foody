package com.example.foody.screens.main.pages.home.ui;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.foody.R;
import com.example.foody.screens.info.InfoActivity;
import com.example.foody.screens.main.MainActivity;
import com.example.foody.screens.main.pages.home.presenter.IHomePageNavigateCallBack;

import java.util.ArrayList;

public class MealsGridViewAdapter extends ArrayAdapter<MealModel> {
    IHomePageNavigateCallBack callBack;
    public MealsGridViewAdapter(@NonNull Context context, ArrayList<MealModel> mealModelArrayList, IHomePageNavigateCallBack callBack) {
        super(context, 0, mealModelArrayList);
        this.callBack=callBack;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        MealModel meal = getItem(position);
        TextView mealTitle = listitemView.findViewById(R.id.mealCardTitle);
        ImageView mealImg = listitemView.findViewById(R.id.mealImg);
        mealImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.startNavigation(meal.getIdMeal());
            }
        });

        mealTitle.setText(meal.getStrMeal());
        Glide.with(getContext()).load(meal.getStrMealThumb()).into(mealImg);

        return listitemView;
    }
}
