package com.example.foody.screens.main.pages.home.presenter;

import android.content.Context;
import android.util.Log;

import com.example.foody.dataSources.api.models.meals.MealsItem;
import com.example.foody.screens.main.pages.home.IContract;
import com.example.foody.dataSources.api.models.meals.NetworkListener;
import com.example.foody.screens.main.pages.home.ui.BottomSheet;
import com.example.foody.screens.main.pages.home.ui.MealModel;
import com.example.foody.screens.main.pages.home.ui.MealsGridViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomePresenter implements IContract.IPresenter, NetworkListener,IHomePageNavigateCallBack{
    IContract.IView view;
    IContract.IModel model;
     ArrayList<MealModel> gridViewMeals;
     private static final String TAG="HomePresenter";
    List<String> categoriesItems=new ArrayList<>();
    List<String> countriesItems=new ArrayList<>();
    List<String> ingredientsItems=new ArrayList<>();

    MealsGridViewAdapter adapter ;
     public HomePresenter(IContract.IView view,IContract.IModel model){
         this.view=view;
         this.model=model;
         gridViewMeals= new ArrayList<>();
     }

    @Override
    public void onDataFetched(List<MealsItem> meals) {
       setGridViewMeals(meals);

    }
    public void setGridViewMeals(List<MealsItem> meals){
        gridViewMeals.clear();
        Log.i(TAG, "onDataFetched: "+meals.size());
        for(MealsItem meal : meals){
            gridViewMeals.add(new MealModel(meal.getStrMealThumb(),meal.getStrMeal(),meal.getIdMeal()));

        }
        if(view!=null) {
            view.showMealsInGridView(adapter, gridViewMeals, new IHomePageNavigateCallBack() {
                @Override
                public void startNavigation(String mealID) {
                    view.navigateToInfoScreen(mealID);
                }
            });
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

    @Override
    public void getFilters() {
        model.getCategories(new com.example.foody.dataSources.api.models.category.NetworkListener() {
            @Override
            public void onDataFetched(List<com.example.foody.dataSources.api.models.category.MealsItem> categories) {
                for(com.example.foody.dataSources.api.models.category.MealsItem category : categories){
                    categoriesItems.add(category.getStrCategory());
                }
            }

            @Override
            public void onDataFailed() {
                Log.i(TAG, "onDataFailed: ");
            }
        });
        model.getCountries(new com.example.foody.dataSources.api.models.country.NetworkListener() {
            @Override
            public void onDataFetched(List<com.example.foody.dataSources.api.models.country.MealsItem> countries) {
                for(com.example.foody.dataSources.api.models.country.MealsItem country : countries){
                    countriesItems.add(country.getStrArea());
                }

            }

            @Override
            public void onDataFailed() {
                Log.i(TAG, "onDataFailed: ");
            }
        });
        model.getIngredients(new com.example.foody.dataSources.api.models.ingredient.NetworkListener() {
            @Override
            public void onDataFetched(List<com.example.foody.dataSources.api.models.ingredient.MealsItem> ingredients) {
                for(com.example.foody.dataSources.api.models.ingredient.MealsItem ingredient : ingredients){
                    ingredientsItems.add(ingredient.getStrIngredient());
                }
            }

            @Override
            public void onDataFailed() {
                Log.i(TAG, "onDataFailed: ");
            }
        });
    }

    @Override
    public void setBottomSheet() {
        BottomSheet bottomSheetFragment = new BottomSheet(categoriesItems, countriesItems, ingredientsItems, new NetworkListener() {
            @Override
            public void onDataFetched(List<MealsItem> meals) {
                setGridViewMeals(meals);
            }

            @Override
            public void onDataFailed() {
                Log.i(TAG, "onDataFailed: ");
            }
        }, new NetworkListener() {
            @Override
            public void onDataFetched(List<MealsItem> meals) {
                setGridViewMeals(meals);

            }

            @Override
            public void onDataFailed() {
                Log.i(TAG, "onDataFailed: ");

            }
        }, new NetworkListener() {
            @Override
            public void onDataFetched(List<MealsItem> meals) {
                setGridViewMeals(meals);

            }

            @Override
            public void onDataFailed() {
                Log.i(TAG, "onDataFailed: ");

            }
        });
        view.showFiltersInBottomSheet(bottomSheetFragment);

    }

    @Override
    public void startNavigation(String mealID) {
        view.navigateToInfoScreen(mealID);
    }
}
