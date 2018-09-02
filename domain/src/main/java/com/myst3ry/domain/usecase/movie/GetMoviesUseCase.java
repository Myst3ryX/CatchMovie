package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.model.item.MovieItemModel;
import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.types.MovieType;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetMoviesUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public GetMoviesUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<List<MovieItemModel>> execute(final MovieType type) {
        switch (type) {
            case RECENT:
                return mMoviesRepository.getRecentMovies();
            case WATCHLIST:
                return mMoviesRepository.getWatchlistMovies();
            case FAVORITE:
                return mMoviesRepository.getFavoriteMovies();
            default:
                return Observable.empty();
        }
    }
}
