package com.example.foody.screens.main.pages.home.ui;

import android.content.Context;
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

import java.util.ArrayList;

public class MealsGridViewAdapter extends ArrayAdapter<MealModel> {
    public MealsGridViewAdapter(@NonNull Context context, ArrayList<MealModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
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

        mealTitle.setText(meal.getStrMeal());
        Glide.with(getContext()).load(meal.getStrMealThumb()).into(mealImg);

        return listitemView;
    }
}
