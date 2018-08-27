package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.model.item.MovieItemModel;
import com.myst3ry.domain.repository.MoviesRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class CatchMovieUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public CatchMovieUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<MovieItemModel> execute(final Object... params) {
        return mMoviesRepository.catchMovieWithParams(params);
    }
}
