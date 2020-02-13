package com.lions.cookbook;

import java.util.ArrayList;

public class CreateRecipeModel implements  CreateRecipeContract.CreateRecipeModel{
    CreateRecipeModel(){

    }

    @Override
    public Boolean addRecipeTitle(String recipe_title) {
        return null;
    }

    @Override
    public Boolean addRecipeSteps(ArrayList recipe_steps) {
        return null;
    }

    @Override
    public Boolean addServingSize(Integer serving_size) {
        return null;
    }

    @Override
    public Boolean addRecipeIngredients(ArrayList recipe_ingredients) {
        return null;
    }
}
