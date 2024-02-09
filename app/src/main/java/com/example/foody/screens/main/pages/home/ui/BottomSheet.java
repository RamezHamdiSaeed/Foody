package com.example.foody.screens.main.pages.home.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.foody.R;
import com.example.foody.dataSources.api.models.meals.MealsItem;
import com.example.foody.dataSources.api.models.meals.NetworkListener;
import com.example.foody.screens.main.pages.home.model.HomeModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

public class BottomSheet extends BottomSheetDialogFragment {
    private static final String TAG="BottomSheet";

    private List<String> categories;
    private List<String> counrties;
    private List<String> ingredients;
    ChipGroup ingredientsCG;
    ChipGroup countriesCG;
    ChipGroup categoriesCG;
    HomeModel model;
    NetworkListener categoriesNetworkListener;
    NetworkListener countriesNetworkListener;
    NetworkListener ingredientsNetworkListener;




    public BottomSheet(List<String> categories,List<String> countries,List<String> ingredients,NetworkListener categoriesNetworkListener,NetworkListener countriesNetworkListener,NetworkListener ingredientsNetworkListener) {
        this.categories=categories;
        this.counrties=countries;
        this.ingredients=ingredients;
        this.categoriesNetworkListener=categoriesNetworkListener;
        this.countriesNetworkListener=countriesNetworkListener;
        this.ingredientsNetworkListener=ingredientsNetworkListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_layout, container, false);
        model=new HomeModel();

         categoriesCG = view.findViewById(R.id.categories);
         countriesCG = view.findViewById(R.id.countries);
         ingredientsCG = view.findViewById(R.id.ingredients);


        buildCategoriesChipGroup(this.categories);
        buildCountriesChipGroup(this.counrties);
        buildIngredientsChipGroup(this.ingredients);


        return view;
    }
    public void buildCategoriesChipGroup(List<String>chipsTexts){


        for (String chipText : chipsTexts) {
            Chip chip = new Chip(requireContext());
            chip.setText(chipText);
            chip.setClickable(true);
            chip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    model.getMealsByCategory(chipText,categoriesNetworkListener);

                    dismiss();
                }
            });
            categoriesCG.addView(chip);
        }
    }
    public void buildCountriesChipGroup(List<String>chipsTexts){


        for (String chipText : chipsTexts) {
            Chip chip = new Chip(requireContext());
            chip.setText(chipText);
            chip.setClickable(true);
            chip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    model.getMealsByCountry(chipText,countriesNetworkListener);

                    dismiss();
                }
            });
            countriesCG.addView(chip);
        }
    }
    public void buildIngredientsChipGroup(List<String>chipsTexts){


        for (String chipText : chipsTexts) {
            Chip chip = new Chip(requireContext());
            chip.setText(chipText);
            chip.setClickable(true);
            chip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    model.getMealsByIngredient(chipText, ingredientsNetworkListener);

                    dismiss();
                }
            });
            ingredientsCG.addView(chip);
        }
    }
}
