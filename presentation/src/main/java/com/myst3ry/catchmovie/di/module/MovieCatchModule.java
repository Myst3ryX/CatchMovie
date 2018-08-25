package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.model.mapper.MovieDataModelMapper;
import com.myst3ry.catchmovie.ui.movie.presenter.MovieCatchPresenter;
import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.usecase.movie.CatchMovieUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class MovieCatchModule {

    @Provides
    @MoviesScope
    MovieCatchPresenter providesMovieCatchPresenter(final MovieDataModelMapper mapper,
                                                    final CatchMovieUseCase catchMovieUseCase) {
        return new MovieCatchPresenter(mapper, catchMovieUseCase);
    }

    @Provides
    @MoviesScope
    CatchMovieUseCase providesCatchMovieUseCase(final MoviesRepository moviesRepository) {
        return new CatchMovieUseCase(moviesRepository);
    }
}
