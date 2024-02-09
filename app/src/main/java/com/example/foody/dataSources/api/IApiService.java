package com.example.foody.dataSources.api;

import com.example.foody.dataSources.api.models.category.CategoryResponse;
import com.example.foody.dataSources.api.models.country.CountryResponse;
import com.example.foody.dataSources.api.models.ingredient.IngredientResponse;
import com.example.foody.dataSources.api.models.meals.Response;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiService {
    @GET("random.php")
    public Single<Response> getRandomMeal();
    @GET("search.php")
    Single<Response> getMeals(@Query("f") String letters);

    @GET("list.php?a=list")
    public Single<CountryResponse> getCountries();
    @GET("list.php?i=list")
    public Single<IngredientResponse> getIngredients();
    @GET("list.php?c=list")
    public Single<CategoryResponse> getCategories();

    @GET("filter.php")
    Single<Response> getMealsByIngredient(@Query("i") String ingredient);
    @GET("filter.php")
    Single<Response> getMealsByCountry(@Query("a") String country);
    @GET("filter.php")
    Single<Response> getMealsByCategory(@Query("c") String category);



}