package com.lions.cookbook;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RecipeRepository {

    private RecipeDao mRecipeDao;
    private LiveData<List<Recipe>> mAllRecipes;
    private LiveData<List<String>> mAllRecipeTitles;

    RecipeRepository(Application application) {
        RecipeDatabase db = RecipeDatabase.getDatabase(application);
        mRecipeDao = db.recipeDao();
        mAllRecipes = mRecipeDao.getAlphabetizedRecipes();
        mAllRecipeTitles = mRecipeDao.getAlphabetizedRecipeTitles();
    }

    LiveData<List<Recipe>> getAllRecipes() {
        return mAllRecipes;
    }

    LiveData<List<String>> getAllRecipeTitles() { return mAllRecipeTitles; }

    LiveData<List<Recipe>> searchByTitle(String recipeTitle){ return mRecipeDao.getRecipeByTitle(recipeTitle); }

    void insert(final Recipe recipe) {
        RecipeDatabase.databaseWriteExecutor.execute(() -> {
            mRecipeDao.insert(recipe);
        });
    }

    void update(final Recipe recipe) {
        RecipeDatabase.databaseWriteExecutor.execute(() -> {mRecipeDao.update(recipe);});
    }
}