package com.lions.cookbook;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public interface ViewRecipeContract {
    interface ViewRecipeMVPView{
        String getServingSize();
        void showServingNull();
        void updateIngredients(ArrayList<Ingredient> ingredients);
        void alterPressed(View view);
        String getUnits();

        void deletePressed(View view);
        void goToCookBookScreen();
        void showDeleteSuccess();
        void showDeleteFailure();

        void populateTitle(String recipeTitle);
        void populateRecipeSteps(List<String> recipeSteps);
        void populateRecipeIngredients(List<Ingredient> recipeIngredients);
        void populateRecipeServing(int recipeServingSize);
        void goToViewAuthorProfile(String authorUsername);

    }

    interface ViewRecipeMVPPresenter{
        void handleAlterPressed();
        void handleDeletePressed(String recipeName);
        List<Ingredient> sizeScaleIngredients(List<Ingredient> ingredients, int originalSize, int NewSize);
        List<Ingredient> unitConversionIngredients(List<Ingredient> ingredients, String units); //units: Metric or Imperial
        Boolean checkEnteredServingSize();
        void populateValues(Recipe theRecipeObject);
        void handleAuthorProfileClicked(String authorUsername);
    }
    interface ViewRecipeMVPModel{
        Boolean deleteRecipe(String recipeName); // True if successful
        Recipe getRecipe();
    }
}
