package com.lions.cookbook;

import java.util.ArrayList;

public interface PrivateProfileObserver {

    void update(String email, String phone, String username, String fullname, ArrayList<String> recipes, ArrayList<String> recipeIDs);

}
