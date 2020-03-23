package com.lions.cookbook;
import android.view.View;

import java.util.ArrayList;


public class PublicUserProfileContract {

    interface PublicUserProfilePresenter{
        ArrayList getRecipeNames();
        void handleRecipeClicked(String recipeName);

    }

    interface PublicUserProfileModel {

        String getFullname();
        String getUsername();
        ArrayList<String> getRecipes();
    }


    interface PublicUserProfileView{
        void goToViewRecipe(String clickedRecipe);
    }
}
