package com.lions.cookbook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {
    private EditText userEmail, userPassword;

    private Button   btnLogin;
    private Button   btnSignup;

    private LoginPresent presenter;
    private LoginModel model;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);//set layout name with actual name

        //find view
        userEmail = (EditText) this.findViewById(R.id.user_id);
        userPassword = (EditText) this.findViewById(R.id.user_password);

        btnLogin = (Button) this.findViewById(R.id.login_btn);
        btnSignup = (Button) this.findViewById(R.id.signUpLink);

        //set event handler to sign up button
        btnSignup.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                goToCreateAccountScreen();
            }
        });

        //init
        // loginPresent = new LoginPresenterCompl(this);
    }

    @Override
    public void goToCreateAccountScreen() {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Taking user to Registration Screen", Toast.LENGTH_SHORT).show();

    }

    /**
     @Override
     public void onClick(View v) {
     if (v.getId() == R.id.btn_login_login){
     LoginPresent.setProgressBarVisiblity(View.VISIBLE);
     btnLogin.setEnabled(false);
     LoginPresent.doLogin(editUser.getText().toString(), editPass.getText().toString());
     }
     }

     */

    /**
     @Override
     public void onLoginResult(Boolean result, int code) {
     loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
     btnLogin.setEnabled(true);
     if (result){
     Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
     }
     else
     Toast.makeText(this,"Login Failed, code = " + code,Toast.LENGTH_SHORT).show();
     }



     @Override
     protected void onDestroy() {
     super.onDestroy();
     }


     @Override
     protected void onResume() {
     super.onResume();
     presenter.setView(this);
     presenter.getCurrentUser();
     }

     @Override
     public String getUsername() {
     return username.getText().toString();
     }

     @Override
     public void showInputError() {
     Toast.makeText(this, "username or password cannot be empty", Toast.LENGTH_SHORT).show();
     }

     @Override
     public void setUsername(String user) {
     this.username.setText(user);
     }

     */

    public void showUserSavedMessage() {
        Toast.makeText(this, "User saved successfully", Toast.LENGTH_SHORT).show();
    }


}
