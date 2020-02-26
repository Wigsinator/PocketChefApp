package com.lions.cookbook;

public interface LoginContract {

    interface LoginPresenter{

       // void onTakeView(MainFragment mainFragment);

        void checkUserLoginCredentials(String userName, String userPass);

        void goToCreateAccountScreen();

    }

    interface LoginModel {
        String getUsername();
        String getPassword();
        int checkUserValidity(String name, String password);
}


    interface LoginView{
        void goToCreateAccountScreen();
       // void onLoginResult(Boolean result, int code);

     //   void showLogin();

     //   void hideLogin();

     //   void showLoginSuccess();

     //   void showLoginFailure();

     //   void showSignupSuccess();

      //  void showSignupFailure();


    }


}