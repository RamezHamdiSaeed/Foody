package com.example.foody.dataSources.localDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foody.dataSources.api.models.meals.MealsItem;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

@Dao
public interface MealsDAO {
    @Query("SELECT * From meals_table")
    Observable<List<MealsItem>> getAllMeals();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMeal(MealsItem productModel);
    @Delete
    void deleteMeal(MealsItem productModel);
}
