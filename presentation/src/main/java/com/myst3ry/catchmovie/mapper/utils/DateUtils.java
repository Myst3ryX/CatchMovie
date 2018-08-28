package com.myst3ry.catchmovie.mapper.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class DateUtils {

    private static final SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private static final SimpleDateFormat outputYearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());
    private static final SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());

    public static String parseDateToYear(final String date) {
        try {
            return outputYearFormat.format(inputDateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    public static String parseDate(final String date) {
        try {
            return outputDateFormat.format(inputDateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    private DateUtils() {
    }
}
