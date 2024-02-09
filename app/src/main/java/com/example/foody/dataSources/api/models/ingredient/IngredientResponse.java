package com.example.foody.dataSources.api.models.ingredient;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IngredientResponse {

	@SerializedName("meals")
	private List<MealsItem> meals;

	public List<MealsItem> getMeals(){
		return meals;
	}
}