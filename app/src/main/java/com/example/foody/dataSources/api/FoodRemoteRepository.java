package com.example.foody.dataSources.api;

import android.util.Log;

import com.example.foody.dataSources.api.models.meals.MealsItem;
import com.example.foody.dataSources.api.models.meals.NetworkListener;
import com.example.foody.dataSources.api.models.meals.Response;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodRemoteRepository {


    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private static IApiService apiInterface = null;
    private static FoodRemoteRepository retrofitClient = null;

    private FoodRemoteRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        apiInterface = retrofit.create(IApiService.class);
    }

    public static FoodRemoteRepository getClient() {
        if (apiInterface == null) {
            retrofitClient = new FoodRemoteRepository();
        }
        return retrofitClient;
    }

    public void getRandomMeal(NetworkListener listener) {
        Single<Response> mealsObservable = apiInterface.getRandomMeal();
        mealsObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(item -> {
            List<MealsItem> meals = item.getMeals();
            listener.onDataFetched(meals);
        }, throwable -> {
            Log.i("Retrofit", "fetchDataFromApi: ");
        });
    }
    public void getMeal(String id,NetworkListener listener) {
        Single<Response> mealObservable = apiInterface.getMeal(id);
        mealObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(item -> {
            List<MealsItem> meals = item.getMeals();
            listener.onDataFetched(meals);
        }, throwable -> {
            Log.i("Retrofit", "fetchDataFromApi: ");
        });
    }
    public void getMealsByLetters(String letters, NetworkListener listener) {
        Observable<Response> mealsObservable = apiInterface.getMeals(letters);

        mealsObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(response -> {
                    List<MealsItem> meals = response.getMeals();
                    return Observable.fromIterable(meals);
                })
                .toList()
                .subscribe(
                        meals -> {
                            Log.i("foodServiceDataSource", "getMealsByLetters: " + meals.size());
                            listener.onDataFetched(meals);
                        },
                        throwable -> {
                            Log.e("Retrofit", "fetchDataFromApi: ", throwable);
                        }
                );
    }
    public void getMealsByIngredient(String ingredientText,NetworkListener listener) {
        Single<Response> mealsObservable = apiInterface.getMealsByIngredient(ingredientText);

        mealsObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(item -> {
            List<com.example.foody.dataSources.api.models.meals.MealsItem> meals = item.getMeals();
            Log.i("foodServiceDataSource", "getMealsByLetters: "+meals.size());
            listener.onDataFetched(meals);
        }, throwable -> {
            Log.i("Retrofit", "fetchDataFromApi: ");
        });

    }
    public void getMealsByCountry(String countryText,NetworkListener listener) {
        Single<Response> mealsObservable = apiInterface.getMealsByCountry(countryText);
        mealsObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(item -> {
            List<com.example.foody.dataSources.api.models.meals.MealsItem> meals = item.getMeals();
            Log.i("foodServiceDataSource", "getMealsByLetters: "+meals.size());
            listener.onDataFetched(meals);
        }, throwable -> {
            Log.i("Retrofit", "fetchDataFromApi: ");
        });

    }
    public void getMealsByCategory(String category,NetworkListener listener) {
        Single<Response> mealsObservable = apiInterface.getMealsByCategory(category);
        mealsObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(item -> {
            List<com.example.foody.dataSources.api.models.meals.MealsItem> meals = item.getMeals();
            Log.i("foodServiceDataSource", "getMealsByLetters: "+meals.size());
            listener.onDataFetched(meals);
        }, throwable -> {
            Log.i("Retrofit", "fetchDataFromApi: ");
        });

    }


}



