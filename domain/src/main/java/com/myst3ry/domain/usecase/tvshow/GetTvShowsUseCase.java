package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.model.TvShow;
import com.myst3ry.domain.model.types.TvShowType;
import com.myst3ry.domain.repository.TvShowsRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetTvShowsUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public GetTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<List<TvShow>> execute(final TvShowType type) {
        switch (type) {
            case RECENT:
                return mTvShowsRepository.getRecentTvShows();
            case WATCHLIST:
                return mTvShowsRepository.getWatchlistTvShows();
            case FAVORITE:
                return mTvShowsRepository.getFavoriteTvShows();
            default:
                return Observable.just(new ArrayList<>());
        }
    }
}