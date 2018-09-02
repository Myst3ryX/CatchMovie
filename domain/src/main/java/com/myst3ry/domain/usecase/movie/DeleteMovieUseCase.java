package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.types.MovieType;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public final class DeleteMovieUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public DeleteMovieUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Disposable execute(final int movieId, final MovieType type) {
        switch (type) {
            case RECENT:
                return mMoviesRepository.deleteMovieFromRecent(movieId);
            case WATCHLIST:
                return mMoviesRepository.deleteMovieFromWatchlist(movieId);
            case FAVORITE:
                return mMoviesRepository.deleteMovieFromFavorites(movieId);
            default:
                return null;
        }
    }
}
