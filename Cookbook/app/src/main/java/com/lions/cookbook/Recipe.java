package com.lions.cookbook;


import androidx.room.Entity;

@Entity(primaryKeys = {"title","username"},tableName = "recipe_database")
public class Recipe {
    private String title;
    private String username;
    private int serving_size;
    private Ingredient[] ingredients;
    private String[] tags;
    private String[] steps;

    public Recipe(String title, String username,int serving_size, Ingredient[] ingredients, String[] tags, String[] steps){
        this.title = title;
        this.username = username;
        this.serving_size = serving_size;
        this.ingredients = ingredients;
        this.tags = tags;
        this.steps = steps;
    }

    public void changeTitle(String title){
        this.title = title;
    }

    public void changeUsername(String username){
        this.username = username;
    }

    public void changeServingSize(int size){
        this.serving_size = size;
    }

    public void changeIngredients(Ingredient[] ingredients){
        this.ingredients = ingredients;
    }

    public void changeTags(String[] tags){
        this.tags = tags;
    }

    public void changeSteps(String[] steps){
        this.steps = steps;
    }

    public String getTitle(){
        return this.title;
    }

    public String getUsername() { return this.username; }

    public int getServingSize(){
        return this.serving_size;
    }

    public Ingredient[] getIngredients(){
        return this.ingredients;
    }

    public String[] getTags(){
        return this.tags;
    }

    public String[] getSteps(){
        return this.steps;
    }
}
