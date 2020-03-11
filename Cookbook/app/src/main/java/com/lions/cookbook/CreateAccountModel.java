package com.lions.cookbook;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class CreateAccountModel implements CreateAccountContract.CreateAccountMVPModel {
    private DatabaseReference db;
    private FirebaseAuth mAuth;

    public CreateAccountModel(DatabaseReference db){
        this.db = db;
        this.mAuth = FirebaseAuth.getInstance();
    }

    public boolean passwordStrong(String password){
        return (password.length() >= 6);
    }

    public boolean validEmail(String email){
        return (email.endsWith(".com"));
    }

    public boolean addNewUser(String email,String userPassword){
        if (passwordStrong(userPassword)){
            if (validEmail(email)){
                this.mAuth.createUserWithEmailAndPassword(email, userPassword);
                this.mAuth.signInWithEmailAndPassword(email, userPassword);
                //add user to recipe database
                return true;
            }
        }
        return false;
    }

    public void storeUserInfo(String userName, String firstName, String lastName) {
        FirebaseUser curr_user = mAuth.getCurrentUser();
        String fullname = firstName.concat((" ").concat((lastName)));
        db.child("users").child(curr_user.getUid()).child("username").setValue(userName);
        db.child("users").child(curr_user.getUid()).child("fullname").setValue(fullname);
    }
}
