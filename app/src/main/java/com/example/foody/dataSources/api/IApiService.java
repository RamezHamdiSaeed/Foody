package com.example.foody.dataSources.api;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiService {
    @GET("random.php")
    public Single<Response> getRandomMeal();
    @GET("search.php")
    Single<Response> getMeals(@Query("f") String letters);

}