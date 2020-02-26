
package com.lions.cookbook;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RecipeDao {

    @Query("DELETE FROM recipe_database")
    void deleteAll();

    @Insert
    void insert(Recipe recipe);

    @Update
    void update(Recipe recipe);

    @Query("SELECT * from recipe_database ORDER BY title ASC")
    LiveData<List<Recipe>> getAlphabetizedRecipes();

    @Query("SELECT title from recipe_database ORDER BY title ASC")
    LiveData<List<String>> getAlphabetizedRecipeTitles();

    @Query("SELECT * from recipe_database WHERE title = :searchTitle")
    LiveData<List<Recipe>> getRecipeByTitle(String searchTitle);

}
