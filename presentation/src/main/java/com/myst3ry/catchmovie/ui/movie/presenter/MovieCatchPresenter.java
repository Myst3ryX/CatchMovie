package com.myst3ry.catchmovie.ui.movie.presenter;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.model.MovieDataModel;
import com.myst3ry.catchmovie.model.mapper.MovieDataModelMapper;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.movie.view.MovieCatchView;
import com.myst3ry.domain.usecase.movie.CatchMovieUseCase;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@MoviesScope
public final class MovieCatchPresenter extends BasePresenter<MovieCatchView> {

    private static final String TAG = "MovieCatchPresenter";

    private final MovieDataModelMapper mMapper;
    private final CatchMovieUseCase mCatchMovieUseCase;

    @Inject
    public MovieCatchPresenter(final MovieDataModelMapper mapper, final CatchMovieUseCase catchMovieUseCase) {
        this.mMapper = mapper;
        this.mCatchMovieUseCase = catchMovieUseCase;
    }

    public void catchMovie(final Object... params) {
        addDisposable(mCatchMovieUseCase.execute(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(mMapper::transform)
                .subscribe(this::showCatchResult,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showCatchResult(final MovieDataModel movie) {
        //todo log
        if (movie != null) {
            mView.showMovieCatchResult(movie);
        }
    }

    private void showErrorMessage(final String message) {
        //todo log
        mView.showToast(message);
    }
}
