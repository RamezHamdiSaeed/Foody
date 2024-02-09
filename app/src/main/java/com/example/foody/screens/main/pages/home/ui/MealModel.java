package com.example.foody.screens.main.pages.home.ui;

public class MealModel {
    private String strMealThumb;
    private String strMeal;
    private String idMeal;

    public MealModel(String strMealThumb, String strMeal,String idMeal) {
        this.strMealThumb = strMealThumb;
        this.strMeal = strMeal;
        this.idMeal=idMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }
}
