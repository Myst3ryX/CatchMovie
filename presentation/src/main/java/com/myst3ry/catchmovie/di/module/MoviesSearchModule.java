package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.ui.movie.presenter.MoviesSearchPresenter;
import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.usecase.movie.SearchMoviesUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class MoviesSearchModule {

    @Provides
    @MoviesScope
    MoviesSearchPresenter providesMoviesSearchPresenter(final SearchMoviesUseCase searchMoviesUseCase) {
        return new MoviesSearchPresenter(searchMoviesUseCase);
    }

    @Provides
    @MoviesScope
    SearchMoviesUseCase providesSearchMoviesUseCase(final MoviesRepository moviesRepository) {
        return new SearchMoviesUseCase(moviesRepository);
    }
}
