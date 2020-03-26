package com.lions.cookbook;
import android.view.View;

import java.util.ArrayList;


public class PublicUserProfileContract {

    interface PublicUserProfilePresenter{
        ArrayList getRecipeNames();
        void handleRecipeClicked(String recipeName);
        void update(String fullname, ArrayList<String> recipes);

    }

    interface PublicUserProfileModel {
        void findFullname();
        void findRecipes();
        void notifyAllObservers();
        void addObserver(PublicProfileObserver observer);

    }

    interface PublicUserProfileView{
        void goToViewRecipe(String clickedRecipe);
    }
}
