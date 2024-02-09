package com.example.foody.dataSources.api;

import com.example.foody.dataSources.api.models.meals.MealsItem;

public interface ObserverCallBack {
 public void homeGridViewOnNext(MealsItem meal);
 public void homeGridViewOnComplete();
}
