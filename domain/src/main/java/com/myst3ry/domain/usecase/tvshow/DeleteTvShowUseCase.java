package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.repository.TvShowsRepository;
import com.myst3ry.domain.types.TvShowType;

import javax.inject.Inject;

public final class DeleteTvShowUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public DeleteTvShowUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public void execute(final int tvShowId, final TvShowType type) {
        mTvShowsRepository.deleteTvShowById(tvShowId, type.ordinal());
    }
}
