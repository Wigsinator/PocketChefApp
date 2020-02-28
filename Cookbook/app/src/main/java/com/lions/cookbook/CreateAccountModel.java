package com.lions.cookbook;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

public class CreateAccountModel implements CreateAccountContract.CreateAccountMVPModel {

    public CreateAccountModel(){}

    public Boolean passwordStrong(String password){
        return (password.length() >= 6);
    }

    public Boolean validEmail(String email){
        return (email.endsWith("@gmail.com"));
    }

    public Boolean addNewUser(String email,String userPassword){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        if (passwordStrong(userPassword)){
            if (validEmail(email)){
                mAuth.createUserWithEmailAndPassword(email, userPassword);
                return true;
            }
        }
        return false;
    }
}
