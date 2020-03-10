package com.lions.cookbook;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public interface ViewRecipeContract {
    interface ViewRecipeMVPView{
        String getServingSize();
        void showServingNull();
        Recipe getOriginalRecipe();
        void updateIngredients(ArrayList<Ingredient> ingredients);
        void alterPressed(View view);
        String getUnits();
    }

    interface ViewRecipeMVPPresenter{
        Recipe fetchRecipe(String recipeName);
        void handleAlterPressed();
        List<Ingredient> sizeScaleIngredients(List<Ingredient> ingredients, int originalSize, int NewSize);
        List<Ingredient> unitConversionIngredients(List<Ingredient> ingredients, String units); //units: Metric or Imperial
        Boolean checkEnteredServingSize();
    }
    interface ViewRecipeMVPModel{
        Recipe getRecipe(String recipeName);
    }
}
