package com.myst3ry.catchmovie.mapper.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class DateUtils {

    private static final SimpleDateFormat mInputDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private static final SimpleDateFormat mOutputYearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());
    private static final SimpleDateFormat mOutputReleaseDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
    private static final SimpleDateFormat mOutputPersonDateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());

    public static String parseDateToYear(final String date) {
        if (date != null) {
            try {
                return mOutputYearFormat.format(mInputDateFormat.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
                return date;
            }
        }
        return null;
    }

    public static String parseReleaseDate(final String date) {
        if (date != null) {
            try {
                return mOutputReleaseDateFormat.format(mInputDateFormat.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
                return date;
            }
        }
        return null;
    }

    public static String parsePersonDate(final String date) {
        if (date != null) {
            try {
                return mOutputPersonDateFormat.format(mInputDateFormat.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
                return date;
            }
        }
        return null;
    }

    private DateUtils() {
    }
}
