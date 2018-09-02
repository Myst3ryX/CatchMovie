package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.repository.MoviesRepository;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public final class SetMovieRatingUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public SetMovieRatingUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Disposable execute(final int movieId, final double rating) {
        return mMoviesRepository.setMovieRating(movieId, rating);
    }
}
