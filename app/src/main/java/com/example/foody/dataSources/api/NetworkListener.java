package com.example.foody.dataSources.api;

import java.util.List;

public interface NetworkListener {
    void onDataFetched(List<MealsItem> meals);

    void onDataFailed();
}
