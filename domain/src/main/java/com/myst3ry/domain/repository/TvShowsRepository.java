package com.myst3ry.domain.repository;

import com.myst3ry.domain.model.detail.TvShowDetailModel;
import com.myst3ry.domain.model.item.TvShowItemModel;

import java.util.List;

import io.reactivex.Observable;

public interface TvShowsRepository {

    Observable<List<TvShowItemModel>> getTvShows(final int type);

    Observable<List<TvShowItemModel>> searchTvShowsByQuery(final String query);

    Observable<TvShowDetailModel> getTvShowDetailsById(final int tvShowId);

    Observable<TvShowItemModel> catchTvShowWithParams(final Object... params);

    void setTvShowRating(final int tvShowId, final double rating);

    void addTvShowToWatchlist(final int tvShowId);

    void addTvShowToFavorites(final int tvShowId);

    void deleteTvShowById(final int tvShowId, final int type);
}
