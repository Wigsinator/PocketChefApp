package com.lions.cookbook;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

public class LoginPresent implements LoginContract.LoginPresenter {

    private LoginContract.LoginView view;
    private LoginContract.LoginModel model;

    private String userEmail;
    private String userPassword;

    private FirebaseUser curr_user;

   // UserPreferences mDatabase = new UserPreferencesImpl();

    public LoginPresent(LoginContract.LoginView nView,LoginContract.LoginModel nModel) {
        this.view = nView;
        this.model = nModel;
    }

    @Override
    public void handleLoginClicked(View view) {
        //Get Input from user
        boolean any_errors = false;

        this.userEmail = this.view.getEmail();
        this.userPassword = this.view.getPassword();


        if (this.userEmail == null || this.userEmail.equals("")
        || this.userPassword == null || this.userPassword.equals("") ){

            this.view.showUnfilledError();

        } else{
            Log.d("Retrieve info","Username:" + this.userEmail + "password" + this.userPassword);

            //validate user's info from the database
            if (this.model.signIn(this.userEmail, this.userPassword)){

                curr_user = this.model.getCurrentUser();
                this.view.showLoginSuccess();
                this.view.goToCreateRecipeScreen();

            }else{
                this.view.showLoginFailure();
            }

        }

    }

}