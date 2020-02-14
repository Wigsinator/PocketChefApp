package com.lions.cookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class cookbookViewActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookbook_view);

        listView = (ListView)findViewById(R.id.recipeList);
        ArrayList<String> rList = new ArrayList<>();
        rList.add("Example Recipe 1");
        rList.add("Example Recipe 2");
        rList.add("Example Recipe 3");

        ArrayAdapter recipeAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,
                rList);

        listView.setAdapter(recipeAdapter);
    }


}
