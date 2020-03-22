package com.lions.cookbook;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class PrivateProfileModel{
    FirebaseAuth mAuth;
    DatabaseReference db;
    String foundUsername;
    String[] foundFullname;
    String foundPhoneNumber;
    ArrayList<Recipe> foundRecipes;

    public PrivateProfileModel(DatabaseReference db){
        this.mAuth = FirebaseAuth.getInstance();
        this.db = db;
    }

    public void signOut(){
        FirebaseUser profileOwner = mAuth.getCurrentUser();
        mAuth.signOut();
    }

    //referred to https://subscription.packtpub.com/book/web_development/9781788624718/1/ch01lvl1sec12/reading-and-writing-to-realtime-database
    public String getUsername(){
        FirebaseUser profileOwner = mAuth.getCurrentUser();
        ValueEventListener userNameListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                foundUsername = dataSnapshot.child("users").child(profileOwner.getUid()).child("username").getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                foundUsername = null;
            }
        };
        db.addListenerForSingleValueEvent(userNameListener);
        return foundUsername;
    }

    public void findFullname(){
        FirebaseUser profileOwner = mAuth.getCurrentUser();
        ValueEventListener fullNameListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                foundFullname = dataSnapshot.child("users").child(profileOwner.getUid()).child("fullname").getValue(String.class).split(" ");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                foundFullname = null;
            }
        };
        db.addListenerForSingleValueEvent(fullNameListener);
    }

    public String getFirstName(){
        findFullname();
        return foundFullname[0];
    }

    public String getLastName(){
        findFullname();
        return foundFullname[1];
    }

    public String getEmail(){
        FirebaseUser currUser = mAuth.getCurrentUser();
        return currUser.getEmail();
    }

    public String getPhoneNumber(){
        FirebaseUser profileOwner = mAuth.getCurrentUser();
        ValueEventListener phoneListener = new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                foundPhoneNumber = dataSnapshot.child("users").child(profileOwner.getUid()).child("phone").getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                foundPhoneNumber = null;
            }
        };
        db.addListenerForSingleValueEvent(phoneListener);
        return foundPhoneNumber;
    }

    public ArrayList<Recipe> getRecipes(){
        FirebaseUser profileOwner = mAuth.getCurrentUser();
        ValueEventListener recipeListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot recipeSnapshot: dataSnapshot.child("users").child(profileOwner.getUid()).child("cookbook").getChildren()) {
                    foundRecipes.add(recipeSnapshot.getValue(Recipe.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                foundRecipes = null;
            }
        };
        db.addListenerForSingleValueEvent(recipeListener);
        return foundRecipes;
    }

    public void changePassword(String newPassword){
        FirebaseUser currUser = mAuth.getCurrentUser();
        currUser.updatePassword(newPassword);
    }

    public void changeName(String newName){
        FirebaseUser currUser = mAuth.getCurrentUser();
        db.child("users").child(currUser.getUid()).child("fullName").setValue(newName);
    }

}