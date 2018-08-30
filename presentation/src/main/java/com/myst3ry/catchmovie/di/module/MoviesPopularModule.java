package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.ui.movie.presenter.MoviesPopularPresenter;
import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.usecase.movie.GetPopularMoviesUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class MoviesPopularModule {

    @Provides
    @MoviesScope
    MoviesPopularPresenter providesPopularMoviesPresenter(final GetPopularMoviesUseCase getPopularMoviesUseCase) {
        return new MoviesPopularPresenter(getPopularMoviesUseCase);
    }

    @Provides
    @MoviesScope
    GetPopularMoviesUseCase providesGetPopularMoviesUseCase(final MoviesRepository moviesRepository) {
        return new GetPopularMoviesUseCase(moviesRepository);
    }
}
