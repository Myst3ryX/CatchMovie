package com.myst3ry.domain.repository;

import com.myst3ry.domain.model.detail.MovieDetailModel;
import com.myst3ry.domain.model.item.MovieItemModel;
import com.myst3ry.domain.model.result.MovieResultModel;

import java.util.List;

import io.reactivex.Observable;

public interface MoviesRepository {

    Observable<List<MovieItemModel>> getMovies(final int type);

    Observable<MovieDetailModel> getMovieDetailsById(final int movieId);

    Observable<List<MovieResultModel>> getPopularMovies();

    Observable<List<MovieResultModel>> searchMoviesByQuery(final String query);

    void setMovieRating(final int movieId, final double rating);

    void addMovieToWatchlist(final int movieId);

    void addMovieToFavorites(final int movieId);

    void deleteMovieById(final int movieId, final int type);
}
