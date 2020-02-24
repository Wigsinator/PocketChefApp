package com.lions.cookbook;
import java.util.*;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Entity(primaryKeys = {"title","username"},tableName = "recipe_database")

public class Recipe {
    @NonNull
    private String title;
    @NonNull
    private String username;
    private int serving_size;
    @TypeConverters(RecipeListConverter.class)
    private List<Ingredient> ingredients;
    @TypeConverters(RecipeListConverter.class)
    private List<String> tags;
    @TypeConverters(RecipeListConverter.class)
    private List<String> steps;

    public Recipe(String title, String username,int serving_size, List<Ingredient> ingredients, List<String>tags, List<String> steps){
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

    public void changeIngredients(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    public void changeTags(List<String> tags){
        this.tags = tags;
    }

    public void changeSteps(List<String> steps){
        this.steps = steps;
    }

    public String getTitle(){
        return this.title;
    }

    public String getUsername() { return this.username; }

    public int getServingSize(){
        return this.serving_size;
    }

    public List<Ingredient> getIngredients(){
        return this.ingredients;
    }

    public List<String> getTags(){
        return this.tags;
    }

    public List<String> getSteps(){
        return this.steps;
    }
}

