package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.repository.TvShowsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetTvShowPostersUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public GetTvShowPostersUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<List<String>> execute(final int tvShowId) {
        return mTvShowsRepository.getTvShowPostersById(tvShowId);
    }
}
