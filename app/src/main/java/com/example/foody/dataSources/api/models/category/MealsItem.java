package com.example.foody.dataSources.api.models.category;

import com.google.gson.annotations.SerializedName;

public class MealsItem{

	@SerializedName("strCategory")
	private String strCategory;

	public String getStrCategory(){
		return strCategory;
	}
}