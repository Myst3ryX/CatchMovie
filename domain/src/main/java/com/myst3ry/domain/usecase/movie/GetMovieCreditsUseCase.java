package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.model.Person;
import com.myst3ry.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetMovieCreditsUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public GetMovieCreditsUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<List<Person>> execute(final int movieId) {
        return mMoviesRepository.getMovieCreditsById(movieId);
    }
}
