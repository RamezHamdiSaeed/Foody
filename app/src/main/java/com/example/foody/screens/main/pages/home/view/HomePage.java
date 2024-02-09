package com.example.foody.screens.main.pages.home.view;

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
import com.example.foody.screens.main.pages.home.IContract;
import com.example.foody.screens.main.pages.home.model.HomeModel;
import com.example.foody.screens.main.pages.home.presenter.HomePresenter;
import com.example.foody.screens.main.pages.home.ui.MealModel;
import com.example.foody.screens.main.pages.home.ui.MealsGridViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Fragment implements IContract.IView {
    private static final String TAG="HomePage";
    IContract.IPresenter presenter;

    GridView mealsGV;
    EditText searchField;


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

        mealsGV = view.findViewById(R.id.homeGridView);
        searchField=view.findViewById(R.id.homeSearch);
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
    public void showMealsInGridView(MealsGridViewAdapter adapter, ArrayList<MealModel> gridViewMeals) {
        adapter = new MealsGridViewAdapter(this.getContext(), gridViewMeals);
        mealsGV.setAdapter(adapter);
    }
}