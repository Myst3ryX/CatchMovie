package com.myst3ry.domain.repository;

import com.myst3ry.domain.model.Person;
import com.myst3ry.domain.model.TvShow;

import java.util.List;

import io.reactivex.Observable;

public interface TvShowsRepository {

    Observable<List<TvShow>> getRecentTvShows();

    Observable<List<TvShow>> getWatchlistTvShows();

    Observable<List<TvShow>> getFavoriteTvShows();

    Observable<List<TvShow>> getTvShowsByPersonId(final int personId);

    Observable<List<TvShow>> searchTvShowsByQuery(final String query);

    Observable<List<Person>> getTvShowCreditsById(final int tvShowId); //todo ?

    Observable<TvShow> getTvShowDetailsById(final int tvShowId);

    Observable<TvShow> catchTvShowWithParams(final Object... params);

    Observable<List<String>> getTvShowPostersById(final int tvShowId);

    void setTvShowRating(final int tvShowId, final double rating);

    void addTvShowToWatchlist(final int tvShowId);

    void addTvShowToFavorites(final int tvShowId);

    void deleteRecentTvShowById(final int tvShowId);

    void deleteWatchlistTvShowById(final int tvShowId);

    void deleteFavoriteTvShowById(final int tvShowId);
}
