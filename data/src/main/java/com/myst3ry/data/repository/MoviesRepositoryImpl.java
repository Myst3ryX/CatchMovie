package com.myst3ry.data.repository;

import com.myst3ry.data.repository.datasource.LocalDataSource;
import com.myst3ry.data.repository.datasource.RemoteDataSource;
import com.myst3ry.domain.model.Movie;
import com.myst3ry.domain.model.Person;
import com.myst3ry.domain.repository.MoviesRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class MoviesRepositoryImpl implements MoviesRepository {

    private final LocalDataSource mLocalDataSource;
    private final RemoteDataSource mRemoteDataSource;

    @Inject
    public MoviesRepositoryImpl(final LocalDataSource localDataSource,
                                final RemoteDataSource remoteDataSource) {
        this.mLocalDataSource = localDataSource;
        this.mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<Movie>> getRecentMovies() {
        return Observable.just(new ArrayList<>());
    }

    @Override
    public Observable<List<Movie>> getWatchlistMovies() {
        return Observable.just(new ArrayList<>());
    }

    @Override
    public Observable<List<Movie>> getFavoriteMovies() {
        return Observable.just(new ArrayList<>());
    }

    @Override
    public Observable<List<Movie>> getMoviesByPersonId(int personId) {
        return null;
    }

    @Override
    public Observable<List<Movie>> searchMoviesByQuery(String query) {
        return null;
    }

    @Override
    public Observable<List<Person>> getMovieCreditsById(int movieId) {
        return null;
    }

    @Override
    public Observable<Movie> getMovieDetailsById(int movieId) {
        return null;
    }

    @Override
    public Observable<Movie> catchMovieWithParams(Object... params) {
        return null;
    }

    @Override
    public Observable<List<String>> getMoviePostersById(int movieId) {
        return null;
    }

    @Override
    public void setMovieRating(int movieId, double rating) {

    }

    @Override
    public void addMovieToWatchlist(int movieId) {

    }

    @Override
    public void addMovieToFavorites(int movieId) {

    }

    @Override
    public void deleteRecentMovieById(int movieId) {

    }

    @Override
    public void deleteWatchlistMovieById(int movieId) {

    }

    @Override
    public void deleteFavoriteMovieById(int movieId) {

    }
}
