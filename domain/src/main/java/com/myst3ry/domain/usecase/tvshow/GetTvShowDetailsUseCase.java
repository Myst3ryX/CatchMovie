package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.model.TvShow;
import com.myst3ry.domain.repository.TvShowsRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetTvShowDetailsUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public GetTvShowDetailsUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<TvShow> execute(final int tvShowId) {
        return mTvShowsRepository.getTvShowDetailsById(tvShowId);
    }
}
