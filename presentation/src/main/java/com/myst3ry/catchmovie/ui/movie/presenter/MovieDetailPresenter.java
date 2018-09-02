package com.myst3ry.catchmovie.ui.movie.presenter;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.mapper.MovieDetailDataModelMapper;
import com.myst3ry.catchmovie.model.detail.MovieDetailDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.movie.view.MovieDetailView;
import com.myst3ry.domain.types.MovieType;
import com.myst3ry.domain.usecase.movie.AddMovieUseCase;
import com.myst3ry.domain.usecase.movie.DeleteMovieUseCase;
import com.myst3ry.domain.usecase.movie.GetMovieDetailsUseCase;
import com.myst3ry.domain.usecase.movie.SetMovieRatingUseCase;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@MoviesScope
public final class MovieDetailPresenter extends BasePresenter<MovieDetailView> {

    private final GetMovieDetailsUseCase mGetMovieDetailsUseCase;
    private final SetMovieRatingUseCase mSetMovieRatingUseCase;
    private final AddMovieUseCase mAddMovieUseCase;
    private final DeleteMovieUseCase mDeleteMovieUseCase;

    @Inject
    public MovieDetailPresenter(final GetMovieDetailsUseCase getMovieDetailsUseCase,
                                final SetMovieRatingUseCase setMovieRatingUseCase,
                                final AddMovieUseCase addMovieUseCase,
                                final DeleteMovieUseCase deleteMovieUseCase) {
        this.mGetMovieDetailsUseCase = getMovieDetailsUseCase;
        this.mSetMovieRatingUseCase = setMovieRatingUseCase;
        this.mAddMovieUseCase = addMovieUseCase;
        this.mDeleteMovieUseCase = deleteMovieUseCase;
    }

    public void getMovieDetails(final int movieId) {
        addDisposable(mGetMovieDetailsUseCase.execute(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(MovieDetailDataModelMapper::transform)
                .subscribe(this::setMovieDetails,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void setMovieRating(final int movieId, final double rating) {
        addDisposable(mSetMovieRatingUseCase.execute(movieId, rating));
    }

    public void addToWatchlist(final int movieId) {
        addDisposable(mAddMovieUseCase.execute(movieId, MovieType.WATCHLIST));
        mView.setWatchlistStatus(true);
    }

    public void deleteFromWatchlist(final int movieId) {
        addDisposable(mDeleteMovieUseCase.execute(movieId, MovieType.WATCHLIST));
        mView.setWatchlistStatus(false);
    }

    public void addToFavorites(final int movieId) {
        addDisposable(mAddMovieUseCase.execute(movieId, MovieType.FAVORITE));
        mView.setFavoriteStatus(true);
    }

    public void deleteFromFavorites(final int movieId) {
        addDisposable(mDeleteMovieUseCase.execute(movieId, MovieType.FAVORITE));
        mView.setFavoriteStatus(false);
    }

    private void setMovieDetails(final MovieDetailDataModel movie) {
        if (movie != null) {
            Timber.i("Movie /" + movie.getMovieTitle() + "/ details loaded successful");
            mView.setMovieDetails(movie);
        } else {
            Timber.w("Movie details load failed: null object");
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Movie details load error: %s", message);
        mView.showToast(message);
    }
}
