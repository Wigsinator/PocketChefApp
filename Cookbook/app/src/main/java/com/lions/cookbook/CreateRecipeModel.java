package com.lions.cookbook;

import java.util.ArrayList;

public class CreateRecipeModel implements  CreateRecipeContract.CreateRecipeMVPModel{
    CreateRecipeModel(){

    }

    @Override
    public Boolean ExistRecipeName(String recipe_name) {
        return false;
    }

    @Override
    public Boolean addRecipe(Recipe new_recipe) {
        return true;
    }
}
