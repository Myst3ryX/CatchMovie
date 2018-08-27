package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.model.item.TvShowItemModel;
import com.myst3ry.domain.repository.TvShowsRepository;
import com.myst3ry.domain.types.TvShowType;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetTvShowsUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public GetTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<List<TvShowItemModel>> execute(final TvShowType type) {
        return mTvShowsRepository.getTvShows(type.ordinal());
    }
}
