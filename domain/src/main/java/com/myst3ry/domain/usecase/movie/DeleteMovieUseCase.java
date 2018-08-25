package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.model.types.MovieType;
import com.myst3ry.domain.repository.MoviesRepository;

import javax.inject.Inject;

public final class DeleteMovieUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public DeleteMovieUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public void execute(final int movieId, final MovieType type) {
        switch (type) {
            case RECENT:
                mMoviesRepository.deleteRecentMovieById(movieId);
                break;
            case WATCHLIST:
                mMoviesRepository.deleteWatchlistMovieById(movieId);
                break;
            case FAVORITE:
                mMoviesRepository.deleteFavoriteMovieById(movieId);
                break;
            default:
                break;
        }
    }
}
