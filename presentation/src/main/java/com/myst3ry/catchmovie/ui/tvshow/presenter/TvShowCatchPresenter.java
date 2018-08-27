package com.myst3ry.catchmovie.ui.tvshow.presenter;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.mapper.TvShowItemDataModelMapper;
import com.myst3ry.catchmovie.model.item.TvShowItemDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.tvshow.view.TvShowCatchView;
import com.myst3ry.domain.usecase.tvshow.CatchTvShowUseCase;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@TvShowsScope
public final class TvShowCatchPresenter extends BasePresenter<TvShowCatchView> {

    private static final String TAG = "TvShowCatchPresenter";

    private final CatchTvShowUseCase mCatchTvShowUseCase;

    @Inject
    public TvShowCatchPresenter(final CatchTvShowUseCase catchTvShowUseCase) {
        this.mCatchTvShowUseCase = catchTvShowUseCase;
    }

    public void catchTvShow(final Object... params) {
        addDisposable(mCatchTvShowUseCase.execute(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(TvShowItemDataModelMapper::transform)
                .subscribe(this::showCatchResult,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showCatchResult(final TvShowItemDataModel tvShow) {
        if (tvShow != null) {
            Timber.i("TV show /" + tvShow.getTvShowTitle() + "/ catch successful");
            mView.showTvShowCatchResult(tvShow);
        } else {
            Timber.w("TV catch failed: null object");
            //mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("TV catch error: %s", message);
        mView.showToast(message);
    }
}
