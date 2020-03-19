package com.lions.cookbook;

import java.util.ArrayList;
import java.util.List;

public class ViewRecipeModel implements ViewRecipeContract.ViewRecipeMVPModel {

    public ViewRecipeModel(){

    }
    @Override
    public Recipe getRecipe(String recipeName) { //Fill in this function
        //Given the recipe Name, retrieve and return the Recipe object.
        //Feel free to comment out the code below as they are hard coded values
        String title = "Test Recipe";
        int serving_size = 5;
        String username = "Bob";
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient test_ingredient = new Ingredient("Potato", 500, "g");
        ingredients.add(test_ingredient);
        List<String> steps = new ArrayList<>();
        steps.add("Step 1");
        List<String> fake_tags = new ArrayList<String>();
        fake_tags.add("Beginner");
        Recipe new_recipe = new Recipe(title, username, serving_size, ingredients, fake_tags, steps); //Note: Tags feature has not been added
        return new_recipe;
    }

    @Override
    public Boolean deleteRecipe(String recipeName) {
        return Boolean.TRUE;
    }
}
