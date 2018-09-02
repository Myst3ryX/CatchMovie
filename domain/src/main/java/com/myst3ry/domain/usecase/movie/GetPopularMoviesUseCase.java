package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.model.result.MovieResultModel;
import com.myst3ry.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetPopularMoviesUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public GetPopularMoviesUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<List<MovieResultModel>> execute(final int page) {
        return mMoviesRepository.getPopularMovies(page);
    }
}
