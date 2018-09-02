package com.myst3ry.domain.repository;

import com.myst3ry.domain.model.detail.MovieDetailModel;
import com.myst3ry.domain.model.item.MovieItemModel;
import com.myst3ry.domain.model.result.MovieResultModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public interface MoviesRepository {

    Observable<List<MovieItemModel>> getRecentMovies();

    Observable<List<MovieItemModel>> getWatchlistMovies();

    Observable<List<MovieItemModel>> getFavoriteMovies();

    Observable<MovieDetailModel> getMovieDetailsById(final int movieId);

    Observable<List<MovieResultModel>> getPopularMovies();

    Observable<List<MovieResultModel>> searchMoviesByQuery(final String query);

    Disposable setMovieRating(final int movieId, final double rating);

    Disposable addMovieToWatchlist(final int movieId);

    Disposable addMovieToFavorites(final int movieId);

    Disposable deleteMovieFromRecent(final int movieId);

    Disposable deleteMovieFromWatchlist(final int movieId);

    Disposable deleteMovieFromFavorites(final int movieId);
}
