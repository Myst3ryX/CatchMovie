package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.model.item.TvShowItemModel;
import com.myst3ry.domain.repository.TvShowsRepository;
import com.myst3ry.domain.types.TvShowType;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * A UseCase class for getting tv show collections by tv show type
 */
public final class GetTvShowsUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public GetTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<List<TvShowItemModel>> execute(final TvShowType type) {
        switch (type) {
            case RECENT:
                return mTvShowsRepository.getRecentTvShows();
            case WATCHLIST:
                return mTvShowsRepository.getWatchlistTvShows();
            case FAVORITE:
                return mTvShowsRepository.getFavoriteTvShows();
            default:
                return Observable.empty();
        }
    }
}
