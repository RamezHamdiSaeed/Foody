package com.example.foody.dataSources.localDB;

import androidx.lifecycle.LiveData;

import com.example.foody.dataSources.api.models.meals.MealsItem;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface MealsLocalDataSource {
    void insertProduct(MealsItem mealModel);
    void deleteProduct(MealsItem mealModel);
    Observable<List<MealsItem>> getAllStoredMeals();
}
