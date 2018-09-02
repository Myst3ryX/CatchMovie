package com.myst3ry.catchmovie.ui.movie.presenter;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.mapper.MovieResultDataModelMapper;
import com.myst3ry.catchmovie.model.result.MovieResultDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.movie.view.MoviesSearchView;
import com.myst3ry.domain.usecase.movie.SearchMoviesUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@MoviesScope
public final class MoviesSearchPresenter extends BasePresenter<MoviesSearchView> {

    private final SearchMoviesUseCase mSearchMoviesUseCase;
    private static final int mPage = 1; //todo stub

    @Inject
    public MoviesSearchPresenter(final SearchMoviesUseCase searchMoviesUseCase) {
        this.mSearchMoviesUseCase = searchMoviesUseCase;
    }

    public void searchMoviesByQuery(final String query) {
        addDisposable(mSearchMoviesUseCase.execute(query, mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(MovieResultDataModelMapper::transform)
                .subscribe(this::showMoviesSearchResult,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showMoviesSearchResult(final List<MovieResultDataModel> movies) {
        if (movies != null && !movies.isEmpty()) {
            Timber.i("Movies search successful, found: %s", movies.size());
            mView.hideEmptyText();
            mView.showMoviesSearchResult(movies);
        } else {
            Timber.w("Movies search failed: empty list");
            mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Movies search error: %s", message);
        mView.showToast(message);
    }
}
