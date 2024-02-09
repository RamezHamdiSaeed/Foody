package com.example.foody.dataSources.api.models.category;


import java.util.List;

public interface NetworkListener {
    void onDataFetched(List<MealsItem> categories);

    void onDataFailed();
}
