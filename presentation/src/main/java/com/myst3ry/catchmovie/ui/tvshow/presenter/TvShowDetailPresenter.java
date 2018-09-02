package com.myst3ry.catchmovie.ui.tvshow.presenter;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.mapper.TvShowDetailDataModelMapper;
import com.myst3ry.catchmovie.model.detail.TvShowDetailDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.tvshow.view.TvShowDetailView;
import com.myst3ry.domain.types.TvShowType;
import com.myst3ry.domain.usecase.tvshow.AddTvShowUseCase;
import com.myst3ry.domain.usecase.tvshow.DeleteTvShowUseCase;
import com.myst3ry.domain.usecase.tvshow.GetTvShowDetailsUseCase;
import com.myst3ry.domain.usecase.tvshow.SetTvShowRatingUseCase;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@TvShowsScope
public final class TvShowDetailPresenter extends BasePresenter<TvShowDetailView> {

    private final GetTvShowDetailsUseCase mGetTvShowDetailsUseCase;
    private final SetTvShowRatingUseCase mSetTvShowRatingUseCase;
    private final AddTvShowUseCase mAddTvShowUseCase;
    private final DeleteTvShowUseCase mDeleteTvShowUseCase;

    @Inject
    public TvShowDetailPresenter(final GetTvShowDetailsUseCase getTvShowDetailsUseCase,
                                 final SetTvShowRatingUseCase setTvShowRatingUseCase,
                                 final AddTvShowUseCase addTvShowUseCase,
                                 final DeleteTvShowUseCase deleteTvShowUseCase) {
        this.mGetTvShowDetailsUseCase = getTvShowDetailsUseCase;
        this.mSetTvShowRatingUseCase = setTvShowRatingUseCase;
        this.mAddTvShowUseCase = addTvShowUseCase;
        this.mDeleteTvShowUseCase = deleteTvShowUseCase;
    }

    public void getTvShowDetails(final int tvShowId) {
        addDisposable(mGetTvShowDetailsUseCase.execute(tvShowId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(TvShowDetailDataModelMapper::transform)
                .subscribe(this::setTvShowDetails,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void setTvShowRating(final int tvShowId, final double rating) {
        addDisposable(mSetTvShowRatingUseCase.execute(tvShowId, rating));
    }

    public void addToWatchlist(final int tvShowId) {
        addDisposable(mAddTvShowUseCase.execute(tvShowId, TvShowType.WATCHLIST));
        mView.setWatchlistStatus(true);
    }

    public void deleteFromWatchlist(final int tvShowId) {
        addDisposable(mDeleteTvShowUseCase.execute(tvShowId, TvShowType.WATCHLIST));
        mView.setWatchlistStatus(false);
    }

    public void addToFavorites(final int tvShowId) {
        addDisposable(mAddTvShowUseCase.execute(tvShowId, TvShowType.FAVORITE));
        mView.setFavoriteStatus(true);
    }

    public void deleteFromFavorites(final int tvShowId) {
        addDisposable(mDeleteTvShowUseCase.execute(tvShowId, TvShowType.FAVORITE));
        mView.setFavoriteStatus(false);
    }

    private void setTvShowDetails(final TvShowDetailDataModel tvShow) {
        if (tvShow != null) {
            Timber.i("TV show /" + tvShow.getTvShowTitle() + "/ details loaded successful");
            mView.setTvShowDetails(tvShow);
        } else {
            Timber.w("TV details load failed: null object");
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("TV details load error: %s", message);
        mView.showToast(message);
    }
}
