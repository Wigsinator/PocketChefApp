package com.lions.cookbook;
import android.view.View;


/**
 * Defines contract between View {@link //CreateAccountActivity} and Presenter {@link //CreateAccountPresent}
 * */
public interface CreateAccountContract {

    interface CreateAccountPresenter{

        void handleCreateAccountClicked(View view);

        void handleGoToLoginScreen(View view);

    }

    interface CreateAccountModel {
        //add new user to the database
        Boolean addNewUser(String username,String userPassword);
        }


    interface CreateAccountView{

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
    }


}