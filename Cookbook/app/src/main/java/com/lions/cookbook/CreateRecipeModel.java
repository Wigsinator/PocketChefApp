package com.lions.cookbook;



import com.google.firebase.database.DatabaseReference;

import java.util.List;


public class CreateRecipeModel implements  CreateRecipeContract.CreateRecipeMVPModel{
    private DatabaseReference mDatabase;

    public CreateRecipeModel(DatabaseReference database){
        mDatabase = database;
    }

    @Override
    public Boolean ExistRecipeName(String recipe_name) {
        //TODO Create this function
        return false;
    }

    @Override
    public Boolean addRecipe(Recipe new_recipe) {
        try {
            mDatabase.child("recipes").child(new_recipe.getUsername()).child(new_recipe.getTitle()).setValue(new_recipe);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
