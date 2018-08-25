package com.myst3ry.domain.usecase.person;

import com.myst3ry.domain.model.TvShow;
import com.myst3ry.domain.repository.TvShowsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetPersonTvShowsCreditsUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public GetPersonTvShowsCreditsUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<List<TvShow>> execute(final int personId) {
        return mTvShowsRepository.getTvShowsByPersonId(personId);
    }
}
