package com.lions.cookbook;

import java.util.List;

public class CookBookPresent implements CookBookContract.CookBookMVPPresenter{
    private CookBookContract.CookBookMVPView nView;
    private CookBookContract.CookBookMVPModel nModel;

    CookBookPresent(CookBookContract.CookBookMVPView view, CookBookContract.CookBookMVPModel model){
        nView = view;
        nModel = model;
    }

    @Override
    public List getRecipeNames() {
        return nModel.getRecipeNamesDB();
    }

    @Override
    public void handleCreateRecipeClicked() {
        nView.goToCreateRecipeScreen();
    }

    @Override
    public void handleRecipeClicked() {
        String recipeName = nView.getNameRecipeClicked();
        String ingredients = nModel.getRecipeIngredients(recipeName);
        List recipeSteps = nModel.getRecipeSteps(recipeName);
        Integer servingSize = nModel.getRecipeServingSize(recipeName);
        nView.goToViewRecipe(recipeName, servingSize,ingredients,recipeSteps);
    }
}
