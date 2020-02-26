package com.lions.cookbook;

import android.content.Intent;
import android.text.TextUtils;


public class LoginPresent implements LoginContract.LoginPresenter {

    private LoginContract.LoginView view;
    private LoginContract.LoginModel model;

   // UserPreferences mDatabase = new UserPreferencesImpl();

    public LoginPresent(LoginContract.LoginView nView,LoginContract.LoginModel nModel) {
        view = nView;
        model = nModel;
    }


    @Override
    public void checkUserLoginCredentials(String userName, String userPass){
        return;
    }

    @Override
    public void goToCreateAccountScreen(){
        return;
    }

    /**
     * validate login data here
     * and if data valid, redirect to main screen.
     */
    /**
    public void login(String username, String password) {
        if(TextUtils.isEmpty(username)){
            this.view.showError("Please enter username");
        }else if(username.length() < 6){
            this.view.showError("Username must contains 6 letters");
        }else if(TextUtils.isEmpty(password)){
            this.view.showError("Please enter password");
        }else if(password.length() < 6){
            this.view.showError("Password must contains 6 letters");
        }else {
          //  mDatabase.setUserLogin(true);
            this.view.showMainActivity();
        }
    }
     */
}