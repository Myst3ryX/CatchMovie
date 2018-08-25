package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.repository.MoviesRepository;

import javax.inject.Inject;

public final class SetMovieRatingUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public SetMovieRatingUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public void execute(final int movieId, final double rating) {
        mMoviesRepository.setMovieRating(movieId, rating);
    }
}
