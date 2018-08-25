package com.myst3ry.domain.usecase.tvshow;

import com.myst3ry.domain.model.Person;
import com.myst3ry.domain.repository.TvShowsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetTvShowCreditsUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public GetTvShowCreditsUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<List<Person>> execute(final int tvShowId) {
        return mTvShowsRepository.getTvShowCreditsById(tvShowId);
    }
}
