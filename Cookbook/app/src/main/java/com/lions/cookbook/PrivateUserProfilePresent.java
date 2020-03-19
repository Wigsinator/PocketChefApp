package com.lions.cookbook;

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
    public ArrayList getUserRecipes() {
        //return nModel.getRecipeNamesDB();
        return null;
    }

    @Override
    public void handleLogoutClicked() {
        this.UserPref.clearUser();
        nView.goToLoginScreen();
    }


}
