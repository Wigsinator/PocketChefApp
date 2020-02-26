package com.lions.cookbook;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lions.cookbook.databinding.ActivityViewRecipeBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewRecipeActivity extends AppCompatActivity implements ViewRecipeContract.ViewRecipeMVPView {
    private ViewRecipeContract.ViewRecipeMVPModel model;
    private ViewRecipeContract.ViewRecipeMVPPresenter presenter;
    private ArrayList<String> recipesteps;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> ingredients_list;
    private ArrayAdapter<String> ingredientsAdapter;
    private Recipe originalRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);

        //Set binding for createRecipe_activity and presenter
        //ActivityViewRecipeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_view_recipe);
        //binding.setPresenter(this.presenter);

        //Set up values
        model = new ViewRecipeModel();
        presenter = new ViewRecipePresenter(this, model);
        String recipeName = getIntent().getStringExtra("RECIPE_NAME");
        Recipe recipeClicked = presenter.fetchRecipe(recipeName);
        originalRecipe = recipeClicked;

        //Populate Recipe Title
        TextView tv = (TextView)findViewById(R.id.RecipeTitle) ;
        tv.setText(recipeClicked.getTitle());

        //Populate Recipe steps
        recipesteps = new ArrayList<String>(recipeClicked.getSteps());
        final ListView RecipeList = (ListView)findViewById(R.id.steps); //Fill in with actual id of List view
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recipesteps);
        RecipeList.setAdapter(arrayAdapter);

        //Populate Recipe ingredients
        List<Ingredient> ingredients = originalRecipe.getIngredients();
        ingredients_list = new ArrayList<String>();
        for (int i = 0; i< ingredients.size(); i ++){
            String ingredient_compiled = ingredients.get(i).getName() + ", " + String.valueOf(ingredients.get(i).getQuantity()) + ", " + ingredients.get(i).getQuantityType();
            ingredients_list.add(ingredient_compiled);
        }
        final ListView ingredients_view = (ListView)findViewById(R.id.ingredients); //Fill in with actual id of List view
        ingredientsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredients_list);
        ingredients_view.setAdapter(ingredientsAdapter);

        //Populate Serving size
        TextView servingSize = findViewById(R.id.ServingSize);
        servingSize.setText(String.valueOf(recipeClicked.getServingSize()));

    }

    @Override
    public String getServingSize() {
        EditText text = findViewById(R.id.newServingSize);
        String value = text.getText().toString();
        return value;
    }

    @Override
    public void showServingNull() {
        Toast.makeText(this, "Please enter a valid Serving size", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Recipe getOriginalRecipe() {
        return this.originalRecipe;
    }

    @Override
    public void updateIngredients(ArrayList<Ingredient> ingredients) {
        ingredients_list.clear();
        for (int i = 0 ; i< ingredients.size(); i++){
            String new_ingredient = ingredients.get(i).getName() + ", " + ingredients.get(i).getQuantity() + ", " + ingredients.get(i).getQuantityType();
            ingredients_list.add(new_ingredient);
        }
        ingredientsAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Serving size scaled", Toast.LENGTH_SHORT).show();

    }

    public void test (View view){
        presenter.handleAlterPressed();
    }
}
