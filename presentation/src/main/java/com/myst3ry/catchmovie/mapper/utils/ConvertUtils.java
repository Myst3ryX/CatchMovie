package com.myst3ry.catchmovie.mapper.utils;

import java.util.List;
import java.util.Locale;

public final class ConvertUtils {

    private static final String RATING_FORMAT = "%.1f/10";
    private static final String TMDB_RATING_FORMAT = "%.1f";

    private static final String GENRES_SEPARATOR = ", ";
    private static final int ELEM_OFFSET = 1;
    private static final int GENRES_MAX = 3;

    public static String convertGenresToString(final List<String> genresList) {
        final StringBuilder genres = new StringBuilder();
        final int size = genresList.size() > GENRES_MAX ? GENRES_MAX : genresList.size();
        for (int i = 0; i < size; i++) {
            genres.append(genresList.get(i));
            if (i != genresList.size() - ELEM_OFFSET) {
                genres.append(GENRES_SEPARATOR);
            }
        }
        return genres.toString();
    }

    public static String convertRating(final double rating) {
        return String.format(Locale.getDefault(), RATING_FORMAT, rating);
    }

    public static String convertTmdbRating(final double rating) {
        return String.format(Locale.getDefault(), TMDB_RATING_FORMAT, rating);
    }

    private ConvertUtils() {
    }
}
