package com.lions.cookbook;

public class RecipeModel {

    private static RecipeModel model = null;
    private Recipe recipe;

    private RecipeModel() {
        this.recipe = null;
    }

    public static RecipeModel getRecipeModel() {
        if (model == null) {
            model = new RecipeModel();
        }
        return model;
    }

    public Recipe createBlankRecipe() {
        Ingredient[] ingredients = new Ingredient[50];
        String[] steps = new String[50];
        String[] tags = new String[50];
        this.recipe = new Recipe("", 0, ingredients, steps, tags);
        return this.recipe;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public void saveRecipe() {
        //TODO
    }

    public void loadRecipe() {
        //TODO
    }
}
