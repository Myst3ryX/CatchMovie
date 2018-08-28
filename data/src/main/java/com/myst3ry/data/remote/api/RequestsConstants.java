package com.myst3ry.data.remote.api;

import java.util.Locale;

abstract class RequestsConstants {

    static final boolean IS_ADULT_ENABLED = false;
    static final String LANGUAGE = Locale.getDefault().getLanguage();
    static final String SORT_BY = "popularity.desc";
    static final String MOVIE_REQUEST_APPEND = "images,credits";
    static final String TV_SHOW_REQUEST_APPEND = "images,credits";
    static final String PERSON_REQUEST_APPEND = "movie_credits,tv_credits";
}
