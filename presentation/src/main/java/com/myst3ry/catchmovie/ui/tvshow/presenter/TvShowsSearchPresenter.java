package com.myst3ry.catchmovie.ui.tvshow.presenter;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.mapper.TvShowResultDataModelMapper;
import com.myst3ry.catchmovie.model.result.TvShowResultDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.tvshow.view.TvShowsSearchView;
import com.myst3ry.domain.usecase.tvshow.SearchTvShowsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@TvShowsScope
public final class TvShowsSearchPresenter extends BasePresenter<TvShowsSearchView> {

    private static final String TAG = "TvShowsSearchPresenter";

    private final SearchTvShowsUseCase mSearchTvShowsUseCase;

    @Inject
    public TvShowsSearchPresenter(final SearchTvShowsUseCase searchTvShowsUseCase) {
        this.mSearchTvShowsUseCase = searchTvShowsUseCase;
    }

    public void searchTvShowsByQuery(final String query) {
        addDisposable(mSearchTvShowsUseCase.execute(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(TvShowResultDataModelMapper::transform)
                .subscribe(this::showTvShowsSearchResult,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showTvShowsSearchResult(final List<TvShowResultDataModel> tvShows) {
        if (tvShows != null && !tvShows.isEmpty()) {
            Timber.i("TV search successful, found: %s", tvShows.size());
            mView.showTvShowsSearchResult(tvShows);
        } else {
            Timber.w("TV search failed: null or empty list");
            //mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("TV search error: %s", message);
        mView.showToast(message);
    }
}
