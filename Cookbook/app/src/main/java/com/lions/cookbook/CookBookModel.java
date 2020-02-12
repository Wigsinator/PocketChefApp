package com.lions.cookbook;

import java.util.List;

public class CookBookModel implements CookBookContract.CookBookMVPModel {
    @Override
    public List getRecipeNamesDB() {
        return null;
    }

    @Override
    public List getRecipeSteps(String recipeName) {
        return null;
    }

    @Override
    public String getRecipeIngredients(String recipeName) {
        return null;
    }

    @Override
    public Integer getRecipeServingSize(String recipeName) {
        return null;
    }
}
