package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.types.MovieType;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * A UseCase class for adding movie to collection
 */
public final class AddMovieUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public AddMovieUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Disposable execute(final int movieId, final MovieType type) {
        switch (type) {
            case WATCHLIST:
                return mMoviesRepository.addMovieToWatchlist(movieId);
            case FAVORITE:
                return mMoviesRepository.addMovieToFavorites(movieId);
            default:
                return null;
        }
    }
}
