package com.lions.cookbook;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewRecipeModel implements ViewRecipeContract.ViewRecipeMVPModel {

    private DatabaseReference mref;
    private Recipe recipe;
    private ViewRecipeContract.ViewRecipeMVPPresenter mpresenter;

    public ViewRecipeModel(ViewRecipeContract.ViewRecipeMVPPresenter presenter, String recipeKey){
        this.mpresenter = presenter;
        this.recipe = null;
        this.mref = FirebaseDatabase.getInstance().getReference().child("recipes").child(recipeKey);
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                recipe = dataSnapshot.getValue(Recipe.class);
                mpresenter.populateValues(recipe);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                recipe = null;
                Log.e("Recipe Read:", "Read Cancelled");
            }
        };
        this.mref.addListenerForSingleValueEvent(listener);

    }

    @Override
    public Recipe getRecipe() {
        return this.recipe;
    }

    @Override
    public Boolean deleteRecipe() {
        return Boolean.TRUE;
    }
}
