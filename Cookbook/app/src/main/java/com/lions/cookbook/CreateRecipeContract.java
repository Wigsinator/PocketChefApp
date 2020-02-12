package com.lions.cookbook;

import android.view.View;

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
        String getRecipeIngredients();
        Integer getServingSize();
        String getRecipeSteps();
        String getRecipeTitle();
        String getNewStep();
        void addNewStep(String new_step);
    }


    interface CreateRecipeMVPPresenter{
        void handleCreateRecipeClicked(View view);
        void handleGoToCookBookScreen(View view);
        void handleAddSteps(View view);
    }

    interface CreateRecipeModel {
        Boolean addRecipeTitle(String recipe_title);
        Boolean addRecipeSteps(String recipe_steps);
        Boolean addServingSize(Integer serving_size);
        Boolean addRecipeIngredients(String recipe_ingredients);
    }

}
