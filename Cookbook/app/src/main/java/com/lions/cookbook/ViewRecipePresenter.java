package com.lions.cookbook;

public class ViewRecipePresenter implements ViewRecipeContract.ViewRecipeMVPPresenter {
    private ViewRecipeContract.ViewRecipeMVPView nView;
    private ViewRecipeContract.ViewRecipeMVPModel nModel;

    ViewRecipePresenter(ViewRecipeContract.ViewRecipeMVPView view, ViewRecipeContract.ViewRecipeMVPModel model){
        nView = view;
        nModel = model;
    }

    @Override
    public Recipe fetchRecipe(String recipeName) {
        return nModel.getRecipe(recipeName);
    }
}
