package com.lions.cookbook;

import android.view.View;

import java.util.ArrayList;
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
    public void handleAlterPressed() {
        if (checkEnteredServingSize()){
            nView.showServingNull();
        } else {
            Recipe originalRecipe = nView.getOriginalRecipe();
            ArrayList<Ingredient> newList = new ArrayList<Ingredient>(sizeScaleIngredients(originalRecipe.getIngredients(), originalRecipe.getServingSize(), Integer.parseInt(nView.getServingSize())));
            nView.updateIngredients(newList);
        }


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

    @Override
    public Boolean checkEnteredServingSize() {
        boolean any_errors = false;
        if (nView.getServingSize() == null || nView.getServingSize().equals("")){
            any_errors = true;
        } else {
            try {
                float temp = Float.parseFloat(nView.getServingSize());
            } catch (NumberFormatException ex) {
                any_errors = true;
            }
        }
        return any_errors;
    }
}
