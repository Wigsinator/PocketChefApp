package com.lions.cookbook;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CreateAccountModel implements CreateAccountContract.CreateAccountMVPModel {
    private DatabaseReference db;
    private FirebaseAuth mAuth;
    private String errorMessage;
    private ArrayList<CreateAccountObserver> observers;

    public CreateAccountModel(DatabaseReference db){
        this.db = db;
        this.mAuth = FirebaseAuth.getInstance();
        this.errorMessage = "";
        this.observers = new ArrayList<CreateAccountObserver>();
    }

    public void addObserver(CreateAccountObserver observer){
        observer.update(this.errorMessage);
    }

    public void validateUsername(String username){
        Query query = db.child("users").orderByChild("username").equalTo(username);
        ValueEventListener usernameListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("inside OnDataChange", "inside recipe OnDataChange");
                if (dataSnapshot.exists()){
                    errorMessage = "username already in use";
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                errorMessage = "";
            }
        };
        query.addValueEventListener(usernameListener);
    }

    public void validateEmail(String email) {
        if ((mAuth.fetchSignInMethodsForEmail(email).getResult().getSignInMethods()).size() != 0) {
            errorMessage = "email already in use";
        }
    }

    public void addNewUser(String email,String userPassword, String username, String firstname, String lastname, String phone){
        validateUsername(username);
        validateEmail(email);

        OnCompleteListener accountCreationListener = new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                storeUserInfo(username, firstname, lastname, phone );
            }
        };
        mAuth.createUserWithEmailAndPassword(email, userPassword).addOnCompleteListener(accountCreationListener);
    }

    public void storeUserInfo(String userName, String firstName, String lastName, String phone) {
        FirebaseUser curr_user = mAuth.getCurrentUser();
        Log.d("new user", this.mAuth.getCurrentUser().getEmail());
        String fullname = firstName.concat((" ").concat((lastName)));
        db.child("users").child(curr_user.getUid()).child("username").setValue(userName);
        db.child("users").child(curr_user.getUid()).child("fullname").setValue(fullname);
        db.child("users").child(curr_user.getUid()).child("phone").setValue(phone);
        mAuth.signOut();
    }
}