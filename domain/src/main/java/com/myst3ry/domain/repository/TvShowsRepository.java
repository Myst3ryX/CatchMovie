package com.myst3ry.domain.repository;

import com.myst3ry.domain.model.detail.TvShowDetailModel;
import com.myst3ry.domain.model.item.TvShowItemModel;
import com.myst3ry.domain.model.result.TvShowResultModel;

import java.util.List;

import io.reactivex.Observable;

public interface TvShowsRepository {

    Observable<List<TvShowItemModel>> getTvShows(final int type);

    Observable<TvShowDetailModel> getTvShowDetailsById(final int tvShowId);

    Observable<List<TvShowResultModel>> getPopularTvShows();

    Observable<List<TvShowResultModel>> searchTvShowsByQuery(final String query);

    void setTvShowRating(final int tvShowId, final double rating);

    void addTvShowToWatchlist(final int tvShowId);

    void addTvShowToFavorites(final int tvShowId);

    void deleteTvShowById(final int tvShowId, final int type);
}
