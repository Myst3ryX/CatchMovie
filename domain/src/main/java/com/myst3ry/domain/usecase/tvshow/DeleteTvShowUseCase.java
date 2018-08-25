package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.model.types.TvShowType;
import com.myst3ry.domain.repository.TvShowsRepository;

import javax.inject.Inject;

public final class DeleteTvShowUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public DeleteTvShowUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public void execute(final int tvShowId, final TvShowType type) {
        switch (type) {
            case RECENT:
                mTvShowsRepository.deleteRecentTvShowById(tvShowId);
                break;
            case WATCHLIST:
                mTvShowsRepository.deleteWatchlistTvShowById(tvShowId);
                break;
            case FAVORITE:
                mTvShowsRepository.deleteFavoriteTvShowById(tvShowId);
                break;
            default:
                break;
        }
    }
}
