package com.lions.cookbook;

import android.view.View;

import java.util.ArrayList;


public class PrivateUserProfileContract {

    interface PrivateUserProfilePresenter{
        void handleLogoutClicked();
        ArrayList getRecipeNames();
        void handleRecipeClicked(String recipeName);

    }

    interface PrivateUserProfileModel {

        String getFullname();
        String getUsername();
        String getPhoneNumber();
        String getEmail();
        ArrayList<String> getRecipes();

        void signOut();
    }


    interface PrivateUserProfileView{
        void goToViewRecipe(String clickedRecipe);
        void goToLoginScreen();

}

}
