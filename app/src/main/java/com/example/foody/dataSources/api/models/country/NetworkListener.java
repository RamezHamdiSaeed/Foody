package com.example.foody.dataSources.api.models.country;


import java.util.List;

public interface NetworkListener {
    void onDataFetched(List<MealsItem> countries);

    void onDataFailed();
}
