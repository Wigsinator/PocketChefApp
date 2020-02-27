package com.lions.cookbook;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;


public class LoginPresent implements LoginContract.LoginPresenter {

    private LoginContract.LoginView view;
    private LoginContract.LoginModel model;

    private String username;
    private String userPassword;

   // UserPreferences mDatabase = new UserPreferencesImpl();

    public LoginPresent(LoginContract.LoginView nView,LoginContract.LoginModel nModel) {
        view = nView;
        model = nModel;
    }

    @Override
    public void handleLoginClicked(View view) {
        //Get Input from user
        boolean any_errors = false;

        this.username = this.view.getEmail();
        this.userPassword = this.view.getPassword();


        if (this.username == null || this.username.equals("")){
            any_errors = true;
        }else if (this.userPassword == null || this.userPassword.equals("")){
            any_errors = true;
        }

        if (any_errors){

            this.view.showUnfilledError();

        } else{
            Log.d("Retrieve info","Username:" + this.username + "password" + this.userPassword);
            Boolean res = true;

            //validate user's info from the database
            //res = this.model.checkUserLoginCredentials(username, userPassword);
            if (this.username.equals("test@gmail.com") && this.userPassword.equals("123456")){
                res = true;
            }else{
                res = false;
            }

            if (res){
                this.view.showLoginSuccess();
                this.view.goToCreateRecipeScreen();
            }else {
                this.view.showLoginFailure();
            }

        }

    }

}