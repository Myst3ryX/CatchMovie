package com.myst3ry.catchmovie.ui.movie.presenter;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.mapper.MovieItemDataModelMapper;
import com.myst3ry.catchmovie.model.item.MovieItemDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.movie.view.MoviesView;
import com.myst3ry.domain.types.MovieType;
import com.myst3ry.domain.usecase.movie.AddMovieUseCase;
import com.myst3ry.domain.usecase.movie.DeleteMovieUseCase;
import com.myst3ry.domain.usecase.movie.GetMoviesUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@MoviesScope
public final class MoviesPresenter extends BasePresenter<MoviesView> {

    private static final String TAG = "MoviesPresenter";

    private final GetMoviesUseCase mGetMoviesUseCase;
    private final AddMovieUseCase mAddMovieUseCase;
    private final DeleteMovieUseCase mDeleteMovieUseCase;

    @Inject
    public MoviesPresenter(final GetMoviesUseCase getMoviesUseCase, final AddMovieUseCase addMovieUseCase,
                           final DeleteMovieUseCase deleteMovieUseCase) {
        this.mGetMoviesUseCase = getMoviesUseCase;
        this.mAddMovieUseCase = addMovieUseCase;
        this.mDeleteMovieUseCase = deleteMovieUseCase;
    }

    public void getMovies(final MovieType type) {
        addDisposable(mGetMoviesUseCase.execute(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(MovieItemDataModelMapper::transform)
                .subscribe(this::setMovies,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void addMovie(final int movieId, final MovieType type) {
        mAddMovieUseCase.execute(movieId, type);
    }

    public void deleteMovie(final int movieId, final MovieType type) {
        mDeleteMovieUseCase.execute(movieId, type);
    }

    private void setMovies(final List<MovieItemDataModel> movies) {
        if (movies != null && !movies.isEmpty()) {
            Timber.i("Movies loaded successful, size: %s", movies.size());
            mView.setMovies(movies);
        } else {
            Timber.w("Movies load failed: null or empty list");
            mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Movies load error: %s", message);
        mView.showToast(message);
    }
}
