package com.lions.cookbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.lions.cookbook.databinding.CreateRecipeActivityBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * VIEW: Displays the create recipe screen
 */
public class CreateRecipeActivity extends AppCompatActivity implements CreateRecipeContract.CreateRecipeMVPView {
    private CreateRecipeModel model;
    private CreateRecipePresent presenter;
    private ArrayList<String> recipesteps;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> ingredients;
    private ArrayAdapter<String> ingredientsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.create_recipe_activity);
        model = new CreateRecipeModel(this.getApplication());
        presenter = new CreateRecipePresent(this, model);
        CreateRecipeActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.create_recipe_activity);
        binding.setPresenter(presenter);
        //String[] filler = {"one"};
        ListView lv = (ListView) findViewById(R.id.steps);
        recipesteps = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recipesteps);
        lv.setAdapter(arrayAdapter);

        ListView ingredients_lv = (ListView) findViewById(R.id.ingredients);
        ingredients = new ArrayList<>();
        ingredientsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredients);
        ingredients_lv.setAdapter(ingredientsAdapter);

    }

    @Override
    public void goToCookBookScreen() {
        Intent intent = new Intent(this, CookBookActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Taking user to CookBook Screen", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showUnfilledError() {
        Toast.makeText(this, "All fields must be filled in!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessfulCreation() {
        Toast.makeText(this, "Recipe has been successfully made!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCreationError() {
        Toast.makeText(this, "There was an error in saving your recipe", Toast.LENGTH_SHORT).show();

    }

    @Override
    public ArrayList getRecipeIngredients() {
        return this.ingredients;
    }

    @Override
    public String getServingSize() {
        EditText text = findViewById(R.id.serving_size);
        String value = text.getText().toString();
        return value;
    }

    @Override
    public ArrayList getRecipeSteps() {
        return this.recipesteps;
    }

    @Override
    public String getRecipeTitle() {
        EditText text = findViewById(R.id.recipe_title);
        String title = text.getText().toString();
        return title;
    }

    @Override
    public String getNewStep() {
        EditText text = findViewById(R.id.stepField);
        String aStep = text.getText().toString();
        return aStep;
    }

    @Override
    public void addNewStep(String new_step) {
        recipesteps.add(new_step);
        arrayAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Added new step", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getNewIngredient() {
        EditText text = findViewById(R.id.ingredientField);
        String ingredient = text.getText().toString();
        return ingredient;
    }

    @Override
    public void addNewIngredient(String new_ingredient) {
        ingredients.add(new_ingredient);
        ingredientsAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Added new ingredients", Toast.LENGTH_SHORT).show();

    }
}
