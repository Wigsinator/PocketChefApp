package com.lions.cookbook;

import java.util.*;
import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class RecipeModel{

    private Recipe recipe;
    private RecipeRepository mRepository;
    private LiveData<List<Recipe>> mAllRecipes;

    public RecipeModel(Application application) {
        mRepository = new RecipeRepository(application);
        mAllRecipes = mRepository.getAllRecipes();
    }

    LiveData<List<Recipe>> getAllRecipes() {return mAllRecipes;}

    public void insert(Recipe recipe) {mRepository.insert(recipe);}

    public Recipe createBlankRecipe() {
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        List<String> steps = new ArrayList<String>();
        List<String> tags = new ArrayList<String>();
        this.recipe = new Recipe("", "test user", 0, ingredients, steps, tags);
        return this.recipe;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

}
