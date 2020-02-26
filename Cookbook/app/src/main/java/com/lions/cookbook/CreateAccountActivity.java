package com.lions.cookbook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.lions.cookbook.databinding.CreateRecipeActivityBinding;

public class CreateAccountActivity extends AppCompatActivity implements CreateAccountContract.CreateAccountMVPView {

	private CreateAccountContract.CreateAccountMVPPresenter presenter;
    private CreateAccountContract.CreateAccountMVPModel model;


   // private Button createButton;

    private TextView textViewHeader;

    private EditText username;
    private EditText userPassword;
    private EditText userEmail;
    private EditText userFirstName;
    private EditText userLastName;
    private EditText userPhoneNumber;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_activity);

        model = new CreateAccountModel();
        presenter = new CreateAccountPresent(this, model);

      //  createButton = (Button) findViewById(R.id.clickButton);

    }


    @Override
    public void goToLoginScreen(){
    	//Intent intent = new Intent(this, UserLoginActivity.class);
        //startActivity(intent);
        Toast.makeText(this, "Taking user to Log in Screen", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCreateAccountSuccess(){
    	Toast.makeText(this, "Registration is successful!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCreateAccountFailure(){
    	Toast.makeText(this, "There was an error creating your account!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUnfilledError(){
    	Toast.makeText(this, "All fields must be filled in!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUsername(){
    	this.username = findViewById(R.id.username);
    	String value = username.getText().toString();
    	return value;
    }

    @Override
    public String getPassword(){
    this.userPassword = findViewById(R.id.password);
    	String value = userPassword.getText().toString();
    	return value;
    }

    @Override
    public String getFirstName(){
    	this.userFirstName = findViewById(R.id.first_name);
    	String value = userFirstName.getText().toString();
    	return value;
    }

    @Override
    public String getLastName(){
    	this.userLastName = findViewById(R.id.last_name);
    	String value = userLastName.getText().toString();
    	return value;
    }

    @Override
    public String getEmail(){
    	this.userEmail = findViewById(R.id.gmail);
    	String value = userEmail.getText().toString();
    	return value;
    }  

    @Override
    public String getPhoneNumber(){
    	this.userPhoneNumber = findViewById(R.id.phone_number);
    	String value = userPhoneNumber.getText().toString();
    	return value;
    } 


}
