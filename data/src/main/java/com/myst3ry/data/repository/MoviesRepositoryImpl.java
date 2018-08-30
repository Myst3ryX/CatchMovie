package com.myst3ry.data.repository;

import com.myst3ry.data.local.database.dao.MoviesDAO;
import com.myst3ry.data.mapper.MovieItemDataMapper;
import com.myst3ry.data.mapper.MovieResultDataMapper;
import com.myst3ry.data.remote.api.ApiMapper;
import com.myst3ry.domain.model.detail.MovieDetailModel;
import com.myst3ry.domain.model.item.MovieItemModel;
import com.myst3ry.domain.model.result.MovieResultModel;
import com.myst3ry.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

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
    public Observable<MovieDetailModel> getMovieDetailsById(final int movieId) {
        return null; //todo db+api
    }

    @Override
    public Observable<List<MovieResultModel>> getPopularMovies() {
        return mApiMapper.getPopularMovies(1)
                .map(MovieResultDataMapper::transform);
    }

    @Override
    public Observable<List<MovieResultModel>> searchMoviesByQuery(final String query) {
        return mApiMapper.searchMoviesByQuery(query, 1)
                .map(MovieResultDataMapper::transform);
    }

    @Override
    public void setMovieRating(final int movieId, final double rating) {
        mMoviesDao.getMovieById(movieId)
                .toObservable()
                .observeOn(Schedulers.computation())
                .doOnNext(movie -> movie.setRating(rating))
                .subscribe();
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
