package com.lions.cookbook;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CreateRecipePresent implements CreateRecipeContract.CreateRecipeMVPPresenter{
    private CreateRecipeContract.CreateRecipeMVPView nView;
    private CreateRecipeContract.CreateRecipeModel nModel;
    private List<String> recipesteps;

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
        Log.d("Retrieve info", "Title:" + title + " serving_size" + serving_size);

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

    @Override
    public void handleAddSteps(View view) {
        String new_step = nView.getNewStep();
        nView.addNewStep(new_step);
    }
}
