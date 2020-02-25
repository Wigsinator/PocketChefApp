package com.lions.cookbook;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;

public class CreateAccountModel {
    private FirebaseAuth mAuth;

    public CreateAccountModel(){
        mAuth = FirebaseAuth.getInstance();
    }

    public boolean AddNewUser(String email,String userPassword){
        Task<AuthResult> addUserResult = mAuth.createUserWithEmailAndPassword(email, userPassword);
        //if successful returns true; if email already in use then return false
        return addUserResult.isSuccessful();
    }

    public FirebaseAuth getmAuth(){
        return mAuth;
    }
}
