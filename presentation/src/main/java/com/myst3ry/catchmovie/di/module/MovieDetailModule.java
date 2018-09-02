package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.ui.movie.presenter.MovieDetailPresenter;
import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.usecase.movie.AddMovieUseCase;
import com.myst3ry.domain.usecase.movie.DeleteMovieUseCase;
import com.myst3ry.domain.usecase.movie.GetMovieDetailsUseCase;
import com.myst3ry.domain.usecase.movie.SetMovieRatingUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class MovieDetailModule {

    @Provides
    @MoviesScope
    MovieDetailPresenter providesMovieDetailPresenter(final GetMovieDetailsUseCase getMovieDetailsUseCase,
                                                      final SetMovieRatingUseCase setMovieRatingUseCase,
                                                      final AddMovieUseCase addMovieUseCase,
                                                      final DeleteMovieUseCase deleteMovieUseCase) {
        return new MovieDetailPresenter(getMovieDetailsUseCase, setMovieRatingUseCase,
                addMovieUseCase, deleteMovieUseCase);
    }

    @Provides
    @MoviesScope
    GetMovieDetailsUseCase providesGetMovieDetailsUseCase(final MoviesRepository moviesRepository) {
        return new GetMovieDetailsUseCase(moviesRepository);
    }

    @Provides
    @MoviesScope
    SetMovieRatingUseCase providesSetMovieRatingUseCase(final MoviesRepository moviesRepository) {
        return new SetMovieRatingUseCase(moviesRepository);
    }
}
