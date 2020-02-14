package com.lions.cookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ViewRecipeActivity extends AppCompatActivity {
    private ArrayList<String> recipesteps;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> ingredients_list;
    private ArrayAdapter<String> ingredientsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        String recipeName = getIntent().getStringExtra("RECIPE_NAME");
        TextView tv = (TextView)findViewById(R.id.RecipeTitle) ;
        tv.setText(recipeName);
        String[] filler_steps = {"Read the recipe", "Buy the ingredients", "Cook!"};
        recipesteps = new ArrayList<String>(Arrays.asList(filler_steps));

        final ListView RecipeList = (ListView)findViewById(R.id.steps); //Fill in with actual id of List view
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recipesteps);
        RecipeList.setAdapter(arrayAdapter);

        String[] filler_ingredients = {"Whole wheat flour,      500g", "Potatoes      2kg"};
        ingredients_list = new ArrayList<String>(Arrays.asList(filler_ingredients));
        final ListView ingredients_view = (ListView)findViewById(R.id.ingredients); //Fill in with actual id of List view
        ingredientsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredients_list);
        ingredients_view.setAdapter(ingredientsAdapter);
    }
}
