package com.lions.cookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * VIEW: Displays the CookBook Screen
 */
public class CookBookActivity extends AppCompatActivity implements CookBookContract.CookBookMVPView{
    private CookBookPresent presenter;
    private CookBookModel model1;

    //Good Tutorial on listView: https://abhiandroid.com/ui/listview for texts and pictures
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cook_book_activity);
        model1 = new CookBookModel();
        presenter = new CookBookPresent(this, model1);
        //Populate with List of Recipe names
        ListView simpleList = (ListView)findViewById(R.id.simpleListView); //Fill in with actual id of List view
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.cook_book_activity, R.id.textView, presenter.getRecipeNames());
        simpleList.setAdapter(arrayAdapter);
    }


    @Override
    public void goToCreateRecipeScreen() {
        Intent intent = new Intent(this, CreateRecipeActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Taking user to CreateRecipe Screen", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToViewRecipe(String recipeName, Integer servingSize, String ingredients, List steps) {

    }

    @Override
    public String getNameRecipeClicked() {
        return null;
    }
}
