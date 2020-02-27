package com.lions.cookbook;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

public class CreateAccountModel implements CreateAccountContract.CreateAccountMVPModel {

    public CreateAccountModel(){}

    public Boolean addNewUser(String email,String userPassword){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        //Task<AuthResult> res  = mAuth.createUserWithEmailAndPassword(email, userPassword);
        //return res.isSuccessful();
        return true;
    }
}
