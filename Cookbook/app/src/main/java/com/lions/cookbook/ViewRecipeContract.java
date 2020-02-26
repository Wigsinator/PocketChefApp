package com.lions.cookbook;

public interface ViewRecipeContract {
    interface ViewRecipeMVPView{}
    interface ViewRecipeMVPPresenter{
        Recipe fetchRecipe(String recipeName);
    }
    interface ViewRecipeMVPModel{
        Recipe getRecipe(String recipeName);
    }
}
