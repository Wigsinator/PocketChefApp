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
        boolean any_errors = false;
        if (nView.getRecipeSteps().isEmpty()){
            any_errors = true;
        }
        if (nView.getRecipeIngredients().isEmpty()){
            any_errors = true;
        }
        if (nView.getRecipeTitle() == null || nView.getRecipeTitle().equals("")){
            any_errors = true;
        }
        if (nView.getServingSize() == null || nView.getServingSize().equals("")){
            any_errors = true;
        }
        /**
        String title = nView.getRecipeTitle();
        Integer serving_size = nView.getServingSize();
        Log.d("Retrieve info", "Title:" + title + " serving_size" + serving_size);
        **/

        if (any_errors){
            nView.showUnfilledError();
        } else {
            //Add Information to database
            /**
            nModel.addRecipeTitle(title);
            nModel.addRecipeIngredients(ingredients);
            nModel.addServingSize(serving_size);
            nModel.addRecipeSteps(recipe_steps);
            **/
            nView.showSuccessfulCreation();
            nView.goToCookBookScreen();
        }

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

    @Override
    public void handleAddIngredient(View view) {
        String new_ingredient = nView.getNewIngredient();
        nView.addNewIngredient(new_ingredient);
    }
}
