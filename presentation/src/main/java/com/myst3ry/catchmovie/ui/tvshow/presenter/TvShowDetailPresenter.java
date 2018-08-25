package com.myst3ry.catchmovie.ui.tvshow.presenter;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.model.TvShowDataModel;
import com.myst3ry.catchmovie.model.mapper.TvShowDataModelMapper;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.tvshow.view.TvShowDetailView;
import com.myst3ry.domain.model.types.TvShowType;
import com.myst3ry.domain.usecase.tvshow.AddTvShowUseCase;
import com.myst3ry.domain.usecase.tvshow.DeleteTvShowUseCase;
import com.myst3ry.domain.usecase.tvshow.GetTvShowCreditsUseCase;
import com.myst3ry.domain.usecase.tvshow.GetTvShowDetailsUseCase;
import com.myst3ry.domain.usecase.tvshow.GetTvShowPostersUseCase;
import com.myst3ry.domain.usecase.tvshow.SetTvShowRatingUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@TvShowsScope
public final class TvShowDetailPresenter extends BasePresenter<TvShowDetailView> {

    private static final String TAG = "TvShowDetailPresenter";

    private final TvShowDataModelMapper mMapper;
    private final GetTvShowDetailsUseCase mGetTvShowDetailsUseCase;
    private final GetTvShowCreditsUseCase mGetTvShowCreditsUseCase;
    private final GetTvShowPostersUseCase mGetTvShowPostersUseCase;
    private final SetTvShowRatingUseCase mSetTvShowRatingUseCase;
    private final AddTvShowUseCase mAddTvShowUseCase;
    private final DeleteTvShowUseCase mDeleteTvShowUseCase;

    @Inject
    public TvShowDetailPresenter(final TvShowDataModelMapper mapper,
                                 final GetTvShowDetailsUseCase getTvShowDetailsUseCase,
                                 final GetTvShowCreditsUseCase getTvShowCreditsUseCase,
                                 final GetTvShowPostersUseCase getTvShowPostersUseCase,
                                 final SetTvShowRatingUseCase setTvShowRatingUseCase,
                                 final AddTvShowUseCase addTvShowUseCase,
                                 final DeleteTvShowUseCase deleteTvShowUseCase) {
        this.mMapper = mapper;
        this.mGetTvShowDetailsUseCase = getTvShowDetailsUseCase;
        this.mGetTvShowCreditsUseCase = getTvShowCreditsUseCase;
        this.mGetTvShowPostersUseCase = getTvShowPostersUseCase;
        this.mSetTvShowRatingUseCase = setTvShowRatingUseCase;
        this.mAddTvShowUseCase = addTvShowUseCase;
        this.mDeleteTvShowUseCase = deleteTvShowUseCase;
    }

    public void getTvShowDetails(final int tvShowId) {
        addDisposable(mGetTvShowDetailsUseCase.execute(tvShowId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(mMapper::transform)
                .subscribe(this::setTvShowDetails,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));

        //todo credits
    }

    public void getTvShowPosters(final int tvShowId) {
        addDisposable(mGetTvShowPostersUseCase.execute(tvShowId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setTvShowPosters,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void setTvShowRating(final int tvShowId, final double rating) {
        mSetTvShowRatingUseCase.execute(tvShowId, rating);
    }

    public void addTvShow(final int tvShowId, final TvShowType type) {
        mAddTvShowUseCase.execute(tvShowId, type);
    }

    public void deleteTvShow(final int tvShowId, final TvShowType type) {
        mDeleteTvShowUseCase.execute(tvShowId, type);
    }

    private void setTvShowDetails(final TvShowDataModel tvShow) {
        //todo log
        if (tvShow != null) {
            mView.setTvShowDetails(tvShow);
        }
    }

    private void setTvShowPosters(final List<String> posters) {
        //todo log
        if (posters != null) {
            mView.setTvShowPosters(posters);
        }
    }

    private void showErrorMessage(final String message) {
        //todo log
        mView.showToast(message);
    }
}
