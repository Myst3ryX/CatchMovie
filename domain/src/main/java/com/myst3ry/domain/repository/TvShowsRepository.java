package com.myst3ry.domain.repository;

import com.myst3ry.domain.model.detail.TvShowDetailModel;
import com.myst3ry.domain.model.item.TvShowItemModel;
import com.myst3ry.domain.model.result.TvShowResultModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public interface TvShowsRepository {

    Observable<List<TvShowItemModel>> getRecentTvShows();

    Observable<List<TvShowItemModel>> getWatchlistTvShows();

    Observable<List<TvShowItemModel>> getFavoriteTvShows();

    Observable<TvShowDetailModel> getTvShowDetailsById(final int tvShowId);

    Observable<List<TvShowResultModel>> getPopularTvShows(final int page);

    Observable<List<TvShowResultModel>> searchTvShowsByQuery(final String query, final int page);

    Disposable setTvShowRating(final int tvShowId, final double rating);

    Disposable addTvShowToWatchlist(final int tvShowId);

    Disposable addTvShowToFavorites(final int tvShowId);

    Disposable deleteTvShowFromRecent(final int movieId);

    Disposable deleteTvShowFromWatchlist(final int movieId);

    Disposable deleteTvShowFromFavorites(final int movieId);
}
