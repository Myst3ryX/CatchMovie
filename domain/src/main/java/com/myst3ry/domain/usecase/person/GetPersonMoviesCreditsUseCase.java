package com.myst3ry.domain.usecase.person;

import com.myst3ry.domain.model.Movie;
import com.myst3ry.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetPersonMoviesCreditsUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public GetPersonMoviesCreditsUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<List<Movie>> execute(final int personId) {
        return mMoviesRepository.getMoviesByPersonId(personId);
    }
}
