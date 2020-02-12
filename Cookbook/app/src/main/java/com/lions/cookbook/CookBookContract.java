package com.lions.cookbook;

import android.widget.ListView;
import java.util.List;
import java.util.ArrayList;

public interface CookBookContract {
    interface CookBookMVPView{
        void goToCreateRecipeScreen();
        void goToViewRecipe(String recipeName, Integer servingSize, String ingredients, List steps);
        String getNameRecipeClicked();

    }

    interface CookBookMVPModel{
        List getRecipeNamesDB();
        List getRecipeSteps(String recipeName);
        String getRecipeIngredients(String recipeName);
        Integer getRecipeServingSize(String recipeName);
    }

    interface CookBookMVPPresenter{
        List getRecipeNames();
        void handleCreateRecipeClicked();
        void handleRecipeClicked();


    }
}
