package com.example.foody.screens.info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.example.foody.R;
import com.example.foody.dataSources.api.FoodRemoteRepository;
import com.example.foody.dataSources.api.models.meals.MealsItem;
import com.example.foody.dataSources.api.models.meals.NetworkListener;
import com.example.foody.screens.info.ui.recyclerView.MyItem;
import com.example.foody.screens.info.ui.recyclerView.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity implements NetworkListener{
    RecyclerView ingredients;
    List<MyItem> ingredientsList;
    private static final String TAG="InfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ingredients = findViewById(R.id.ingredients);
        ingredients.setLayoutManager(new LinearLayoutManager(this));
        ingredientsList=new ArrayList<>();

        Intent intent = getIntent();

            String mealID = intent.getStringExtra("mealID");
        Log.i(TAG, "onCreate: before calling the api");

       // if(!intent.getStringExtra("Source").equals("DB")){
                Log.i(TAG, "onCreate: during calling the api");
                FoodRemoteRepository.getClient().getMeal(mealID, this);


//        }

    }
    public void getMealIngredients(List<MealsItem> meals){
    MealsItem meal=meals.get(0);
    if(!isEmptyOrNull(meal.getStrIngredient1())){
        isEmptyOrNull(meal.getStrIngredient1());
    }
        if(!isEmptyOrNull(meal.getStrIngredient2())){
            isEmptyOrNull(meal.getStrIngredient2());
        }
        if(!isEmptyOrNull(meal.getStrIngredient3())){
            isEmptyOrNull(meal.getStrIngredient3());
        }
        if(!isEmptyOrNull(meal.getStrIngredient4())){
            isEmptyOrNull(meal.getStrIngredient4());
        }
        if(!isEmptyOrNull(meal.getStrIngredient5())){
            isEmptyOrNull(meal.getStrIngredient5());
        }
        if(!isEmptyOrNull(meal.getStrIngredient6())){
            isEmptyOrNull(meal.getStrIngredient6());
        }
        if(!isEmptyOrNull(meal.getStrIngredient7())){
            isEmptyOrNull(meal.getStrIngredient7());
        }
        if(!isEmptyOrNull(meal.getStrIngredient8())){
            isEmptyOrNull(meal.getStrIngredient8());
        }
        if(!isEmptyOrNull(meal.getStrIngredient9())){
            isEmptyOrNull(meal.getStrIngredient9());
        }
        if(!isEmptyOrNull(meal.getStrIngredient10())){
            isEmptyOrNull(meal.getStrIngredient10());
        }
        if(!isEmptyOrNull(meal.getStrIngredient11())){
            isEmptyOrNull(meal.getStrIngredient11());
        }
        if(!isEmptyOrNull(meal.getStrIngredient12())){
            isEmptyOrNull(meal.getStrIngredient12());
        }
        if(!isEmptyOrNull(meal.getStrIngredient13())){
            isEmptyOrNull(meal.getStrIngredient13());
        }
        if(!isEmptyOrNull(meal.getStrIngredient14())){
            isEmptyOrNull(meal.getStrIngredient14());
        }
        if(!isEmptyOrNull(meal.getStrIngredient15())){
            isEmptyOrNull(meal.getStrIngredient15());
        }
        if(!isEmptyOrNull(meal.getStrIngredient16())){
            isEmptyOrNull(meal.getStrIngredient16());
        }
        if(!isEmptyOrNull(meal.getStrIngredient17())){
            isEmptyOrNull(meal.getStrIngredient17());
        }
        if(!isEmptyOrNull(meal.getStrIngredient18())){
            isEmptyOrNull(meal.getStrIngredient18());
        }
        if(!isEmptyOrNull(meal.getStrIngredient19())){
            isEmptyOrNull(meal.getStrIngredient19());
        }
        if(!isEmptyOrNull(meal.getStrIngredient20())){
            isEmptyOrNull(meal.getStrIngredient20());
        }

    }
    public boolean isEmptyOrNull(String ingredient){
        if(TextUtils.isEmpty(ingredient)||ingredient.equals(null)){
            return true;
        }
        if(ingredientsList.size()>0&&ingredientsList.get(ingredientsList.size()-1).getTitle().equals(ingredient)){
            return true;
        }
        ingredientsList.add(new MyItem(ingredient));
        return false;
    }

    @Override
    public void onDataFetched(List<MealsItem> meals) {
        Log.i(TAG, "onDataFetched: "+meals.size());
        getMealIngredients(meals);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, ingredientsList);
        ingredients.setAdapter(adapter);
    }

    @Override
    public void onDataFailed() {
        Log.i(TAG, "onDataFailed: ");
    }
}