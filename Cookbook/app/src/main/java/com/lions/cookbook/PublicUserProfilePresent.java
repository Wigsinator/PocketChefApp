package com.lions.cookbook;

import android.util.Log;

import java.util.ArrayList;

public class PublicUserProfilePresent implements PublicUserProfileContract.PublicUserProfilePresenter {
    private PublicUserProfileContract.PublicUserProfileView nView;
    private PublicUserProfileContract.PublicUserProfileModel nModel;


    PublicUserProfilePresent(PublicUserProfileContract.PublicUserProfileView view, PublicUserProfileContract.PublicUserProfileModel model){
        this.nView = view;
        this.nModel = model;
    }

    @Override
    public ArrayList getRecipeNames() {
        return nModel.getRecipes();
        //String[] filler_recipes = {"Spaghetti", "Whole Wheat Bread", "Bread Pudding", "Chow Mein"};
        //ArrayList<String> RecipeList = new ArrayList<>(Arrays.asList(filler_recipes));
        //return RecipeList;
    }


    @Override
    public void handleRecipeClicked(String recipeName) {
        Log.d("TEST", "Finish getting recipe");
        nView.goToViewRecipe(recipeName);
        Log.d("TEST", "able to go to view recipe");
    }

}
