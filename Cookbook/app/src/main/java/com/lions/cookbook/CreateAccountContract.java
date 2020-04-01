package com.lions.cookbook;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;


/**
 * Defines contract between View {@link //CreateAccountActivity} and Presenter {@link //CreateAccountPresent}
 * */
public interface CreateAccountContract {

    interface CreateAccountMVPPresenter{

        void handleCreateAccountClicked(View view);

    }

    interface CreateAccountMVPModel {
        //add new user to the database
        void addNewUser(String username,String userPassword, String userName, String firstName, String lastname, String phone);
        void storeUserInfo(String userName, String firstName, String lastName, String phone);
        void addObserver(CreateAccountObserver observer);
        void notifyObservers();
    }


    interface CreateAccountMVPView{

        void goToLoginScreen();

        void showCreateAccountSuccess();
        void showCreateAccountFailure();
        void showUnfilledError();

        String getUsername();
        String getPassword();
        String getFirstName();
        String getLastName();
        String getEmail();
        String getPhoneNumber();

        void showInvalidEmailMessage();
        void showInvalidUsernameMessage();
        void showInvalidPhoneNumberMessage();
        void showInvalidNameMessage();
        void showInvalidPasswordMessage();
        void showUserExistsMessage(String error);
    }

}