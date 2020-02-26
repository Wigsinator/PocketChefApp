package com.lions.cookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * VIEW: Displays the CookBook Screen
 */
public class CookBookActivity extends AppCompatActivity implements CookBookContract.CookBookMVPView{
    private CookBookPresent presenter;
    private CookBookModel model1;
    private ArrayAdapter<String> arrayAdapter;

    //Good Tutorial on listView: https://abhiandroid.com/ui/listview for texts and pictures
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cook_book_activity);

        //Set up values
        model1 = new CookBookModel(this.getApplication(), this);
        presenter = new CookBookPresent(this, model1);

        //Populate with List of Recipe names
        final ListView RecipeList = (ListView)findViewById(R.id.recipeList); //Fill in with actual id of List view
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, presenter.getRecipeNames());
        RecipeList.setAdapter(arrayAdapter);
        RecipeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String recipeName = (String) RecipeList.getItemAtPosition(i);
                presenter.handleRecipeClicked(recipeName);
            }
        });

    }



    @Override
    public void goToCreateRecipeScreen() {
        Intent intent = new Intent(this, CreateRecipeActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Taking user to CreateRecipe Screen", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToViewRecipe(String clickedRecipe) {
        Intent intent = new Intent(this, ViewRecipeActivity.class);
        intent.putExtra("RECIPE", clickedRecipe);
        Log.d("TEST", "Created recipe to be trasnferd to new intent");
        startActivity(intent);
        Log.d("TEST", "Starting new intent");

    }

}
