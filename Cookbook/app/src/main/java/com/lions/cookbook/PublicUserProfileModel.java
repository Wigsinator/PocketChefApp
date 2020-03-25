package com.lions.cookbook;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PublicUserProfileModel implements PublicUserProfileContract.PublicUserProfileModel {
    FirebaseAuth mAuth;
    DatabaseReference db;
    private ArrayList<PublicProfileObserver> observers = new ArrayList<PublicProfileObserver>();
    //these variables below hold user info read from db
    private String fullname;
    private ArrayList<String> recipes;

    public PublicUserProfileModel(DatabaseReference db){
        this.mAuth = FirebaseAuth.getInstance();
        this.db = db;
        this.recipes = new ArrayList<String>();
    }

    public String getFullname(String username){
        findFullname(username);
        return this.fullname;
    }

    public ArrayList<String> getRecipes(String username){
        findRecipes(username);
        return this.recipes;
    }

    public void addObserver(PublicProfileObserver observer){
        this.observers.add(observer);
    }

    public void notifyAllObservers(){
        for (PublicProfileObserver observer : this.observers) {
            observer.update(this.fullname, this.recipes);
        }
    }

    public void findFullname(String username){
        Query query = db.child("users").orderByChild("username").equalTo(username);
        ValueEventListener fullNameListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    fullname = dataSnapshot.child("fullname").getValue(String.class);
                    notifyAllObservers();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                fullname = null;
            }
        };
        query.addValueEventListener(fullNameListener);
    }

    public void findRecipes(String username){
        Query query = db.child("users").orderByChild("username").equalTo(username);

        ValueEventListener recipeListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot recipeSnapshot : dataSnapshot.child("recipes").getChildren()){
                        recipes.add(recipeSnapshot.getValue(String.class));
                        notifyAllObservers();
                    }

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                recipes = new ArrayList<String>();
            }
        };
        query.addValueEventListener(recipeListener);
        }
    }
