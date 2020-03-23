package com.lions.cookbook;

import android.util.Log;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PrivateUserProfilePresent implements PrivateUserProfileContract.PrivateUserProfilePresenter, PrivateProfileObserver{

    private PrivateUserProfileContract.PrivateUserProfileView nView;
    private PrivateUserProfileContract.PrivateUserProfileModel nModel;
    private ArrayList RecipeList;
    private SessionManager UserPref;

    String userEmail;
    String userPhoneNumber;
    String userUsername;
    String userFullName;
    ArrayList<String> recipeNames;


    PrivateUserProfilePresent(PrivateUserProfileContract.PrivateUserProfileView view, PrivateUserProfileContract.PrivateUserProfileModel model){
        this.nView = view;
        this.nModel = model;
        //add the observer to the observer array list
        this.nModel.addObserver(this);
    }

    @Override
    public void update(String email, String phone, String username, String Fullname, ArrayList<String> recipes){
        this.userEmail = email;
        this.userFullName = Fullname;
        this.userUsername = username;
        this.userPhoneNumber = phone;
        this.recipeNames = recipes;
    }

    @Override
    public ArrayList getRecipeNames() {
        return this.recipeNames;
        //String[] filler_recipes = {"Spaghetti", "Whole Wheat Bread", "Bread Pudding", "Chow Mein"};
        //ArrayList<String> RecipeList = new ArrayList<>(Arrays.asList(filler_recipes));
        //return RecipeList;
    }

    @Override
    public void handleLogoutClicked() {
        this.UserPref.clearUser();
        nView.goToLoginScreen();
        nModel.signOut();
    }

    @Override
    public String[] getFullName(){
        String fullname = this.userFullName;
        String[] arrOfnames = fullname.split(" ", 3);
        return arrOfnames;
    }

    @Override
    public String getEmail(){
        return this.userEmail;
    }

    @Override
    public String getPhoneNumber(){
        return this.userPhoneNumber;
    }

    @Override
    public String getUsername(){
        return this.userUsername;
    }

    @Override
    public void handleRecipeClicked(String recipeName) {
        Log.d("TEST", "Finish getting recipe");
        nView.goToViewRecipe(recipeName);
        Log.d("TEST", "able to go to view recipe");
    }

}
