package com.lions.cookbook;

import android.view.View;

public class CreateRecipePresent implements CreateRecipeContract.CreateRecipeMVPPresenter{
    private CreateRecipeContract.CreateRecipeMVPView nView;
    private CreateRecipeContract.CreateRecipeModel nModel;

    CreateRecipePresent(CreateRecipeContract.CreateRecipeMVPView view, CreateRecipeContract.CreateRecipeModel model){
        nView = view;
        nModel = model;
    }
    @Override
    public void handleCreateRecipeClicked(View view) {
        //Get Input from user
        String recipe_steps = nView.getRecipeSteps();
        String ingredients = nView.getRecipeIngredients();
        String title = nView.getRecipeTitle();
        Integer serving_size = nView.getServingSize();

        //Error checking here
        boolean any_errors = false;
        //Fill in error checking here!
        if (any_errors){
            nView.showUnfilledError();
        } else {
            //Add Information to database
            nModel.addRecipeTitle(title);
            nModel.addRecipeIngredients(ingredients);
            nModel.addServingSize(serving_size);
            nModel.addRecipeSteps(recipe_steps);
        }

        nView.showSuccessfulCreation();
        nView.goToCookBookScreen();
    }

    @Override
    public void handleGoToCookBookScreen(View view) {
        nView.goToCookBookScreen();
    }
}
