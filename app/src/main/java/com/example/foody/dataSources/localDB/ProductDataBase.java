package com.example.foody.dataSources.localDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foody.dataSources.api.models.meals.MealsItem;

@Database(entities = {MealsItem.class},version = 1)
public abstract class ProductDataBase extends RoomDatabase {
    private static ProductDataBase instance = null;
    public abstract MealsDAO getProductDAO();
    public static synchronized ProductDataBase getInstance(Context context){
        if(instance==null)
            instance = Room.databaseBuilder(context.getApplicationContext(),ProductDataBase.class,"mealsdp").build();
        return instance;
    }
}
