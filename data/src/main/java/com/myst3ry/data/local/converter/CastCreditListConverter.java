package com.myst3ry.data.local.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myst3ry.data.local.entity.credits.PersonCredit;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class CastCreditListConverter {

//    private static final String STR_DIV = "/";
//
//    private static final int ID_INDEX = 0;
//    private static final int TITLE_INDEX = 1;
//    private static final int CHARACTER_INDEX = 2;
//    private static final int POSTER_INDEX = 3;
//    private static final int CREDIT_LENGTH = 4;

    @TypeConverter
    public static List<PersonCredit> toCastCreditList(final String jsonStr) {
        final Type listType = new TypeToken<ArrayList<PersonCredit>>() {
        }.getType();
        return new Gson().fromJson(jsonStr, listType);
    }

    @TypeConverter
    public static String toJsonString(final List<PersonCredit> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

//    @TypeConverter
//    public static PersonCredit toPersonCredit(final String creditStr) {
//        final String[] credit = creditStr.split(STR_DIV);
//        if (credit.length != CREDIT_LENGTH) {
//            return null;
//        } else {
//            return new PersonCredit(Integer.parseInt(credit[ID_INDEX]), credit[TITLE_INDEX],
//                    credit[CHARACTER_INDEX], credit[POSTER_INDEX]);
//        }
//    }
//
//    @TypeConverter
//    public static String toString(final PersonCredit person) {
//        return person.getId() + STR_DIV + person.getTitle() + STR_DIV + person.getPhoto();
//    }
}
