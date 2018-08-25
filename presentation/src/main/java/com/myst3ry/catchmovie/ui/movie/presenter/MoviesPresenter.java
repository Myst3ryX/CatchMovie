package com.myst3ry.catchmovie.ui.movie.presenter;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.model.MovieDataModel;
import com.myst3ry.catchmovie.model.mapper.MovieDataModelMapper;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.movie.view.MoviesView;
import com.myst3ry.domain.model.types.MovieType;
import com.myst3ry.domain.usecase.movie.AddMovieUseCase;
import com.myst3ry.domain.usecase.movie.DeleteMovieUseCase;
import com.myst3ry.domain.usecase.movie.GetMoviesUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@MoviesScope
public final class MoviesPresenter extends BasePresenter<MoviesView> {

    private static final String TAG = "MoviesPresenter";

    private MovieDataModelMapper mMapper;
    private final GetMoviesUseCase mGetMoviesUseCase;
    private final AddMovieUseCase mAddMovieUseCase;
    private final DeleteMovieUseCase mDeleteMovieUseCase;

    @Inject
    public MoviesPresenter(final MovieDataModelMapper mapper, final GetMoviesUseCase getMoviesUseCase,
                           final AddMovieUseCase addMovieUseCase, final DeleteMovieUseCase deleteMovieUseCase) {
        this.mMapper = mapper;
        this.mGetMoviesUseCase = getMoviesUseCase;
        this.mAddMovieUseCase = addMovieUseCase;
        this.mDeleteMovieUseCase = deleteMovieUseCase;
    }

    public void getMovies(final MovieType type) {
        addDisposable(mGetMoviesUseCase.execute(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(mMapper::transform)
                .subscribe(this::setMovies,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void addMovie(final int movieId, final MovieType type) {
        mAddMovieUseCase.execute(movieId, type);
    }

    public void deleteMovie(final int movieId, final MovieType type) {
        mDeleteMovieUseCase.execute(movieId, type);
    }

    private void setMovies(final List<MovieDataModel> movies) {
        if (movies != null && !movies.isEmpty()) {
            mView.setMovies(movies);
        } else {
            mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        //todo log
        mView.showToast(message);
    }
}
