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
        return mMoviesRepository.getMovies(type.ordinal());
    }
}
