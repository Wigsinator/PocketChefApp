package com.lions.cookbook;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

public class LoginModel implements LoginContract.LoginModel{
    private FirebaseAuth mAuth;
    private Boolean signedIn;

    public LoginModel(){
        mAuth = FirebaseAuth.getInstance();
        signedIn = false;
    }

    public boolean signIn(String email, String password){
        OnCompleteListener signinListeneter = new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                signedIn = true;
            }
        };
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(signinListeneter);
        return signedIn;
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
