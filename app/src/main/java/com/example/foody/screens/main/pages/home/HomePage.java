package com.example.foody.screens.main.pages.home;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;

import com.example.foody.R;
import com.example.foody.dataSources.api.FoodRemoteDataSource;
import com.example.foody.dataSources.api.MealsItem;
import com.example.foody.dataSources.api.NetworkListener;
import com.example.foody.dataSources.api.ObserverCallBack;
import com.example.foody.screens.main.pages.home.ui.MealModel;
import com.example.foody.screens.main.pages.home.ui.MealsGridViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Fragment {

    GridView mealsGV;
    EditText searchField;
    MealsGridViewAdapter adapter ;


    public HomePage() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home_page, container, false);

        mealsGV = view.findViewById(R.id.homeGridView);
        searchField=view.findViewById(R.id.homeSearch);
        searchField.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    showMealsGridView(v.getContext(),searchField.getText().toString());
                    return true;
                }
                return false;
            }
        });
        //all meals

        showMealsGridView(view.getContext(), "b");


        return view;

    }
    public void showMealsGridView(Context context, String keyword){
        ArrayList<MealModel> gridViewMeals= new ArrayList<>();
        adapter = new MealsGridViewAdapter(context, gridViewMeals);


        FoodRemoteDataSource.getClient().getMealsByLetters(keyword, new NetworkListener() {
            @Override
            public void onDataFetched(List<MealsItem> meals) {
                Log.i("HomePage", "onDataFetched: "+meals.size());
                for(MealsItem meal : meals){
                    gridViewMeals.add(new MealModel(meal.getStrMealThumb(),meal.getStrMeal()));

                }
                mealsGV.setAdapter(adapter);

            }

            @Override
            public void onDataFailed() {

            }
        });
    }
}