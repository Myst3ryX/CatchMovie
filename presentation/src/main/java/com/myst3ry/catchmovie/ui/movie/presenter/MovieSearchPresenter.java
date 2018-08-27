package com.myst3ry.catchmovie.ui.movie.presenter;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.mapper.MovieItemDataModelMapper;
import com.myst3ry.catchmovie.model.item.MovieItemDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.movie.view.MovieSearchView;
import com.myst3ry.domain.usecase.movie.SearchMoviesUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@MoviesScope
public final class MovieSearchPresenter extends BasePresenter<MovieSearchView> {

    private static final String TAG = "MovieSearchPresenter";

    private final SearchMoviesUseCase mSearchMoviesUseCase;

    @Inject
    public MovieSearchPresenter(final SearchMoviesUseCase searchMoviesUseCase) {
        this.mSearchMoviesUseCase = searchMoviesUseCase;
    }

    public void searchMoviesByQuery(final String query) {
        addDisposable(mSearchMoviesUseCase.execute(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(MovieItemDataModelMapper::transform)
                .subscribe(this::showSearchResult,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showSearchResult(final List<MovieItemDataModel> movies) {
        if (movies != null && !movies.isEmpty()) {
            Timber.i("Movies search successful, found: %s", movies.size());
            mView.showMoviesSearchResult(movies);
        } else {
            Timber.w("Movies search failed: null or empty list");
            //mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Movies search error: %s", message);
        mView.showToast(message);
    }
}
