package com.lions.cookbook;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountModel implements CreateAccountContract.CreateAccountMVPModel {
    private DatabaseReference db;

    public CreateAccountModel(DatabaseReference db){
        this.db = db;
    }

    public boolean passwordStrong(String password){
        return (password.length() >= 6);
    }

    public boolean validEmail(String email){
        return (email.endsWith("@gmail.com"));
    }

    public boolean addNewUser(String email,String userPassword){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        if (passwordStrong(userPassword)){
            if (validEmail(email)){
                mAuth.createUserWithEmailAndPassword(email, userPassword);
                /*

                FirebaseUser new_user = mAuth.getCurrentUser();
                //add user to recipe database
                db.child("recipes").child(new_user.getUid().toString()).setValue("");

                */
                return true;
            }
        }
        return false;
    }

    public void setUsername(String username){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser new_user = mAuth.getCurrentUser();
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(username).build();
        new_user.updateProfile(profileUpdates);
    }

    public void storeUserInfo(String userName, String firstName, String lastName, String phone) {
        String fullname = firstName.concat((" ").concat((lastName)));
        ArrayList<String> name_and_number = new ArrayList<String>();
        name_and_number.add(fullname);
        name_and_number.add(phone);
        this.db.child("usernames").child(userName).setValue(name_and_number);
    }
}
