package com.example.foody.dataSources.api;

import android.util.Log;

import com.example.foody.dataSources.api.models.category.CategoryResponse;
import com.example.foody.dataSources.api.models.category.MealsItem;
import com.example.foody.dataSources.api.models.category.NetworkListener;
import com.example.foody.dataSources.api.models.country.CountryResponse;
import com.example.foody.dataSources.api.models.ingredient.IngredientResponse;
import com.example.foody.dataSources.api.models.meals.Response;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FiltersRemoteRepository {


    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private static IApiService apiInterface = null;
    private static FiltersRemoteRepository retrofitClient = null;

    private FiltersRemoteRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        apiInterface = retrofit.create(IApiService.class);
    }

    public static FiltersRemoteRepository getClient() {
        if (apiInterface == null) {
            retrofitClient = new FiltersRemoteRepository();
        }
        return retrofitClient;
    }


    public void getCategories(NetworkListener listener) {
        Single<CategoryResponse> categoriesObservable = apiInterface.getCategories();

        categoriesObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(item -> {
            List<MealsItem> meals = item.getMeals();
            Log.i("foodServiceDataSource", "getMealsByLetters: "+meals.size());
            listener.onDataFetched(meals);
        }, throwable -> {
            Log.i("Retrofit", "fetchDataFromApi: ");
        });

    }
    public void getCountries(com.example.foody.dataSources.api.models.country.NetworkListener listener) {
        Single<CountryResponse> countriesObservable = apiInterface.getCountries();

        countriesObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(item -> {
            List<com.example.foody.dataSources.api.models.country.MealsItem> meals = item.getMeals();
            Log.i("foodServiceDataSource", "getMealsByLetters: "+meals.size());
            listener.onDataFetched(meals);
        }, throwable -> {
            Log.i("Retrofit", "fetchDataFromApi: ");
        });

    }
    public void getIngredients(com.example.foody.dataSources.api.models.ingredient.NetworkListener listener) {
        Single<IngredientResponse> ingredientsObservable = apiInterface.getIngredients();

        ingredientsObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(item -> {
            List<com.example.foody.dataSources.api.models.ingredient.MealsItem> meals = item.getMeals();
            Log.i("foodServiceDataSource", "getMealsByLetters: "+meals.size());
            listener.onDataFetched(meals);
        }, throwable -> {
            Log.i("Retrofit", "fetchDataFromApi: ");
        });

    }



}



