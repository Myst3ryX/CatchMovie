package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.ui.movie.presenter.MoviesPresenter;
import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.usecase.movie.AddMovieUseCase;
import com.myst3ry.domain.usecase.movie.DeleteMovieUseCase;
import com.myst3ry.domain.usecase.movie.GetMoviesUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class MoviesModule {

    @Provides
    @MoviesScope
    MoviesPresenter providesMoviesPresenter(final GetMoviesUseCase getMoviesUseCase,
                                            final AddMovieUseCase addMovieUseCase,
                                            final DeleteMovieUseCase deleteMovieUseCase) {
        return new MoviesPresenter(getMoviesUseCase, addMovieUseCase, deleteMovieUseCase);
    }


    @Provides
    @MoviesScope
    GetMoviesUseCase providesGetRecentMoviesUseCase(final MoviesRepository moviesRepository) {
        return new GetMoviesUseCase(moviesRepository);
    }

    @Provides
    @MoviesScope
    AddMovieUseCase providesAddMovieToFavoritesUseCase(final MoviesRepository moviesRepository) {
        return new AddMovieUseCase(moviesRepository);
    }

    @Provides
    @MoviesScope
    DeleteMovieUseCase providesDeleteFavoriteMovieUseCase(final MoviesRepository moviesRepository) {
        return new DeleteMovieUseCase(moviesRepository);
    }
}
