package com.lions.cookbook;

import android.util.Log;

import java.util.ArrayList;

public class CookBookPresent implements CookBookContract.CookBookMVPPresenter, CookBookObserver{
    private CookBookContract.CookBookMVPView nView;
    private CookBookContract.CookBookMVPModel nModel;
    private ArrayList RecipeList;
    private ArrayList<CookBookObserver> observers = new ArrayList<CookBookObserver>();

    CookBookPresent(CookBookContract.CookBookMVPView view, CookBookContract.CookBookMVPModel model){
        this.nView = view;
        this.nModel = model;
        this.nModel.addObserver(this);

    }

    @Override
    public void addObserver(CookBookObserver observer){
        this.observers.add(observer);
    }

    @Override
    public void notifyAllObservers(){
        for (CookBookObserver observer : this.observers) {
            observer.update(this.RecipeList);
        }
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

    @Override
    public void update(ArrayList<String> recipes) {
        this.RecipeList = recipes;
        notifyAllObservers();
    }
}
