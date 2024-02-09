package com.example.foody.screens.main.pages.home;

import android.content.Context;

import com.example.foody.dataSources.api.NetworkListener;
import com.example.foody.screens.main.pages.home.ui.MealModel;
import com.example.foody.screens.main.pages.home.ui.MealsGridViewAdapter;

import java.util.ArrayList;

public interface IContract {
    public interface IModel{
        public void getMealsByString(String string, NetworkListener networkListener);
    }
    public interface IView{
        public void showMealsInGridView(MealsGridViewAdapter adapter, ArrayList<MealModel> gridViewMeals);
    }
    public interface IPresenter{
       // public void addMeal(MealsItem meal);
        //public void getMeals();
        public void onSearchEnterKeyPressed(Context context, String keyword);
        public void setMealsGridView(Context context, String keyword);
        void onDestroy();

    }
}
