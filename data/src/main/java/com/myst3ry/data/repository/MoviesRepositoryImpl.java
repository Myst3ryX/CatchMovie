package com.myst3ry.data.repository;

import com.myst3ry.data.local.database.dao.MoviesDAO;
import com.myst3ry.data.mapper.MovieItemDataMapper;
import com.myst3ry.data.remote.api.ApiMapper;
import com.myst3ry.domain.model.detail.MovieDetailModel;
import com.myst3ry.domain.model.item.MovieItemModel;
import com.myst3ry.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class MoviesRepositoryImpl implements MoviesRepository {

    private final MoviesDAO mMoviesDao;
    private final ApiMapper mApiMapper;

    @Inject
    public MoviesRepositoryImpl(final MoviesDAO moviesDAO, final ApiMapper apiMapper) {
        this.mMoviesDao = moviesDAO;
        this.mApiMapper = apiMapper;
    }

    @Override
    public Observable<List<MovieItemModel>> getMovies(final int type) {
        return mMoviesDao.getMoviesByType(type)
                .map(MovieItemDataMapper::transform)
                .toObservable();
    }

    @Override
    public Observable<List<MovieItemModel>> searchMoviesByQuery(final String query) {
        return null; //todo api
    }

    @Override
    public Observable<MovieDetailModel> getMovieDetailsById(final int movieId) {
        return null; //todo db+api
    }

    @Override
    public Observable<MovieItemModel> catchMovieWithParams(final Object... params) {
        return null; //todo api + save recent
    }

    @Override
    public void setMovieRating(final int movieId, final double rating) {
        //mMoviesDao.getMovieById(movieId).map(setRating(rating)).
    }

    @Override
    public void addMovieToWatchlist(final int movieId) {
        //todo db
    }

    @Override
    public void addMovieToFavorites(final int movieId) {
        //todo db
    }

    @Override
    public void deleteMovieById(final int movieId, final int type) {
        //todo db
    }
}
