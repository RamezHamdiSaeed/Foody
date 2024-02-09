package com.example.foody.screens.main.pages.home.presenter;

import android.content.Context;
import android.util.Log;

import com.example.foody.dataSources.api.MealsItem;
import com.example.foody.screens.main.pages.home.IContract;
import com.example.foody.dataSources.api.NetworkListener;
import com.example.foody.screens.main.pages.home.ui.MealModel;
import com.example.foody.screens.main.pages.home.ui.MealsGridViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomePresenter implements IContract.IPresenter, NetworkListener{
    IContract.IView view;
    IContract.IModel model;
     ArrayList<MealModel> gridViewMeals;
     private static final String TAG="HomePresenter";

    MealsGridViewAdapter adapter ;
     public HomePresenter(IContract.IView view,IContract.IModel model){
         this.view=view;
         this.model=model;
         gridViewMeals= new ArrayList<>();
     }

    @Override
    public void onDataFetched(List<MealsItem> meals) {
         gridViewMeals.clear();
        Log.i(TAG, "onDataFetched: "+meals.size());
                for(MealsItem meal : meals){
                    gridViewMeals.add(new MealModel(meal.getStrMealThumb(),meal.getStrMeal()));

                }
                if(view!=null) {
                    view.showMealsInGridView(adapter, gridViewMeals);
                }
                else{
                    Log.i(TAG, "onDataFetched: view is Null");
                }

    }

    @Override
    public void onDataFailed() {
        Log.i(TAG, "onDataFailed: Networking Issues");
    }

    @Override
    public void onSearchEnterKeyPressed(Context context, String keyword) {
        setMealsGridView(context,keyword);
    }

    @Override
    public void onDestroy() {
        view=null;
    }

    @Override
    public void setMealsGridView(Context context, String keyword){
        Log.i(TAG, "setMealsGridView: String "+keyword);
         model.getMealsByString(keyword,this);
   }
}
