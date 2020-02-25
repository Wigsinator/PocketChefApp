
package com.lions.cookbook;
import androidx.room.TypeConverter;
import java.util.*;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import com.google.gson.Gson;

public class RecipeListConverter {
    private static Gson gson;

    public RecipeListConverter(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    @TypeConverter
    public static List<String> stringToStringList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<String>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String stringListToString(List<String> strings) {
        return gson.toJson(strings);
    }

    @TypeConverter
    public static List<Ingredient> stringToIngredientList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<String>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String IngredientListToString(List<Ingredient> ingredients) {
        return gson.toJson(ingredients);
    }
}

