package com.lions.cookbook;
import android.view.View;

import java.util.ArrayList;


public interface PublicUserProfileContract {

    interface PublicUserProfilePresenter{
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
