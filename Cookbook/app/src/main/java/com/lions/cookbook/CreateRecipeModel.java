package com.lions.cookbook;

import android.app.Application;

import java.util.ArrayList;

public class CreateRecipeModel implements  CreateRecipeContract.CreateRecipeModel{

    private Recipe recipe;
    private RecipeRepository mRepository;

    public CreateRecipeModel(Application application){
        recipe = createBlankRecipe();
        mRepository = new RecipeRepository(application);
        mRepository.insert(recipe);
    }

    @Override
    public Boolean addRecipeTitle(String recipe_title) {
        recipe.changeTitle(recipe_title);
        mRepository.update(recipe);
        return true;
    }

    @Override
    public Boolean addRecipeSteps(ArrayList recipe_steps) {
        recipe.changeSteps(recipe_steps);
        mRepository.update(recipe);
        return true;
    }

    @Override
    public Boolean addServingSize(Integer serving_size) {
        recipe.changeServingSize(serving_size);
        mRepository.update(recipe);
        return true;
    }

    @Override
    public Boolean addRecipeIngredients(ArrayList recipe_ingredients) {
        recipe.changeIngredients(recipe_ingredients);
        mRepository.update(recipe);
        return true;
    }

    public Recipe createBlankRecipe() {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ArrayList<String> steps = new ArrayList<String>();
        ArrayList<String> tags = new ArrayList<String>();
        this.recipe = new Recipe("", "test user", 0, ingredients, steps, tags);
        return this.recipe;
    }
}
