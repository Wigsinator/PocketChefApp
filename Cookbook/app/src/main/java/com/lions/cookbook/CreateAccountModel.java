package com.lions.cookbook;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;

public class CreateAccountModel implements CreateAccountContract.CreateAccountModel {

    public CreateAccountModel(){}

    public Boolean addNewUser(String email,String userPassword){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        Task<AuthResult> addUserResult = mAuth.createUserWithEmailAndPassword(email, userPassword);
        //if successful returns true; if email already in use then return false
        return addUserResult.isSuccessful();
    }
}
