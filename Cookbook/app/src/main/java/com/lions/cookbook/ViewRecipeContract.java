package com.lions.cookbook;

import android.view.View;

import java.util.List;

public interface ViewRecipeContract {
    interface ViewRecipeMVPView{}

    interface ViewRecipeMVPPresenter{
        Recipe fetchRecipe(String recipeName);
        void handleAlterPressed(View view);
        List<Ingredient> sizeScaleIngredients(List<Ingredient> ingredients, int originalSize, int NewSize);
        List<Ingredient> unitConversionIngredients(List<Ingredient> ingredients, String units); //units: Metric or Imperial
    }
    interface ViewRecipeMVPModel{
        Recipe getRecipe(String recipeName);
    }
}
