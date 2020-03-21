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
        void showToggleChanged();
        void showToggleSuccess();
        void showToggleFailure();
    }

    interface ViewRecipeMVPPresenter{
        Recipe fetchRecipe(String recipeName);
        void handleAlterPressed();
        List<Ingredient> sizeScaleIngredients(List<Ingredient> ingredients, int originalSize, int NewSize);
        List<Ingredient> unitConversionIngredients(List<Ingredient> ingredients, String units); //units: Metric or Imperial
        Boolean checkEnteredServingSize();
        void toggleSwitchChange(Boolean isToggleOn, String RecipeName);
    }
    interface ViewRecipeMVPModel{
        Recipe getRecipe(String recipeName);
        Boolean publishStateUpdate(Boolean isPublished, String RecipeName); //isPublished = true if switched to published, false if switching to notPublished. Return True once completed
    }
}
