package com.lions.cookbook;
import android.view.View;

import java.util.ArrayList;


public interface PublicUserProfileContract {

    interface PublicUserProfilePresenter{
        ArrayList getRecipeNames();
        void handleRecipeClicked(String recipeName);
        void update(String fullname, ArrayList<String> recipes);

    }

    interface PublicUserProfileModel {
        String getFullname(String username);
        ArrayList<String> getRecipes(String username);
        void findFullname(String username);
        void findRecipes(String username);
        void notifyAllObservers();
        void addObserver(PublicProfileObserver observer);

    }

    interface PublicUserProfileView{
        void goToViewRecipe(String clickedRecipe);
    }
}
