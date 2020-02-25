package com.lions.cookbook;

import android.app.Application;


public class CreateRecipeModel implements  CreateRecipeContract.CreateRecipeMVPModel{
    private RecipeRepository mRepository;

    public CreateRecipeModel(Application application){
        mRepository = new RecipeRepository(application);
    }

    @Override
    public Boolean ExistRecipeName(String recipe_name) {
        return false;
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
