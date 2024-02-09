package com.example.foody.dataSources.api.models.meals;

import java.util.List;

import com.example.foody.dataSources.api.models.meals.MealsItem;
import com.google.gson.annotations.SerializedName;

public class Response {

	@SerializedName("meals")
	private List<MealsItem> meals;

	public List<MealsItem> getMeals(){
		return meals;
	}
}