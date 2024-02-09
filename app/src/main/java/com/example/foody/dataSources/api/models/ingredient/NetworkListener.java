package com.example.foody.dataSources.api.models.ingredient;


import java.util.List;

public interface NetworkListener {
    void onDataFetched(List<MealsItem> ingredients);

    void onDataFailed();
}
