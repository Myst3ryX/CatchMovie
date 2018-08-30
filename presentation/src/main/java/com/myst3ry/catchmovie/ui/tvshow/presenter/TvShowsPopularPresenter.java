package com.myst3ry.catchmovie.ui.tvshow.presenter;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.mapper.TvShowResultDataModelMapper;
import com.myst3ry.catchmovie.model.result.TvShowResultDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.tvshow.view.TvShowsPopularView;
import com.myst3ry.domain.usecase.tvshow.GetPopularTvShowsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@TvShowsScope
public final class TvShowsPopularPresenter extends BasePresenter<TvShowsPopularView> {

    private static final String TAG = "TvShowsPopularPresenter";

    private final GetPopularTvShowsUseCase mGetPopularTvShowsUseCase;

    @Inject
    public TvShowsPopularPresenter(final GetPopularTvShowsUseCase getPopularTvShowsUseCase) {
        this.mGetPopularTvShowsUseCase = getPopularTvShowsUseCase;
    }

    public void getPopularTvShows() {
        addDisposable(mGetPopularTvShowsUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(TvShowResultDataModelMapper::transform)
                .subscribe(this::showPopularTvShows,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showPopularTvShows(final List<TvShowResultDataModel> tvShows) {
        if (tvShows != null && !tvShows.isEmpty()) {
            Timber.i("Popular TV shows loaded successful, size: %s", tvShows.size());
            mView.showPopularTvShows(tvShows);
        } else {
            Timber.w("Popular TV shows load failed: null or empty list");
            //mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Popular TV shows load error: %s", message);
        mView.showToast(message);
    }
}
