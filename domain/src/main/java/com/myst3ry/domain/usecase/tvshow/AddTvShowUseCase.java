package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.repository.TvShowsRepository;
import com.myst3ry.domain.types.TvShowType;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public final class AddTvShowUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public AddTvShowUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Disposable execute(final int tvShowId, final TvShowType type) {
        switch (type) {
            case WATCHLIST:
                return mTvShowsRepository.addTvShowToWatchlist(tvShowId);
            case FAVORITE:
                return mTvShowsRepository.addTvShowToFavorites(tvShowId);
            default:
                return null;
        }
    }
}
