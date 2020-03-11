package com.lions.cookbook;
import android.view.View;


/**
 * Defines contract between View {@link //CreateAccountActivity} and Presenter {@link //CreateAccountPresent}
 * */
public interface CreateAccountContract {

    interface CreateAccountMVPPresenter{

        void handleCreateAccountClicked(View view);

    }

    interface CreateAccountMVPModel {
        //add new user to the database
        boolean addNewUser(String username,String userPassword);
        void storeUserInfo(String userName, String firstName, String lastName, String phone);
        void setUsername(String username);
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
    }


}