package com.lions.cookbook;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import 	androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
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
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),RecipeDatabase.class, "recipe_database").addCallback(sRoomDatabaseCallback).build();
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                RecipeDao dao = INSTANCE.recipeDao();
                dao.deleteAll();

                Ingredient ingredient = new Ingredient("noodles", 350, "g");
                List<Ingredient> ingredients = new ArrayList<Ingredient>();
                ingredients.add(ingredient);

                List<String> steps = new ArrayList<String>();
                steps.add("Put the pasta in the pot");

                List<String> tags = new ArrayList<>();
                tags.add("yummy");

                Recipe first = new Recipe("Spaghetti", "Bob", 4, ingredients, tags, steps);
                dao.insert(first);

            });
        }
    };

}