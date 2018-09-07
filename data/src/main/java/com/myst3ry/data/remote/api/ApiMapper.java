package com.myst3ry.data.remote.api;

import com.myst3ry.data.remote.pojo.movie.detail.MovieDetail;
import com.myst3ry.data.remote.pojo.movie.find.MovieFindResponse;
import com.myst3ry.data.remote.pojo.movie.find.MovieResult;
import com.myst3ry.data.remote.pojo.person.detail.PersonDetail;
import com.myst3ry.data.remote.pojo.person.find.PersonFindResponse;
import com.myst3ry.data.remote.pojo.person.find.PersonResult;
import com.myst3ry.data.remote.pojo.tvshow.detail.TvShowDetail;
import com.myst3ry.data.remote.pojo.tvshow.find.TvShowFindResponse;
import com.myst3ry.data.remote.pojo.tvshow.find.TvShowResult;

import java.util.List;
import java.util.Locale;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * A Class which works with Api Service {@link TMDbApi}
 */
public final class ApiMapper {

    private final TMDbApi mApiService;

    public ApiMapper(final TMDbApi apiService) {
        this.mApiService = apiService;
    }

    /**
     * Request movie details by movie id
     *
     * @param movieId - a movie id
     * @return {@link Observable} of movie details pojo-class
     */
    public Observable<MovieDetail> getMovieDetails(final int movieId) {
        return mApiService.getMovieDetails(ApiConstants.API_VERSION, movieId, ApiConstants.API_KEY,
                ApiConstants.LANGUAGE, ApiConstants.MOVIE_REQUEST_APPEND)
                .toObservable();
    }

    /**
     * Request tv show details by tv show id
     *
     * @param tvShowId - a tv show id
     * @return {@link Observable} of tv show details pojo-class
     */
    public Observable<TvShowDetail> getTvShowDetails(final int tvShowId) {
        return mApiService.getTvShowDetails(ApiConstants.API_VERSION, tvShowId, ApiConstants.API_KEY,
                ApiConstants.LANGUAGE, ApiConstants.TV_SHOW_REQUEST_APPEND)
                .toObservable();
    }

    /**
     * Request person details by person id
     * @param personId - a person id
     * @return {@link Observable} of person details pojo-class
     */
    public Observable<PersonDetail> getPersonDetails(final int personId) {
        return mApiService.getPersonDetails(ApiConstants.API_VERSION, personId, ApiConstants.API_KEY,
                ApiConstants.LANGUAGE, ApiConstants.PERSON_REQUEST_APPEND)
                .toObservable();
    }

    /**
     * Perform movies search by query
     *
     * @param query - a string query
     * @param page - a page number
     * @return {@link Observable} of movie pojo-class list with request results
     */
    public Observable<List<MovieResult>> searchMoviesByQuery(final String query, final int page) {
        return mApiService.searchMovies(ApiConstants.API_VERSION, ApiConstants.API_KEY,
                ApiConstants.LANGUAGE, query, page, ApiConstants.IS_ADULT_ENABLED)
                .observeOn(Schedulers.computation())
                .map(MovieFindResponse::getResults)
                .toObservable();
    }

    /**
     * Perform tv shows search by query
     *
     * @param query - a string query
     * @param page - a page number
     * @return {@link Observable} of tv show pojo-class list with request results
     */
    public Observable<List<TvShowResult>> searchTvShowsByQuery(final String query, final int page) {
        return mApiService.searchTvShows(ApiConstants.API_VERSION, ApiConstants.API_KEY,
                ApiConstants.LANGUAGE, query, page, ApiConstants.IS_ADULT_ENABLED)
                .observeOn(Schedulers.computation())
                .map(TvShowFindResponse::getResults)
                .toObservable();
    }

    /**
     * Perform persons search by query
     *
     * @param query - a string query
     * @param page - a page number
     * @return {@link Observable} of persons pojo-class list with request results
     */
    public Observable<List<PersonResult>> searchPersonsByQuery(final String query, final int page) {
        return mApiService.searchPersons(ApiConstants.API_VERSION, ApiConstants.API_KEY,
                ApiConstants.LANGUAGE, query, page, ApiConstants.IS_ADULT_ENABLED)
                .observeOn(Schedulers.computation())
                .map(PersonFindResponse::getResults)
                .toObservable();

    }

    /**
     * Request popular movies
     * @param page - a page number
     * @return {@link Observable} of popular movie results list
     */
    public Observable<List<MovieResult>> getPopularMovies(final int page) {
        return mApiService.getPopularMovies(ApiConstants.API_VERSION, ApiConstants.API_KEY, ApiConstants.LANGUAGE, page)
                .observeOn(Schedulers.computation())
                .map(MovieFindResponse::getResults)
                .toObservable();
    }

    /**
     * Request popular tv shows
     * @param page - a page number
     * @return {@link Observable} of popular tv show results list
     */
    public Observable<List<TvShowResult>> getPopularTvShows(final int page) {
        return mApiService.getPopularTvShows(ApiConstants.API_VERSION, ApiConstants.API_KEY, ApiConstants.LANGUAGE, page)
                .observeOn(Schedulers.computation())
                .map(TvShowFindResponse::getResults)
                .toObservable();
    }

    /**
     * Request popular persons
     * @param page - a page number
     * @return {@link Observable} of popular person results list
     */
    public Observable<List<PersonResult>> getPopularPersons(final int page) {
        return mApiService.getPopularPersons(ApiConstants.API_VERSION, ApiConstants.API_KEY, ApiConstants.LANGUAGE, page)
                .observeOn(Schedulers.computation())
                .map(PersonFindResponse::getResults)
                .toObservable();
    }

    /**
     * Class with Api request constants
     */
    private static class ApiConstants {

        private static final String API_KEY = "61bcb0739836557c189f126d3af100af";
        private static final int API_VERSION = 3;
        private static final boolean IS_ADULT_ENABLED = false;
        private static final String LANGUAGE = Locale.getDefault().getLanguage();
        private static final String MOVIE_REQUEST_APPEND = "images,credits";
        private static final String TV_SHOW_REQUEST_APPEND = "images,credits";
        private static final String PERSON_REQUEST_APPEND = "movie_credits,tv_credits";
    }
}
