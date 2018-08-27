package com.myst3ry.data.local.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class ArrayListConverter {

    @TypeConverter
    public static List<String> toArrayList(final String jsonStr) {
        final Type listType = new TypeToken<ArrayList<String>>() {
        }.getType();
        return new Gson().fromJson(jsonStr, listType);
    }

    @TypeConverter
    public static String toJsonString(final List<String> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
