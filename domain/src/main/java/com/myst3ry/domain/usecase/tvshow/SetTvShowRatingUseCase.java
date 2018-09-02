package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.repository.TvShowsRepository;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public final class SetTvShowRatingUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public SetTvShowRatingUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Disposable execute(final int tvShowId, final double rating) {
        return mTvShowsRepository.setTvShowRating(tvShowId, rating);
    }
}
