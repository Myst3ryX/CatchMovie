package com.myst3ry.catchmovie.mapper.utils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

public final class ConvertUtils {

    private static final String RATING_FORMAT = "%.1f/10";
    private static final String TMDB_RATING_FORMAT = "%.1f";
    private static final String MOVIE_AMOUNT_FORMAT = "$ #,##0";
    private static final String MOVIE_INFO_FORMAT = "%s | %d min | %s";
    private static final String TV_SHOW_INFO_FORMAT = "%d (%d) | %d min";
    private static final String TV_SHOW_NETWORK_INFO_FORMAT = "%s | %s";

    private static final int ELEM_OFFSET = 1;
    private static final int GENRES_ITEM_MAX = 4;

    public static String convertItemGenresToString(final List<String> genresList) {
        final StringBuilder genres = new StringBuilder();
        final int size = genresList.size() > GENRES_ITEM_MAX ? GENRES_ITEM_MAX : genresList.size();
        for (int i = 0; i < size; i++) {
            genres.append(genresList.get(i));
            if (i != size - ELEM_OFFSET) {
                genres.append(", ");
            }
        }
        return genres.toString();
    }

    public static String convertMovieInfo(final String language, final int runtime, final String status) {
        return String.format(Locale.getDefault(), MOVIE_INFO_FORMAT, language, runtime, status);
    }

    public static String convertTvShowInfo(final int seasons, final int episodes, final int runtime) {
        return String.format(Locale.getDefault(), TV_SHOW_INFO_FORMAT, seasons, episodes, runtime);
    }

    public static String convertTvShowNetworkInfo(final String language, final String network) {
        return String.format(Locale.getDefault(), TV_SHOW_NETWORK_INFO_FORMAT, language, network);
    }

    public static String convertMovieAmount(final int amount) {
        return new DecimalFormat(MOVIE_AMOUNT_FORMAT).format(amount);
    }

    public static String convertRating(final double rating) {
        return String.format(Locale.getDefault(), RATING_FORMAT, rating)
                .replaceAll(",", ".");
    }

    public static String convertTmdbRating(final double rating) {
        return String.format(Locale.getDefault(), TMDB_RATING_FORMAT, rating)
                .replaceAll(",", ".");
    }

    private ConvertUtils() {
    }
}
