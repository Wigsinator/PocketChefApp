package com.lions.cookbook;

public class CreateRecipeModel implements  CreateRecipeContract.CreateRecipeModel{
    CreateRecipeModel(){

    }

    @Override
    public Boolean addRecipeTitle(String recipe_title) {
        return null;
    }

    @Override
    public Boolean addRecipeSteps(String recipe_steps) {
        return null;
    }

    @Override
    public Boolean addServingSize(Integer serving_size) {
        return null;
    }

    @Override
    public Boolean addRecipeIngredients(String recipe_ingredients) {
        return null;
    }
}
