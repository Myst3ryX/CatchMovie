package com.myst3ry.catchmovie.ui.tvshow.presenter;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.model.TvShowDataModel;
import com.myst3ry.catchmovie.model.mapper.TvShowDataModelMapper;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.tvshow.view.TvShowCatchView;
import com.myst3ry.domain.usecase.tvshow.CatchTvShowUseCase;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@TvShowsScope
public final class TvShowCatchPresenter extends BasePresenter<TvShowCatchView> {

    private static final String TAG = "TvShowCatchPresenter";

    private final TvShowDataModelMapper mMapper;
    private final CatchTvShowUseCase mCatchTvShowUseCase;

    @Inject
    public TvShowCatchPresenter(final TvShowDataModelMapper mapper, final CatchTvShowUseCase catchTvShowUseCase) {
        this.mMapper = mapper;
        this.mCatchTvShowUseCase = catchTvShowUseCase;
    }

    public void catchTvShow(final Object... params) {
        addDisposable(mCatchTvShowUseCase.execute(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(mMapper::transform)
                .subscribe(this::showCatchResult,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showCatchResult(final TvShowDataModel tvShow) {
        //todo log
        if (tvShow != null) {
            mView.showTvShowCatchResult(tvShow);
        }
    }

    private void showErrorMessage(final String message) {
        //todo log
        mView.showToast(message);
    }
}
