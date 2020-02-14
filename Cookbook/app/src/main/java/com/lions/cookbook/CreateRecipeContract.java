package com.lions.cookbook;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines contract between View {@link CreateRecipeActivity} and Presneter {@link CreateRecipePresent}
 * */
public interface CreateRecipeContract {

    interface CreateRecipeMVPView{
        void goToCookBookScreen();
        void showUnfilledError();
        void showSuccessfulCreation();
        void showCreationError();
        ArrayList<String> getRecipeIngredients();
        String getServingSize();
        ArrayList getRecipeSteps();
        String getRecipeTitle();
        String getNewStep();
        void addNewStep(String new_step);
        String getNewIngredient();
        void addNewIngredient(String new_ingredient);
    }


    interface CreateRecipeMVPPresenter{
        void handleCreateRecipeClicked(View view);
        void handleGoToCookBookScreen(View view);
        void handleAddSteps(View view);
        void handleAddIngredient(View view);
    }

    interface CreateRecipeModel {
        Boolean addRecipeTitle(String recipe_title);
        Boolean addRecipeSteps(ArrayList recipe_steps);
        Boolean addServingSize(Integer serving_size);
        Boolean addRecipeIngredients(ArrayList recipe_ingredients);
    }

}
