package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.model.TvShow;
import com.myst3ry.domain.repository.TvShowsRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class CatchTvShowUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public CatchTvShowUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<TvShow> execute(final Object... params) {
        return mTvShowsRepository.catchTvShowWithParams(params);
    }
}
