package com.example.foody.screens.main.pages.home.model;

import android.util.Log;

import com.example.foody.dataSources.api.FiltersRemoteRepository;
import com.example.foody.dataSources.api.FoodRemoteRepository;
import com.example.foody.dataSources.api.models.meals.NetworkListener;
import com.example.foody.screens.main.pages.home.IContract;

public class HomeModel implements IContract.IModel {
    private static final String TAG="HomeModel";
    @Override
    public void getMealsByString(String string, NetworkListener networkListener) {
        Log.i(TAG, "getMealsByString: "+string);
        FoodRemoteRepository.getClient().getMealsByLetters(string, networkListener);
    }

    @Override
    public void getCategories(com.example.foody.dataSources.api.models.category.NetworkListener networkListener) {
        FiltersRemoteRepository.getClient().getCategories(networkListener);

    }

    @Override
    public void getMealsByCategory(String string, NetworkListener networkListener) {
        FoodRemoteRepository.getClient().getMealsByCategory(string, networkListener);

    }

    @Override
    public void getCountries(com.example.foody.dataSources.api.models.country.NetworkListener networkListener) {
        FiltersRemoteRepository.getClient().getCountries(networkListener);

    }

    @Override
    public void getMealsByCountry(String string, NetworkListener networkListener) {
        FoodRemoteRepository.getClient().getMealsByCountry(string, networkListener);

    }

    @Override
    public void getIngredients(com.example.foody.dataSources.api.models.ingredient.NetworkListener networkListener) {
        FiltersRemoteRepository.getClient().getIngredients(networkListener);

    }

    @Override
    public void getMealsByIngredient(String string, NetworkListener networkListener) {
        FoodRemoteRepository.getClient().getMealsByIngredient(string, networkListener);

    }
}
