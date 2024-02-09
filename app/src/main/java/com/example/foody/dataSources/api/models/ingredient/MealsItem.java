package com.example.foody.dataSources.api.models.ingredient;

import com.google.gson.annotations.SerializedName;

public class MealsItem{

	@SerializedName("idIngredient")
	private String idIngredient;

	@SerializedName("strIngredient")
	private String strIngredient;
	@SerializedName("strDescription")
	private String strDescription;
	@SerializedName("strType")
	private String strType;

	public String getIdIngredient() {
		return idIngredient;
	}

	public String getStrIngredient() {
		return strIngredient;
	}

	public String getStrDescription() {
		return strDescription;
	}

	public String getStrType() {
		return strType;
	}
}