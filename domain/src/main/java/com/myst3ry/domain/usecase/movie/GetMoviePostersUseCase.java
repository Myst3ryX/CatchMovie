package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetMoviePostersUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public GetMoviePostersUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<List<String>> execute(final int movieId) {
        return mMoviesRepository.getMoviePostersById(movieId);
    }
}
