package com.example.foody.dataSources.api.models.country;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CountryResponse {

	@SerializedName("meals")
	private List<MealsItem> meals;

	public List<MealsItem> getMeals(){
		return meals;
	}
}