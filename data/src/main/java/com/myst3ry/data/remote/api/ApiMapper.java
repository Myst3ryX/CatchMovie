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

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static com.myst3ry.data.remote.api.RequestsConstants.IS_ADULT_ENABLED;
import static com.myst3ry.data.remote.api.RequestsConstants.LANGUAGE;
import static com.myst3ry.data.remote.api.RequestsConstants.MOVIE_REQUEST_APPEND;
import static com.myst3ry.data.remote.api.RequestsConstants.PERSON_REQUEST_APPEND;
import static com.myst3ry.data.remote.api.RequestsConstants.TV_SHOW_REQUEST_APPEND;

public final class ApiMapper {

    private static final String TAG = "ApiMapper";
    private static final String API_KEY = "61bcb0739836557c189f126d3af100af";
    private static final int API_VERSION = 3;

    private final TMDbApi mApiService;

    public ApiMapper(final TMDbApi apiService) {
        this.mApiService = apiService;
    }

    public Observable<MovieDetail> getMovieDetails(final int movieId) {
        return mApiService.getMovieDetails(API_VERSION, movieId, API_KEY, LANGUAGE, MOVIE_REQUEST_APPEND)
                .toObservable();
    }

    public Observable<TvShowDetail> getTvShowDetails(final int tvShowId) {
        return mApiService.getTvShowDetails(API_VERSION, tvShowId, API_KEY, LANGUAGE, TV_SHOW_REQUEST_APPEND)
                .toObservable();
    }

    public Observable<PersonDetail> getPersonDetails(final int personId) {
        return mApiService.getPersonDetails(API_VERSION, personId, API_KEY, LANGUAGE, PERSON_REQUEST_APPEND)
                .toObservable();
    }

    public Observable<List<MovieResult>> searchMoviesByQuery(final String query, final int page) {
        return mApiService.searchMovies(API_VERSION, API_KEY, LANGUAGE, query, page, IS_ADULT_ENABLED)
                .observeOn(Schedulers.computation())
                .map(MovieFindResponse::getResults)
                .toObservable();
    }

    public Observable<List<TvShowResult>> searchTvShowsByQuery(final String query, final int page) {
        return mApiService.searchTvShows(API_VERSION, API_KEY, LANGUAGE, query, page, IS_ADULT_ENABLED)
                .observeOn(Schedulers.computation())
                .map(TvShowFindResponse::getResults)
                .toObservable();
    }

    public Observable<List<PersonResult>> searchPersonsByQuery(final String query, final int page) {
        return mApiService.searchPersons(API_VERSION, API_KEY, LANGUAGE, query, page, IS_ADULT_ENABLED)
                .observeOn(Schedulers.computation())
                .map(PersonFindResponse::getResults)
                .toObservable();

    }

    public Observable<List<MovieResult>> getPopularMovies(final int page) {
        return mApiService.getPopularMovies(API_VERSION, API_KEY, LANGUAGE, page)
                .observeOn(Schedulers.computation())
                .map(MovieFindResponse::getResults)
                .toObservable();
    }

    public Observable<List<TvShowResult>> getPopularTvShows(final int page) {
        return mApiService.getPopularTvShows(API_VERSION, API_KEY, LANGUAGE, page)
                .observeOn(Schedulers.computation())
                .map(TvShowFindResponse::getResults)
                .toObservable();
    }

    public Observable<List<PersonResult>> getPopularPersons(final int page) {
        return mApiService.getPopularPersons(API_VERSION, API_KEY, LANGUAGE, page)
                .observeOn(Schedulers.computation())
                .map(PersonFindResponse::getResults)
                .toObservable();
    }
}
