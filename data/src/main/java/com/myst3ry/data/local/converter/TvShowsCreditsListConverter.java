package com.myst3ry.data.local.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myst3ry.data.local.entity.credits.TvShowCredit;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class TvShowsCreditsListConverter {

//    private static final String STR_DIV = "/";
//
//    private static final int ID_INDEX = 0;
//    private static final int TITLE_INDEX = 1;
//    private static final int POSTER_INDEX = 2;
//    private static final int CREDIT_LENGTH = 3;

    @TypeConverter
    public static List<TvShowCredit> toCastCreditList(final String jsonStr) {
        final Type listType = new TypeToken<ArrayList<TvShowCredit>>() {
        }.getType();
        return new Gson().fromJson(jsonStr, listType);
    }

    @TypeConverter
    public static String toJsonString(final List<TvShowCredit> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

//    @TypeConverter
//    public static TvShowCredit toTvShowCredit(final String creditStr) {
//        final String[] credit = creditStr.split(STR_DIV);
//        if (credit.length != CREDIT_LENGTH) {
//            return null;
//        } else {
//            return new TvShowCredit(Integer.parseInt(credit[ID_INDEX]), credit[TITLE_INDEX], credit[POSTER_INDEX]);
//        }
//    }
//
//    @TypeConverter
//    public static String toString(final TvShowCredit credits) {
//        return credits.getId() + STR_DIV + credits.getTitle() + STR_DIV + credits.getPoster();
//    }
}
