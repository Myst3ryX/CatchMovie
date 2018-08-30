package com.myst3ry.catchmovie.ui.movie.presenter;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.mapper.MovieResultDataModelMapper;
import com.myst3ry.catchmovie.model.result.MovieResultDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.movie.view.MoviesPopularView;
import com.myst3ry.domain.usecase.movie.GetPopularMoviesUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@MoviesScope
public final class MoviesPopularPresenter extends BasePresenter<MoviesPopularView> {

    private static final String TAG = "MoviesPopularPresenter";

    private final GetPopularMoviesUseCase mGetPopularMoviesUseCase;

    @Inject
    public MoviesPopularPresenter(final GetPopularMoviesUseCase getPopularMoviesUseCase) {
        this.mGetPopularMoviesUseCase = getPopularMoviesUseCase;
    }

    public void getPopularMovies() {
        addDisposable(mGetPopularMoviesUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(MovieResultDataModelMapper::transform)
                .subscribe(this::showPopularMovies,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showPopularMovies(final List<MovieResultDataModel> movies) {
        if (movies != null && !movies.isEmpty()) {
            Timber.i("Popular movies loaded successful, size: %s", movies.size());
            mView.showPopularMovies(movies);
        } else {
            Timber.w("Popular movies load failed: null or empty list");
            //mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Popular movies load error: %s", message);
        mView.showToast(message);
    }
}
