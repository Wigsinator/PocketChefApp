package com.lions.cookbook;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CookBookModel implements CookBookContract.CookBookMVPModel {

    private DatabaseReference mDatabase;

    public CookBookModel(DatabaseReference database){
        mDatabase = database;
    }

    @Override
    public ArrayList<String> getRecipeNamesDB() {//Fill in this function
        //Return ArrayList of all recipe names stored in DB.
        //Feel free to comment out the code below as they are hard coded values
        //TODO This also needs done
        String[] filler_recipes = {"Spaghetti", "Whole Wheat Bread", "Bread Pudding", "Chow Mein",
                "Potato Bread", "Guac", "Quinoa Salad", "Chicken Salad", "Terriyaki Chicken",
                "Wedges", "Brownies", "Black Forest Cake", "FlatBread", "Butter Chicken", "Potato Curry",
                "Vegan Chicken", "Fairy Bread"};
        ArrayList<String> RecipeList = new ArrayList<>(Arrays.asList(filler_recipes));


        return RecipeList;


    }

    @Override
    public List<String> getRecipeImages() {
        return null;
    }

}
