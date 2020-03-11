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
import com.google.firebase.database.ValueEventListener;

public class CreateAccountModel implements CreateAccountContract.CreateAccountMVPModel {
    private DatabaseReference db;

    public CreateAccountModel(DatabaseReference db){
        this.db = db;
    }

    public boolean passwordStrong(String password){
        return (password.length() >= 6);
    }

    public boolean validEmail(String email){
        return (email.endsWith(".com"));
    }

    public boolean isUsernameUnique(String username){
        return ! (db.child(username).getRoot() == null);
    }

    public boolean addNewUser(String email,String userPassword){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        if (passwordStrong(userPassword)){
            if (validEmail(email)){
                mAuth.createUserWithEmailAndPassword(email, userPassword);
                FirebaseUser new_user = mAuth.getCurrentUser();
                //add user to recipe database
                this.db.child("recipes").child(new_user.getUid().toString()).setValue("");
                return true;
            }
        }
        return false;
    }

    public boolean setUsername(String username){
        if (isUsernameUnique(username)) {
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            FirebaseUser new_user = mAuth.getCurrentUser();
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(username).build();
            new_user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Log.d("profile update", "User profile updated.");
                        Log.d("displayname", "displayname is: " + new_user.getDisplayName());
                    }
                }
            });
            return true;
        }
        return false;
    }

    public void storeUserInfo(String userName, String firstName, String lastName, String phone) {
        String fullname = firstName.concat((" ").concat((lastName)));
        db.child("usernames/" + userName).setValue(fullname);
    }
}
