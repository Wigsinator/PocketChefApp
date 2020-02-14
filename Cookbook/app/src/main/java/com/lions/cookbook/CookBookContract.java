package com.lions.cookbook;

import android.widget.ListView;
import java.util.List;
import java.util.ArrayList;

public interface CookBookContract {
    interface CookBookMVPView{
        void goToCreateRecipeScreen();
        void goToViewRecipe(String recipeName, String servingSize, String ingredients, List steps);

    }

    interface CookBookMVPModel{
        List getRecipeNamesDB();
        List getRecipeSteps(String recipeName);
        String getRecipeIngredients(String recipeName);
        String getRecipeServingSize(String recipeName);
    }

    interface CookBookMVPPresenter{
        ArrayList getRecipeNames();
        void handleCreateRecipeClicked();
        void handleRecipeClicked(String recipeName);


    }
}
