package com.lions.cookbook;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            String alterUnits = nView.getUnits();
            ArrayList<Ingredient> unitUpdateList = new ArrayList<>(unitConversionIngredients(newList, alterUnits));
            nView.updateIngredients(unitUpdateList);
        }


    }

    @Override
    public List<Ingredient> sizeScaleIngredients(List<Ingredient> ingredients, int originalSize, int NewSize) {
        List<Ingredient> new_list = new ArrayList<Ingredient>();
        for (int i = 0; i < ingredients.size() ; i++){
            float originalQuantity = ingredients.get(i).getQuantity();
            String originalName = ingredients.get(i).getName();
            String originalType = ingredients.get(i).getQuantityType();
            float newQuantity = (originalQuantity/originalSize)*NewSize;
            Ingredient changed = new Ingredient(originalName, newQuantity, originalType);
            new_list.add(changed);
        }
        return new_list;
    }



    //Conducts the unit conversion so that the final quantity and type match 'units'
    @Override
    public List<Ingredient> unitConversionIngredients(List<Ingredient> ingredients, String units) {
        List<Ingredient> new_list = new ArrayList<Ingredient>();
        for (int i = 0; i < ingredients.size() ; i++){
            float originalQuantity = ingredients.get(i).getQuantity();
            String originalName = ingredients.get(i).getName();
            String originalType = ingredients.get(i).getQuantityType();
            String ingredientType = getIngredientType(originalType);

            if (!(units.equals(ingredientType))){
                float newQuantity;
                String newType;
                switch(ingredientType){
                    case "tsp":
                        newType = "ml";
                        newQuantity = 5 * originalQuantity;
                        break;

                    case "tbs":
                        newType = "ml";
                        newQuantity = 15 * originalQuantity;
                        break;

                    case "cups":
                        newType = "ml";
                        newQuantity = 250 * originalQuantity;
                        break;

                    case "ml":
                        newType = "cup";
                        newQuantity = originalQuantity / 60;
                        break;

                    case "oz":
                        newType = "g";
                        newQuantity = originalQuantity * 30;
                        break;

                    case "lb":
                        newType = "g";
                        newQuantity = originalQuantity * 500;
                        break;

                    case "g":
                        newType = "lb";
                        newQuantity = originalQuantity/500;
                        break;

                    default:
                        newType = originalType;
                        newQuantity = originalQuantity;
                        break;

                }
                Ingredient changed = new Ingredient(originalName, newQuantity, newType);
                new_list.add(changed);
            } else {
                Ingredient changed = new Ingredient(originalName, originalQuantity, originalType);
                new_list.add(changed);
            }

        }
        return new_list;
    }

    //Returns the ingredient type: either metric, imperial, or other
    public String getIngredientType(String givenType){
        Set<String> metricSet = new HashSet<String>();
        Set<String> imperialSet = new HashSet<String>();
        Set<String> othersSet = new HashSet<String>();
        metricSet.add("g");
        metricSet.add("kg");
        metricSet.add("ml");
        metricSet.add("l");
        imperialSet.add("oz");
        imperialSet.add("lb");
        imperialSet.add("tsp");
        imperialSet.add("tbs");
        imperialSet.add("cup");
        othersSet.add("count");

        if (metricSet.contains(givenType)){
            return "metric";
        } else if (imperialSet.contains(givenType)){
            return "imperial";
        } else {
            return "other";
        }
    }
    @Override
    public Boolean checkEnteredServingSize() {
        boolean any_errors = false;
        if (nView.getServingSize() == null || nView.getServingSize().equals("")){
            any_errors = true;
        } else {
            try {
                float temp = Integer.parseInt(nView.getServingSize());
            } catch (NumberFormatException ex) {
                any_errors = true;
            }
        }
        return any_errors;
    }
}
