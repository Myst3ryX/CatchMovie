package com.myst3ry.domain.usecase.movie;

import com.myst3ry.domain.model.Movie;
import com.myst3ry.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class SearchMoviesUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public SearchMoviesUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<List<Movie>> execute(final String query) {
        return mMoviesRepository.searchMoviesByQuery(query);
    }
}
