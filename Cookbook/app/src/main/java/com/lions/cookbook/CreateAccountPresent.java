package com.lions.cookbook;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;


public class CreateAccountPresent implements CreateAccountContract.CreateAccountMVPPresenter{

    private CreateAccountContract.CreateAccountMVPView view;
    private CreateAccountContract.CreateAccountMVPModel model;

    private String username;
    private String userPassword;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userPhoneNumber;


    CreateAccountPresent(CreateAccountContract.CreateAccountMVPView nView,CreateAccountContract.CreateAccountMVPModel nModel) {
        view = nView;
        model = nModel;

    }

    @Override
    public void handleCreateAccountClicked(View view) {
    	//Get Input from user
        boolean any_errors = false;

        this.username = this.view.getUsername();
        this.userPassword = this.view.getPassword();
    	//this.userFirstName = this.view.getFirstName();
    	//this.userLastName = this.view.getLastName();
    	//this.userPhoneNumber = this.view.getPhoneNumber();
    	//this.userEmail = this.view.getEmail();


        if (this.username == null || this.username.equals("")){
            any_errors = true;
        }else if (this.userPassword == null || this.userPassword.equals("")){
            any_errors = true;
        }

        if (any_errors){

            this.view.showUnfilledError();

        } else{
            Log.d("Retrieve info","Username:" + this.username + "password" + this.userPassword);
        	//add new user's info to the database
            Boolean res = model.addNewUser(this.username,this.userPassword);
         
            if (res){
                this.view.showCreateAccountSuccess();
                this.view.goToLoginScreen();
            }else {
                this.view.showCreateAccountFailure();
            }

        }

    }


    @Override
    public void handleGoToLoginScreen(View view) {
        this.view.goToLoginScreen();
    }


}
