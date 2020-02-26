package com.lions.cookbook;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CookBookModel implements CookBookContract.CookBookMVPModel {

    private RecipeRepository mRepository;

    private LiveData<List<Recipe>> mAllRecipes;
    private List<String> mAllRecipeTitles;

    public CookBookModel(Application application, AppCompatActivity activity){
        mRepository = new RecipeRepository(application);
        mAllRecipes = mRepository.getAllRecipes();
        mRepository.getAllRecipeTitles().observe(activity, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                mAllRecipeTitles = strings;
            }
        });
    }

    @Override
    public ArrayList<String> getRecipeNamesDB() { //Fill in this function
        //Return ArrayList of all recipe names stored in DB.
        //Feel free to comment out the code below as they are hard coded values
        /*
        String[] filler_recipes = {"Spaghetti", "Whole Wheat Bread", "Bread Pudding", "Chow Mein",
                "Potato Bread", "Guac", "Quinoa Salad", "Chicken Salad", "Terriyaki Chicken",
                "Wedges", "Brownies", "Black Forest Cake", "FlatBread", "Butter Chicken", "Potato Curry",
                "Vegan Chicken", "Fairy Bread"};
        ArrayList<String> RecipeList = new ArrayList<>(Arrays.asList(filler_recipes));


        return RecipeList;

        */
        return new ArrayList<>(mAllRecipeTitles);
    }

    @Override
    public List<String> getRecipeImages() {
        return null;
    }

}
