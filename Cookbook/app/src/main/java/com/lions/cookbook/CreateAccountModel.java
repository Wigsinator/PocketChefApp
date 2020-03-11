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

    public boolean isUsernameUnique(String username){
        return (db.child(username).child(username) != null);
    }

    public boolean addNewUser(String email,String userPassword){
        if (passwordStrong(userPassword)){
            if (validEmail(email)){
                FirebaseAuth.AuthStateListener listener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                    }
                };
                mAuth.addAuthStateListener(listener);
                this.mAuth.createUserWithEmailAndPassword(email, userPassword);
                this.mAuth.signInWithEmailAndPassword(email, userPassword);
                //add user to recipe database
                return true;
            }
        }
        return false;
    }

    public boolean setUsername(String username){
        if (isUsernameUnique(username)) {
            FirebaseUser new_user = this.mAuth.getCurrentUser();
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(username).build();
            new_user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Log.d("email and username", new_user.getEmail() + new_user.getDisplayName());
                        Log.d("profile update", "User profile updated.");
                    }
                    else{
                        Log.d("profile update", "user profile did not update");
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

    public FirebaseAuth getmAuth(){
        return this.mAuth;
    }
}
