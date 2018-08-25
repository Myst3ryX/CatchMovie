package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.repository.TvShowsRepository;

import javax.inject.Inject;

public final class SetTvShowRatingUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public SetTvShowRatingUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public void execute(final int tvShowId, final double rating) {
        mTvShowsRepository.setTvShowRating(tvShowId, rating);
    }
}
