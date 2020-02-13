package com.lions.cookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        String recipeName = getIntent().getStringExtra("RECIPE_NAME");
        TextView tv = (TextView)findViewById(R.id.textView) ;
        tv.setText(recipeName);
    }
}
