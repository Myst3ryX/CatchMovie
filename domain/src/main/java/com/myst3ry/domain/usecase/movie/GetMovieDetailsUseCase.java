package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.model.detail.MovieDetailModel;
import com.myst3ry.domain.repository.MoviesRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetMovieDetailsUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public GetMovieDetailsUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<MovieDetailModel> execute(final int movieId) {
        return mMoviesRepository.getMovieDetailsById(movieId);
    }
}
