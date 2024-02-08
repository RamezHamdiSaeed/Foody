package com.example.foody.dataSources.api;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface IApiService {
    @GET("random.php")
    public Single<Response> getRandomMeal();

}