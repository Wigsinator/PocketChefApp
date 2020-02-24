
package com.lions.cookbook;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RecipeDao {

    @Insert
    void insert(Recipe recipe);

    @Query("SELECT * from recipe_database ORDER BY recipe ASC")
    LiveData<List<Recipe>> getAlphabetizedRecipes();

    @Update
    void update(Recipe recipe);
}
