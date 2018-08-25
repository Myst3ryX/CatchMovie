package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.model.TvShow;
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

    public Observable<List<TvShow>> execute(final String query) {
        return mTvShowsRepository.searchTvShowsByQuery(query);
    }
}