package com.lions.cookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PrivateUserProfileActivity extends AppCompatActivity implements PrivateUserProfileContract.PrivateUserProfileView{
    private PrivateUserProfilePresent presenter;
    private PrivateUserProfileModel model;
    private DatabaseReference mDatabase;
    private ArrayAdapter<String> arrayAdapter;

    private Button settingsBtn;
    private Button dietaryBtn;
    private Button followingBtn;
    private Button followersBtn;
    private Button logoutBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_account_private_activity);//set layout name with actual name

        //Set up values
        mDatabase = FirebaseDatabase.getInstance().getReference();
        this.model = new PrivateUserProfileModel(mDatabase);
        this.presenter = new PrivateUserProfilePresent(this, this.model);

        this.dietaryBtn = (Button) this.findViewById(R.id.dietaryBtn);
        this.dietaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // this.presenter.handleLogoutClicked();
            }
        });

        this.settingsBtn = (Button) this.findViewById(R.id.settingsBtn);
        this.settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this.presenter.handleLogoutClicked();
            }
        });

        this.followingBtn = (Button) this.findViewById(R.id.followingBtn);
        this.followingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // this.presenter.handleLogoutClicked();
            }
        });

        this.followersBtn = (Button) this.findViewById(R.id.followersBtn);
        this.followersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this.presenter.handleLogoutClicked();
            }
        });


        //set event handler to sign up button
        this.logoutBtn = (Button) this.findViewById(R.id.logoutBtn);
        this.logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                this.presenter.handleLogoutClicked();
            }
        });

        //Populate other info


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


        //Set up Navigation panel
        BottomNavigationView navigationPanel = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationPanel.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_create:
                                Intent intent1 = new Intent(PrivateUserProfileActivity.this, CreateRecipeActivity.class);
                                startActivity(intent1);
                                break;

                            case R.id.navigation_cookbook:
                                Intent intent2 = new Intent(PrivateUserProfileActivity.this, CookBookActivity.class);
                                startActivity(intent2);
                                break;
                        }
                        return false;
                    }
                });
    }
}
