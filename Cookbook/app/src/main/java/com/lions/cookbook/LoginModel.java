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
    public int checkUserValidity(String name, String password){
        return 0;
    }
}
