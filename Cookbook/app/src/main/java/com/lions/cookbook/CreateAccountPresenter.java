package com.lions.cookbook;

import android.content.Intent;
import android.text.TextUtils;


public class CreateAccountPresenter implements CreateAccountContract.CreateAccountPresenter {

    private CreateAccountContract.CreateAccountView view;
    private CreateAccountContract.CreateAccountModel model;

    private String username;
    private String userPassword;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userPhoneNumber;



    public CreateAccountPresenter(CreateAccountContract.CreateAccountView nView,CreateAccountContract.CreateAccountModel nModel) {
        view = nView;
        model = nModel;

    }

    @Override
    public void handleCreateAccountClicked(View view) {
    	//Get Input from user
        boolean any_errors = false;

        this.username = nView.getUsername();
        this.userPassword = nView.getPassword();
    	this.userFirstName = nView.getFirstName();
    	this.userLastName = nView.getLastName();
    	this.userPhoneNumber = getPhoneNumber();
    	this.userEmail = nView.getEmail();


        if (this.username == null || this.username.equals("")){
            any_errors = true;
        }else if (this.userPassword == null || this.userPassword.equals("")){
            any_errors = true;
        }else if (this.userFirstName == null || this.userFirstName.equals("")){
            any_errors = true;
        }else if (this.userLastName == null || this.userLastName.equals("")){
            any_errors = true;
        }else if (this.userEmail == null || this.userEmail.equals("")){
            any_errors = true;
        }else if (this.userPhoneNumber == null || this.userPhoneNumber.equals("")){
            any_errors = true;
        }

        if (any_errors){

            nView.showUnfilledError();

        } else if (nModel.userExists()){

            nView.showCreateAccountFailure();

        } else{
        	//add new user's info to the database
            Boolean res = nModel.addNewUser(this.username,this.userPassword,
        					  this.userFirstName,this.userLastName,
        					  this.userPhoneNumber,this.userEmail);

            if (res){
                nView.showCreateAccountSuccess()();
                nView.goToLoginScreen();
            }else{
                nView.showCreateAccountFailure();
            }
        	

        }

    }


    @Override
    public void handleGoToCookBookScreen(View view) {
        view.goToCookBookScreen();
    }


}
