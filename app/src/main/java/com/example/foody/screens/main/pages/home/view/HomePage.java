package com.example.foody.screens.main.pages.home.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.example.foody.R;
import com.example.foody.dataSources.api.models.category.MealsItem;
import com.example.foody.dataSources.api.models.category.NetworkListener;
import com.example.foody.screens.info.InfoActivity;
import com.example.foody.screens.main.pages.home.IContract;
import com.example.foody.screens.main.pages.home.model.HomeModel;
import com.example.foody.screens.main.pages.home.presenter.HomePresenter;
import com.example.foody.screens.main.pages.home.presenter.IHomePageNavigateCallBack;
import com.example.foody.screens.main.pages.home.ui.BottomSheet;
import com.example.foody.screens.main.pages.home.ui.MealModel;
import com.example.foody.screens.main.pages.home.ui.MealsGridViewAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends Fragment implements IContract.IView {
    private static final String TAG="HomePage";
    IContract.IPresenter presenter;

    GridView mealsGV;
    EditText searchField;
    Button filters;


//    List<String> categoriesItems=new ArrayList<>();
//    List<String> countriesItems=new ArrayList<>();
//    List<String> ingredientsItems=new ArrayList<>();



    public HomePage() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new HomePresenter(this, new HomeModel());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        View view= inflater.inflate(R.layout.fragment_home_page, container, false);
        filters=view.findViewById(R.id.btn_filters);
        mealsGV = view.findViewById(R.id.homeGridView);
        searchField=view.findViewById(R.id.homeSearch);
        presenter.getFilters();
//        HomeModel homeModel=new HomeModel();
//        homeModel.getCategories(new NetworkListener() {
//            @Override
//            public void onDataFetched(List<MealsItem> categories) {
//                for(com.example.foody.dataSources.api.models.category.MealsItem category : categories){
//                    categoriesItems.add(category.getStrCategory());
//                }
//            }
//
//            @Override
//            public void onDataFailed() {
//                Log.i(TAG, "onDataFailed: ");
//            }
//        });
//        homeModel.getCountries(new com.example.foody.dataSources.api.models.country.NetworkListener() {
//            @Override
//            public void onDataFetched(List<com.example.foody.dataSources.api.models.country.MealsItem> countries) {
//                for(com.example.foody.dataSources.api.models.country.MealsItem country : countries){
//                    countriesItems.add(country.getStrArea());
//                }
//
//            }
//
//            @Override
//            public void onDataFailed() {
//                Log.i(TAG, "onDataFailed: ");
//            }
//        });
//        homeModel.getIngredients(new com.example.foody.dataSources.api.models.ingredient.NetworkListener() {
//            @Override
//            public void onDataFetched(List<com.example.foody.dataSources.api.models.ingredient.MealsItem> ingredients) {
//                for(com.example.foody.dataSources.api.models.ingredient.MealsItem ingredient : ingredients){
//                    ingredientsItems.add(ingredient.getStrIngredient());
//                }
//            }
//
//            @Override
//            public void onDataFailed() {
//                Log.i(TAG, "onDataFailed: ");
//            }
//        });
        filters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.setBottomSheet();
//                BottomSheet bottomSheetFragment = new BottomSheet(categoriesItems,countriesItems,ingredientsItems);
//                bottomSheetFragment.show(getChildFragmentManager(), bottomSheetFragment.getTag());

            }
        });
        searchField.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    Log.i(TAG, "onKey: pressed");
                    presenter.onSearchEnterKeyPressed(v.getContext(),searchField.getText().toString());
                    return true;
                }
                return false;
            }
        });

        presenter.setMealsGridView(this.getContext(),"b");


        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
    }


    @Override
    public void showMealsInGridView(MealsGridViewAdapter adapter, ArrayList<MealModel> gridViewMeals, IHomePageNavigateCallBack callBack) {
        adapter = new MealsGridViewAdapter(this.getContext(), gridViewMeals,callBack);
        mealsGV.setAdapter(adapter);
    }

    @Override
    public void showFiltersInBottomSheet(BottomSheet bottomSheetFragment) {
        bottomSheetFragment.show(getChildFragmentManager(), bottomSheetFragment.getTag());

    }

    @Override
    public void navigateToInfoScreen(String mealID) {
        Intent intent = new Intent(this.getContext(), InfoActivity.class);
        intent.putExtra("mealID", mealID);
        intent.putExtra("Source", "DB");


        startActivity(intent);
    }
}