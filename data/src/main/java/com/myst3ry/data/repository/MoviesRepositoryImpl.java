package com.myst3ry.data.repository;

import com.myst3ry.data.local.database.dao.MoviesDAO;
import com.myst3ry.data.mapper.MovieItemDataMapper;
import com.myst3ry.domain.model.detail.MovieDetailModel;
import com.myst3ry.domain.model.item.MovieItemModel;
import com.myst3ry.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class MoviesRepositoryImpl implements MoviesRepository {

    private final MoviesDAO mMoviesDao;

    @Inject
    public MoviesRepositoryImpl(final MoviesDAO moviesDAO) {
        this.mMoviesDao = moviesDAO;
    }

    @Override
    public Observable<List<MovieItemModel>> getMovies(final int type) {
        return mMoviesDao.getMoviesByType(type)
                .map(MovieItemDataMapper::transform)
                .toObservable();
    }

    @Override
    public Observable<List<MovieItemModel>> searchMoviesByQuery(final String query) {
        return null;
    }

    @Override
    public Observable<MovieDetailModel> getMovieDetailsById(final int movieId) {
        return null;
    }

    @Override
    public Observable<MovieItemModel> catchMovieWithParams(final Object... params) {
        return null;
    }

    @Override
    public void setMovieRating(final int movieId, final double rating) {

    }

    @Override
    public void addMovieToWatchlist(final int movieId) {

    }

    @Override
    public void addMovieToFavorites(final int movieId) {

    }

    @Override
    public void deleteMovieById(final int movieId, final int type) {

    }
}
