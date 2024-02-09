package com.example.foody.screens.main.pages.home.model;

import android.util.Log;

import com.example.foody.dataSources.api.FoodRemoteDataSource;
import com.example.foody.dataSources.api.MealsItem;
import com.example.foody.dataSources.api.NetworkListener;
import com.example.foody.screens.main.pages.home.IContract;
import com.example.foody.screens.main.pages.home.ui.MealModel;

import java.util.List;

public class HomeModel implements IContract.IModel {
    private static final String TAG="HomeModel";
    @Override
    public void getMealsByString(String string, NetworkListener networkListener) {
        Log.i(TAG, "getMealsByString: "+string);
        FoodRemoteDataSource.getClient().getMealsByLetters(string, networkListener);
    }
}
