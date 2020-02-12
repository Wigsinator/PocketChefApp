package com.lions.cookbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.lions.cookbook.databinding.CreateRecipeActivityBinding;

/**
 * VIEW: Displays the create recipe screen
 */
public class CreateRecipeActivity extends AppCompatActivity implements CreateRecipeContract.CreateRecipeMVPView {
    private CreateRecipeModel model;
    private CreateRecipePresent presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.create_recipe_activity);
        model = new CreateRecipeModel();
        presenter = new CreateRecipePresent(this, model);
        CreateRecipeActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.create_recipe_activity);
        binding.setPresenter(presenter);

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
    public String getRecipeIngredients() {
        return null;
    }

    @Override
    public Integer getServingSize() {
        //findViewById()
        return null;
    }

    @Override
    public String getRecipeSteps() {
        return null;
    }

    @Override
    public String getRecipeTitle() {
        return null;
    }
}
