package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.model.result.TvShowResultModel;
import com.myst3ry.domain.repository.TvShowsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetPopularTvShowsUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public GetPopularTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<List<TvShowResultModel>> execute(final int page) {
        return mTvShowsRepository.getPopularTvShows(page);
    }
}
