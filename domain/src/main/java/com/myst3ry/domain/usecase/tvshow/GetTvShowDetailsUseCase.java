package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.model.detail.TvShowDetailModel;
import com.myst3ry.domain.repository.TvShowsRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * A UseCase class for getting tv show details
 */
public final class GetTvShowDetailsUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public GetTvShowDetailsUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<TvShowDetailModel> execute(final int tvShowId) {
        return mTvShowsRepository.getTvShowDetailsById(tvShowId);
    }
}
