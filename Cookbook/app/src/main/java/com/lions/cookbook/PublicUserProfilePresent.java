package com.lions.cookbook;

import android.util.Log;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PublicUserProfilePresent implements PublicUserProfileContract.PublicUserProfilePresenter, PublicProfileObserver{

    private PublicUserProfileContract.PublicUserProfileView nView;
    private PublicUserProfileContract.PublicUserProfileModel nModel;
    private SessionManager UserPref;

    private ArrayList<PublicProfileActivityObserver> observers = new ArrayList<PublicProfileActivityObserver>();

    String userUsername;
    String userFullName;
    String[] arrOfNames;
    ArrayList<String> recipeNames;


    PublicUserProfilePresent(PublicUserProfileContract.PublicUserProfileView view, PublicUserProfileContract.PublicUserProfileModel model){
        this.nView = view;
        this.nModel = model;
        //add the observer to the observer array list
        this.nModel.addObserver(this);
        this.UserPref = new SessionManager();
    }

    public void addObserver(PublicProfileActivityObserver observer){
        this.observers.add(observer);
    }

    public void notifyAllObservers(){
        for (PublicProfileActivityObserver observer : this.observers) {
            observer.update(this.arrOfNames, this.recipeNames);
        }
    }

    @Override
    public void update(String Fullname, ArrayList<String> recipes){
        this.userFullName = Fullname;
        this.recipeNames = recipes;

        if(this.userFullName!= null){
            this.arrOfNames = this.userFullName.split(" ");
        }

        notifyAllObservers();

    }


    @Override
    public void handleRecipeClicked(String recipeName) {
        nView.goToViewRecipe(recipeName);
    }

}
