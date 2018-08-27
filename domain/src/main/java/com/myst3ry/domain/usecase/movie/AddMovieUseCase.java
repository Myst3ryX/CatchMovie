package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.types.MovieType;

import javax.inject.Inject;

public final class AddMovieUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public AddMovieUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public void execute(final int movieId, final MovieType type) {
        switch (type) {
            case WATCHLIST:
                mMoviesRepository.addMovieToWatchlist(movieId);
                break;
            case FAVORITE:
                mMoviesRepository.addMovieToFavorites(movieId);
                break;
            default:
                break;
        }
    }
}
