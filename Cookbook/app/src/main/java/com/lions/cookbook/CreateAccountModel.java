package com.lions.cookbook;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
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

    public boolean addNewUser(String email,String userPassword, String username, String firstname, String lastname, String phone){
        if (passwordStrong(userPassword)){
            if (validEmail(email)){

                OnCompleteListener accountCreationListener = new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        storeUserInfo(username, firstname, lastname, phone );
                    }
                };
                mAuth.createUserWithEmailAndPassword(email, userPassword).addOnCompleteListener(accountCreationListener);
                return true;
            }
        }
        return false;
    }

    public void storeUserInfo(String userName, String firstName, String lastName, String phone) {
        FirebaseUser curr_user = mAuth.getCurrentUser();
        Log.d("new user", this.mAuth.getCurrentUser().getEmail());
        String fullname = firstName.concat((" ").concat((lastName)));
        db.child("users").child(curr_user.getUid()).child("username").setValue(userName);
        db.child("users").child(curr_user.getUid()).child("fullname").setValue(fullname);
        db.child("users").child(curr_user.getUid()).child("phone").setValue(phone);
    }
}