package com.example.foody.dataSources.localDB;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.foody.dataSources.api.models.meals.MealsItem;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class MealsLocalDataSourceImpl implements MealsLocalDataSource {
    private MealsDAO dao;
    private static MealsLocalDataSourceImpl localSrc=null;
    private Observable<List<MealsItem>> storedProducts;

    private MealsLocalDataSourceImpl(Context context){
        ProductDataBase db = ProductDataBase.getInstance(context.getApplicationContext());
        dao = db.getProductDAO();
        storedProducts =dao.getAllMeals();
    }
    public static MealsLocalDataSourceImpl getInstance(Context context){
        if(localSrc==null){
            localSrc = new MealsLocalDataSourceImpl(context);
        }
        return localSrc;
    }

    @Override
    public void insertProduct(MealsItem mealModel) {
        dao.insertMeal(mealModel);
    }

    @Override
    public void deleteProduct(MealsItem mealModel) {
        dao.deleteMeal(mealModel);
    }

    @Override
    public Observable<List<MealsItem>> getAllStoredMeals() {
        return dao.getAllMeals();
    }

}
