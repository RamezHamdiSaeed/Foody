package com.example.foody.dataSources.api.models.country;

import com.google.gson.annotations.SerializedName;

public class MealsItem{

	@SerializedName("strArea")
	private String strArea;

	public String getStrArea(){
		return strArea;
	}
}