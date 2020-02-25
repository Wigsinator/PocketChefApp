package com.lions.cookbook;

import android.app.Application;

import java.util.List;


public class CreateRecipeModel implements  CreateRecipeContract.CreateRecipeMVPModel{
    private RecipeRepository mRepository;

    public CreateRecipeModel(Application application){
        mRepository = new RecipeRepository(application);
    }

    @Override
    public Boolean ExistRecipeName(String recipe_name) {
        List<Recipe> matches = mRepository.searchByTitle(recipe_name);
        return !matches.isEmpty();
    }

    @Override
    public Boolean addRecipe(Recipe new_recipe) {
        try {
            mRepository.insert(new_recipe);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
