package com.myst3ry.catchmovie.ui.movie.presenter;

import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.model.MovieDataModel;
import com.myst3ry.catchmovie.model.mapper.MovieDataModelMapper;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.movie.view.MovieDetailView;
import com.myst3ry.domain.model.types.MovieType;
import com.myst3ry.domain.usecase.movie.AddMovieUseCase;
import com.myst3ry.domain.usecase.movie.DeleteMovieUseCase;
import com.myst3ry.domain.usecase.movie.GetMovieCreditsUseCase;
import com.myst3ry.domain.usecase.movie.GetMovieDetailsUseCase;
import com.myst3ry.domain.usecase.movie.GetMoviePostersUseCase;
import com.myst3ry.domain.usecase.movie.SetMovieRatingUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@MoviesScope
public final class MovieDetailPresenter extends BasePresenter<MovieDetailView> {

    private static final String TAG = "MovieDetailPresenter";

    private final MovieDataModelMapper mMapper;
    private final GetMovieDetailsUseCase mGetMovieDetailsUseCase;
    private final GetMovieCreditsUseCase mGetMovieCreditsUseCase;
    private final GetMoviePostersUseCase mGetMoviePostersUseCase;
    private final SetMovieRatingUseCase mSetMovieRatingUseCase;
    private final AddMovieUseCase mAddMovieUseCase;
    private final DeleteMovieUseCase mDeleteMovieUseCase;

    @Inject
    public MovieDetailPresenter(final MovieDataModelMapper mapper,
                                final GetMovieDetailsUseCase getMovieDetailsUseCase,
                                final GetMovieCreditsUseCase getMovieCreditsUseCase,
                                final GetMoviePostersUseCase getMoviePostersUseCase,
                                final SetMovieRatingUseCase setMovieRatingUseCase,
                                final AddMovieUseCase addMovieUseCase,
                                final DeleteMovieUseCase deleteMovieUseCase) {
        this.mMapper = mapper;
        this.mGetMovieDetailsUseCase = getMovieDetailsUseCase;
        this.mGetMovieCreditsUseCase = getMovieCreditsUseCase;
        this.mGetMoviePostersUseCase = getMoviePostersUseCase;
        this.mSetMovieRatingUseCase = setMovieRatingUseCase;
        this.mAddMovieUseCase = addMovieUseCase;
        this.mDeleteMovieUseCase = deleteMovieUseCase;
    }

    public void getMovieDetails(final int movieId) {
        addDisposable(mGetMovieDetailsUseCase.execute(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(mMapper::transform)
                .subscribe(this::setMovieDetails,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));

        //todo credits
    }

    public void getMoviePosters(final int movieId) {
        addDisposable(mGetMoviePostersUseCase.execute(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setMoviePosters,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void setMovieRating(final int movieId, final double rating) {
        mSetMovieRatingUseCase.execute(movieId, rating);
    }

    public void addMovie(final int movieId, final MovieType type) {
        mAddMovieUseCase.execute(movieId, type);
    }

    public void deleteMovie(final int movieId, final MovieType type) {
        mDeleteMovieUseCase.execute(movieId, type);
    }

    private void setMovieDetails(final MovieDataModel movie) {
        //todo log
        if (movie != null) {
            mView.setMovieDetails(movie);
        }
    }

    private void setMoviePosters(final List<String> posters) {
        //todo log
        if (posters != null) {
            mView.setMoviePosters(posters);
        }
    }

    private void showErrorMessage(final String message) {
        //todo log
        mView.showToast(message);
    }
}
