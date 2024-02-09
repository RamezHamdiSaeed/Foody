package com.example.foody.dataSources.api.models.category;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CategoryResponse {

	@SerializedName("meals")
	private List<MealsItem> meals;

	public List<MealsItem> getMeals(){
		return meals;
	}
}