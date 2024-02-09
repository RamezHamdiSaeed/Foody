package com.example.foody.screens.main.pages.home;

import android.content.Context;

import com.example.foody.dataSources.api.models.meals.NetworkListener;
import com.example.foody.screens.main.pages.home.ui.BottomSheet;
import com.example.foody.screens.main.pages.home.ui.MealModel;
import com.example.foody.screens.main.pages.home.ui.MealsGridViewAdapter;

import java.util.ArrayList;
import java.util.List;

public interface IContract {
    public interface IModel{
        public void getMealsByString(String string, NetworkListener networkListener);
        public void getCategories(com.example.foody.dataSources.api.models.category.NetworkListener networkListener);
        public void getMealsByCategory(String string, NetworkListener networkListener);

        public void getCountries(com.example.foody.dataSources.api.models.country.NetworkListener networkListener);
        public void getMealsByCountry(String string, NetworkListener networkListener);

        public void getIngredients(com.example.foody.dataSources.api.models.ingredient.NetworkListener networkListener);
        public void getMealsByIngredient(String string, NetworkListener networkListener);



    }
    public interface IView{
        public void showMealsInGridView(MealsGridViewAdapter adapter, ArrayList<MealModel> gridViewMeals);
        public void showFiltersInBottomSheet(BottomSheet bottomSheetFragment);
    }
    public interface IPresenter{
       // public void addMeal(MealsItem meal);
        //public void getMeals();
        public void onSearchEnterKeyPressed(Context context, String keyword);
        public void setMealsGridView(Context context, String keyword);
        public void getFilters();
        public void setBottomSheet();
        void onDestroy();

    }
}
