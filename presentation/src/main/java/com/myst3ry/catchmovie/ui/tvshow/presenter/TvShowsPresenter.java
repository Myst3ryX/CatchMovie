package com.myst3ry.catchmovie.ui.tvshow.presenter;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.model.TvShowDataModel;
import com.myst3ry.catchmovie.model.mapper.TvShowDataModelMapper;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.tvshow.view.TvShowsView;
import com.myst3ry.domain.model.types.TvShowType;
import com.myst3ry.domain.usecase.tvshow.AddTvShowUseCase;
import com.myst3ry.domain.usecase.tvshow.DeleteTvShowUseCase;
import com.myst3ry.domain.usecase.tvshow.GetTvShowsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@TvShowsScope
public final class TvShowsPresenter extends BasePresenter<TvShowsView> {

    private static final String TAG = "TvShowsPresenter";

    private final TvShowDataModelMapper mMapper;
    private final GetTvShowsUseCase mGetTvShowsUseCase;
    private final AddTvShowUseCase mAddTvShowUseCase;
    private final DeleteTvShowUseCase mDeleteTvShowUseCase;

    @Inject
    public TvShowsPresenter(final TvShowDataModelMapper mapper, final GetTvShowsUseCase getTvShowsUseCase,
                            final AddTvShowUseCase addTvShowUseCase, final DeleteTvShowUseCase deleteTvShowUseCase) {
        this.mMapper = mapper;
        this.mGetTvShowsUseCase = getTvShowsUseCase;
        this.mAddTvShowUseCase = addTvShowUseCase;
        this.mDeleteTvShowUseCase = deleteTvShowUseCase;
    }

    public void getTvShows(final TvShowType type) {
        addDisposable(mGetTvShowsUseCase.execute(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(mMapper::transform)
                .subscribe(this::setTvShows,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void addTvShow(final int tvShowId, final TvShowType type) {
        mAddTvShowUseCase.execute(tvShowId, type);
    }

    public void deleteTvShow(final int tvShowId, final TvShowType type) {
        mDeleteTvShowUseCase.execute(tvShowId, type);
    }

    private void setTvShows(final List<TvShowDataModel> tvShows) {
        if (tvShows != null && !tvShows.isEmpty()) {
            //todo log
            mView.setTvShows(tvShows);
        } else {
            mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        //todo log
        mView.showToast(message);
    }
}
