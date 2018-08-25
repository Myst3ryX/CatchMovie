package com.myst3ry.data.repository;

import com.myst3ry.data.repository.datasource.LocalDataSource;
import com.myst3ry.data.repository.datasource.RemoteDataSource;
import com.myst3ry.domain.model.Person;
import com.myst3ry.domain.model.TvShow;
import com.myst3ry.domain.repository.TvShowsRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class TvShowsRepositoryImpl implements TvShowsRepository {

    private final LocalDataSource mLocalDataSource;
    private final RemoteDataSource mRemoteDataSource;

    @Inject
    public TvShowsRepositoryImpl(final LocalDataSource localDataSource,
                                 final RemoteDataSource remoteDataSource) {
        this.mLocalDataSource = localDataSource;
        this.mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<TvShow>> getRecentTvShows() {
        return Observable.just(new ArrayList<>());
    }

    @Override
    public Observable<List<TvShow>> getWatchlistTvShows() {
        return Observable.just(new ArrayList<>());
    }

    @Override
    public Observable<List<TvShow>> getFavoriteTvShows() {
        return Observable.just(new ArrayList<>());
    }

    @Override
    public Observable<List<TvShow>> getTvShowsByPersonId(int personId) {
        return null;
    }

    @Override
    public Observable<List<TvShow>> searchTvShowsByQuery(String query) {
        return null;
    }

    @Override
    public Observable<List<Person>> getTvShowCreditsById(int tvShowId) {
        return null;
    }

    @Override
    public Observable<TvShow> getTvShowDetailsById(int tvShowId) {
        return null;
    }

    @Override
    public Observable<TvShow> catchTvShowWithParams(Object... params) {
        return null;
    }

    @Override
    public Observable<List<String>> getTvShowPostersById(int tvShowId) {
        return null;
    }

    @Override
    public void setTvShowRating(int tvShowId, double rating) {

    }

    @Override
    public void addTvShowToWatchlist(int tvShowId) {

    }

    @Override
    public void addTvShowToFavorites(int tvShowId) {

    }

    @Override
    public void deleteRecentTvShowById(int tvShowId) {

    }

    @Override
    public void deleteWatchlistTvShowById(int tvShowId) {

    }

    @Override
    public void deleteFavoriteTvShowById(int tvShowId) {

    }
}
