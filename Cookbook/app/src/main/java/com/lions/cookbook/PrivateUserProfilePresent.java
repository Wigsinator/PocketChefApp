package com.lions.cookbook;

import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

public class PrivateUserProfilePresent implements PrivateUserProfileContract.PrivateUserProfilePresenter{

    private PrivateUserProfileContract.PrivateUserProfileView nView;
    private PrivateUserProfileContract.PrivateUserProfileModel nModel;
    private ArrayList RecipeList;
    private SessionManager UserPref;


    PrivateUserProfilePresent(PrivateUserProfileContract.PrivateUserProfileView view, PrivateUserProfileContract.PrivateUserProfileModel model){
        this.nView = view;
        this.nModel = model;
        this.UserPref = new SessionManager();
    }

    @Override
    public ArrayList getRecipeNames() {
        //return nModel.getRecipeNamesDB();
        return null;
    }

    @Override
    public void handleLogoutClicked() {
        this.UserPref.clearUser();
        nView.goToLoginScreen();
        nModel.signOut();
    }

    @Override
    public void handleRecipeClicked(String recipeName) {
        Log.d("TEST", "Finish getting recipe");
        nView.goToViewRecipe(recipeName);
        Log.d("TEST", "able to go to view recipe");
    }


}
