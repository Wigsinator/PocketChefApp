package com.lions.cookbook;

import android.view.View;

public interface LoginContract {

    interface LoginPresenter{

        void handleLoginClicked(View view);

    }

    interface LoginModel {
        String getUsername();
        String getPassword();
        Boolean checkUserLoginCredentials(String userName, String userPass);
}


    interface LoginView{
        void goToCreateAccountScreen();
        void goToCookBookScreen();
        String getEmail();
        String getPassword();
        void goToCreateRecipeScreen();
        void showUnfilledError();
        void showLoginFailure();
        void showLoginSuccess();


       // void onLoginResult(Boolean result, int code);

     //   void showLogin();

     //   void hideLogin();

    }


}