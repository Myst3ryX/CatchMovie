package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.model.Movie;
import com.myst3ry.domain.repository.MoviesRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetMovieDetailsUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public GetMovieDetailsUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<Movie> execute(final int movieId) {
        return mMoviesRepository.getMovieDetailsById(movieId);
    }
}
