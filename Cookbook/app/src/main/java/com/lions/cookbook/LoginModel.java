package com.lions.cookbook;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

public class LoginModel implements LoginContract.LoginModel{
    private FirebaseAuth mAuth;

    public LoginModel(){
        mAuth = FirebaseAuth.getInstance();
    }

    public boolean signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password);
        Log.d("currUser", mAuth.getCurrentUser().getEmail());
        return mAuth.getCurrentUser() != null && (mAuth.getCurrentUser().getEmail().equals(email));
    }

    //returns FirebaseUser if someone signed in, returns null otw
    public FirebaseUser getCurrentUser(){
        return mAuth.getCurrentUser();
    }

    public void signOut(){
        mAuth.signOut();
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }
}
