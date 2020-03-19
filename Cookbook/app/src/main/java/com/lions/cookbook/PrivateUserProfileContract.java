package com.lions.cookbook;

import android.view.View;

import java.util.ArrayList;


public class PrivateUserProfileContract {

    interface PrivateUserProfilePresenter{
        void handleLogoutClicked();
        ArrayList getUserRecipes();

    }

    interface PrivateUserProfileModel {
        String getCurrentFirstname();
        String getCurrentLastname();
        String getCurrentUsername();
        String getCurrentPhonenumber();
        String getCurrentEmail();
        ArrayList<String> getAllUserRecipes();

        void signOut();
    }


    interface PrivateUserProfileView{
        void goToCreateAccountScreen();
        void goToCookBookScreen();
        String getEmail();
        String getPassword();
        void goToLoginScreen();
        void showUnfilledError();
        void showLoginFailure();
        void showLoginSuccess();

}

}
