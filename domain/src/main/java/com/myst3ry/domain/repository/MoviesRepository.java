package com.myst3ry.domain.repository;

import com.myst3ry.domain.model.Movie;
import com.myst3ry.domain.model.Person;

import java.util.List;

import io.reactivex.Observable;

public interface MoviesRepository {

    Observable<List<Movie>> getRecentMovies();

    Observable<List<Movie>> getWatchlistMovies();

    Observable<List<Movie>> getFavoriteMovies();

    Observable<List<Movie>> getMoviesByPersonId(final int personId);

    Observable<List<Movie>> searchMoviesByQuery(final String query);

    Observable<List<Person>> getMovieCreditsById(final int movieId); //todo ?

    Observable<Movie> getMovieDetailsById(final int movieId);

    Observable<Movie> catchMovieWithParams(final Object... params);

    Observable<List<String>> getMoviePostersById(final int movieId);

    void setMovieRating(final int movieId, final double rating);

    void addMovieToWatchlist(final int movieId);

    void addMovieToFavorites(final int movieId);

    void deleteRecentMovieById(final int movieId);

    void deleteWatchlistMovieById(final int movieId);

    void deleteFavoriteMovieById(final int movieId);
}
