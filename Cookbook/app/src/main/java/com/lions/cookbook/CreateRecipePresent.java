package com.lions.cookbook;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CreateRecipePresent implements CreateRecipeContract.CreateRecipeMVPPresenter{
    private CreateRecipeContract.CreateRecipeMVPView nView;
    private CreateRecipeContract.CreateRecipeModel nModel;
    //private RecipeModel firebase_db;
    private List<String> recipesteps;

    CreateRecipePresent(CreateRecipeContract.CreateRecipeMVPView view, CreateRecipeContract.CreateRecipeModel model){
        nView = view;
        nModel = model;
        //firebase_db = new RecipeModel();
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
        /*

        String[] steps = new String[nView.getRecipeSteps().size()];
        for (int i = 0; i < nView.getRecipeSteps().size(); i++){
            steps[i] = (String) nView.getRecipeSteps().get(i);
        }

        String title = nView.getRecipeTitle();
        Integer serving_size = Integer.parseInt(nView.getServingSize());
        String username = "Bob";
        Ingredient[] ingredients = new Ingredient[nView.getRecipeIngredients().size()];
        for (int i = 0; i < nView.getRecipeIngredients().size(); i++){
            String[] values = nView.getRecipeIngredients().get(i).split(",");
            Ingredient new_ingredient = new Ingredient(values[0], Float.parseFloat(values[1]), values[2]);
            ingredients[i] = new_ingredient;
        }
        */

        if (any_errors){
            nView.showUnfilledError();
        } else {
            //Add Information to database
            //Recipe new_recipe = new Recipe(nView.getRecipeTitle(), "Bob", serving_size, ingredients, null, steps );

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
