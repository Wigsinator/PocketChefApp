package com.lions.cookbook;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

public class LoginModel {
    private FirebaseAuth mAuth;

    public LoginModel(){
        mAuth = FirebaseAuth.getInstance();
    }

    public boolean signIn(String email, String password){
        Task<AuthResult> signInIsSuccessful = mAuth.signInWithEmailAndPassword(email, password);
        return signInIsSuccessful.isSuccessful();
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
