package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.ui.movie.presenter.MovieSearchPresenter;
import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.usecase.movie.SearchMoviesUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class MovieSearchModule {

    @Provides
    @MoviesScope
    MovieSearchPresenter providesMovieSearchPresenter(final SearchMoviesUseCase searchMoviesUseCase) {
        return new MovieSearchPresenter(searchMoviesUseCase);
    }

    @Provides
    @MoviesScope
    SearchMoviesUseCase providesSearchMoviesUseCase(final MoviesRepository moviesRepository) {
        return new SearchMoviesUseCase(moviesRepository);
    }
}
