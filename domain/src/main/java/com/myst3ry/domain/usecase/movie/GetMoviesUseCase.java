package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.model.Movie;
import com.myst3ry.domain.model.types.MovieType;
import com.myst3ry.domain.repository.MoviesRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetMoviesUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public GetMoviesUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<List<Movie>> execute(final MovieType type) {
        switch (type) {
            case RECENT:
                return mMoviesRepository.getRecentMovies();
            case WATCHLIST:
                return mMoviesRepository.getWatchlistMovies();
            case FAVORITE:
                return mMoviesRepository.getFavoriteMovies();
            default:
                return Observable.just(new ArrayList<>());
        }
    }
}
