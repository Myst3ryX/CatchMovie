package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.model.types.TvShowType;
import com.myst3ry.domain.repository.TvShowsRepository;

import javax.inject.Inject;

public final class AddTvShowUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public AddTvShowUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public void execute(final int tvShowId, final TvShowType type) {
        switch (type) {
            case WATCHLIST:
                mTvShowsRepository.addTvShowToWatchlist(tvShowId);
                break;
            case FAVORITE:
                mTvShowsRepository.addTvShowToFavorites(tvShowId);
                break;
            default:
                break;
        }
    }
}
