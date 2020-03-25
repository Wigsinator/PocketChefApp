package com.lions.cookbook;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class PublicUserProfileModel implements PublicUserProfileContract.PublicUserProfileModel {
    FirebaseAuth mAuth;
    DatabaseReference db;
    //these variables below hold user info read from db
    String foundUsername;
    String foundFullname;
    ArrayList<String> foundRecipes;


    public PublicUserProfileModel(DatabaseReference db){
        this.mAuth = FirebaseAuth.getInstance();
        this.db = db;
    }

    @Override
    public String getFullname(){
        return null;
    }

    @Override
    public String getUsername(){
        return null;
    }

    @Override
    public ArrayList<String> getRecipes(){
        return null;
    }
}
