package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.model.result.TvShowResultModel;
import com.myst3ry.domain.repository.TvShowsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class SearchTvShowsUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public SearchTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<List<TvShowResultModel>> execute(final String query, final int page) {
        return mTvShowsRepository.searchTvShowsByQuery(query, page);
    }
}
