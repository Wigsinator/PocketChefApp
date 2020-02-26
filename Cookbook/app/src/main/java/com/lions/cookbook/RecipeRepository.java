package com.lions.cookbook;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RecipeRepository {

    private RecipeDao mRecipeDao;
    private LiveData<List<Recipe>> mAllRecipes;

    RecipeRepository(Application application) {
        RecipeDatabase db = RecipeDatabase.getDatabase(application);
        mRecipeDao = db.recipeDao();
        mAllRecipes = mRecipeDao.getAlphabetizedRecipes();
    }

    LiveData<List<Recipe>> getAllRecipes() {
        return mAllRecipes;
    }

    void insert(final Recipe recipe) {
        RecipeDatabase.databaseWriteExecutor.execute(() -> {mRecipeDao.insert(recipe);});
    }

    void update(final Recipe recipe) {
        RecipeDatabase.databaseWriteExecutor.execute(() -> {mRecipeDao.update(recipe);});
    }

    List<Recipe> searchByTitle(String recipeTitle){
        RecipeDatabase.databaseWriteExecutor.execute(() -> {mRecipeDao.getRecipeByTitle(recipeTitle);});
    }
}