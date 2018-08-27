package com.myst3ry.catchmovie.ui.tvshow.presenter;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.mapper.TvShowItemDataModelMapper;
import com.myst3ry.catchmovie.model.item.TvShowItemDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.tvshow.view.TvShowSearchView;
import com.myst3ry.domain.usecase.tvshow.SearchTvShowsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@TvShowsScope
public final class TvShowSearchPresenter extends BasePresenter<TvShowSearchView> {

    private static final String TAG = "TvShowSearchPresenter";

    private final SearchTvShowsUseCase mSearchTvShowsUseCase;

    @Inject
    public TvShowSearchPresenter(final SearchTvShowsUseCase searchTvShowsUseCase) {
        this.mSearchTvShowsUseCase = searchTvShowsUseCase;
    }

    public void searchTvShowsByQuery(final String query) {
        addDisposable(mSearchTvShowsUseCase.execute(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(TvShowItemDataModelMapper::transform)
                .subscribe(this::showSearchResult,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showSearchResult(final List<TvShowItemDataModel> tvShows) {
        //todo log
        if (tvShows != null && !tvShows.isEmpty()) {
            mView.showTvShowsSearchResult(tvShows);
        }
    }

    private void showErrorMessage(final String message) {
        //todo log
        mView.showToast(message);
    }
}
