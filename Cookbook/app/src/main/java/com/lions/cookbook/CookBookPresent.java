package com.lions.cookbook;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CookBookPresent implements CookBookContract.CookBookMVPPresenter{
    private CookBookContract.CookBookMVPView nView;
    private CookBookContract.CookBookMVPModel nModel;
    private ArrayList RecipeList;

    CookBookPresent(CookBookContract.CookBookMVPView view, CookBookContract.CookBookMVPModel model){
        nView = view;
        nModel = model;
    }

    @Override
    public ArrayList getRecipeNames() {
        return nModel.getRecipeNamesDB();
    }

    @Override
    public void handleCreateRecipeClicked() {
        nView.goToCreateRecipeScreen();
    }

    @Override
    public void handleRecipeClicked(String recipeName) {
        Log.d("TEST", "Finish getting recipe");
        nView.goToViewRecipe(recipeName);
        Log.d("TEST", "able to go to view recipe");
    }
}
