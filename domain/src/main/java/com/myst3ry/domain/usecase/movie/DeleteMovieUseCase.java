package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.types.MovieType;

import javax.inject.Inject;

public final class DeleteMovieUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public DeleteMovieUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public void execute(final int movieId, final MovieType type) {
        mMoviesRepository.deleteMovieById(movieId, type.ordinal());
    }
}
