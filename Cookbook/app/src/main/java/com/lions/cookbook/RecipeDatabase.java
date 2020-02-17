/*
package com.lions.cookbook;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import 	androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Recipe.class}, version = 1)
@TypeConverters({RecipeListConverter.class})
public abstract class RecipeDatabase extends RoomDatabase{
    public abstract RecipeDao recipeDao();
    private static volatile RecipeDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static RecipeDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),RecipeDatabase.class, "recipe_database").build();
        }
        return INSTANCE;
    }


}
*/