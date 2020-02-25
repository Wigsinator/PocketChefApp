package com.lions.cookbook;

import android.view.View;

import java.util.List;

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

    @Override
    public void handleAlterPressed(View view) {

    }

    @Override
    public List<Ingredient> sizeScaleIngredients(List<Ingredient> ingredients, int originalSize, int NewSize) {
        for (int i = 0; i < ingredients.size() ; i++){
            float originalQuantity = ingredients.get(i).getQuantity();
            float newQuantity = (originalQuantity/originalSize)*NewSize;
            ingredients.get(i).changeQuantity(newQuantity);
        }
        return ingredients;
    }

    @Override
    public List<Ingredient> unitConversionIngredients(List<Ingredient> ingredients, String units) {
        return null;
    }
}
