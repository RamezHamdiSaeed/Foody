package com.example.foody.dataSources.api.models.meals;

import com.example.foody.dataSources.api.models.meals.MealsItem;

import java.util.List;

public interface NetworkListener {
    void onDataFetched(List<MealsItem> meals);

    void onDataFailed();
}
