package com.lions.cookbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CookBookPresent implements CookBookContract.CookBookMVPPresenter{
    private CookBookContract.CookBookMVPView nView;
    private CookBookContract.CookBookMVPModel nModel;
    private ArrayList RecipeList;

    CookBookPresent(CookBookContract.CookBookMVPView view, CookBookContract.CookBookMVPModel model){
        nView = view;
        nModel = model;
        String[] filler_recipes = {"Spaghetti", "Whole Wheat Bread", "Bread Pudding", "Chow Mein",
                "Potato Bread", "Guac", "Quinoa Salad", "Chicken Salad", "Terriyaki Chicken",
                "Wedges", "Brownies", "Black Forest Cake", "FlatBread", "Butter Chicken", "Potato Curry",
                "Vegan Chicken", "Fairy Bread"};
        RecipeList = new ArrayList<String>(Arrays.asList(filler_recipes));
    }

    @Override
    public ArrayList getRecipeNames() {
        return this.RecipeList;
        //return nModel.getRecipeNamesDB();
    }

    @Override
    public void handleCreateRecipeClicked() {
        nView.goToCreateRecipeScreen();
    }

    @Override
    public void handleRecipeClicked(String recipeName) {
        String ingredients = nModel.getRecipeIngredients(recipeName);
        List recipeSteps = nModel.getRecipeSteps(recipeName);
        String servingSize = nModel.getRecipeServingSize(recipeName);
        nView.goToViewRecipe(recipeName, servingSize,ingredients,recipeSteps);
    }
}
