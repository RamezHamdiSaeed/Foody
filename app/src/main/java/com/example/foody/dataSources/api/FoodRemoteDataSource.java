package com.example.foody.dataSources.api;

import android.util.Log;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodRemoteDataSource {


    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private static IApiService apiInterface = null;
    private static FoodRemoteDataSource retrofitClient = null;

    private FoodRemoteDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        apiInterface = retrofit.create(IApiService.class);
    }

    public static FoodRemoteDataSource getClient() {
        if (apiInterface == null) {
            retrofitClient = new FoodRemoteDataSource();
        }
        return retrofitClient;
    }

    public void getRandomMeal(NetworkListener listener) {
        Single<Response> productsObservable = apiInterface.getRandomMeal();
        productsObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(item -> {
            List<MealsItem> meals = item.getMeals();
            listener.onDataFetched(meals);
        }, throwable -> {
            Log.i("Retrofit", "fetchDataFromApi: ");
        });


    }

}

