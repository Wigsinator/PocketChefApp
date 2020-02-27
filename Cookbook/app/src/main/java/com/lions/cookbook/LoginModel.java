package com.lions.cookbook;

public class LoginModel implements LoginContract.LoginModel {

    LoginModel(){

    }

    @Override
    public String getUsername(){
        return null;
    }

    @Override
    public String getPassword(){
        return null;
    }

    @Override
    public Boolean checkUserLoginCredentials(String userName, String userPass){
        return true;
    }
}
