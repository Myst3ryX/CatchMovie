package com.myst3ry.catchmovie.ui.person.presenter;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.model.PersonDataModel;
import com.myst3ry.catchmovie.model.mapper.PersonDataModelMapper;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.person.view.PersonDetailView;
import com.myst3ry.domain.usecase.person.AddPersonToFavoritesUseCase;
import com.myst3ry.domain.usecase.person.DeleteFavoritePersonUseCase;
import com.myst3ry.domain.usecase.person.GetPersonDetailsUseCase;
import com.myst3ry.domain.usecase.person.GetPersonMoviesCreditsUseCase;
import com.myst3ry.domain.usecase.person.GetPersonTvShowsCreditsUseCase;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@PersonsScope
public final class PersonDetailPresenter extends BasePresenter<PersonDetailView> {

    private static final String TAG = "PersonDetailPresenter";

    private final PersonDataModelMapper mMapper;
    private final GetPersonDetailsUseCase mGetPersonDetailsUseCase;
    private final GetPersonMoviesCreditsUseCase mGetPersonMoviesCreditsUseCase;
    private final GetPersonTvShowsCreditsUseCase mGetPersonTvShowsCreditsUseCase;
    private final AddPersonToFavoritesUseCase mAddPersonToFavoritesUseCase;
    private final DeleteFavoritePersonUseCase mDeleteFavoritePersonUseCase;

    @Inject
    public PersonDetailPresenter(final PersonDataModelMapper mapper,
                                 final GetPersonDetailsUseCase getPersonDetailsUseCase,
                                 final GetPersonMoviesCreditsUseCase getPersonMoviesCreditsUseCase,
                                 final GetPersonTvShowsCreditsUseCase getPersonTvShowsCreditsUseCase,
                                 final AddPersonToFavoritesUseCase addPersonToFavoritesUseCase,
                                 final DeleteFavoritePersonUseCase deleteFavoritePersonUseCase) {
        this.mMapper = mapper;
        this.mGetPersonDetailsUseCase = getPersonDetailsUseCase;
        this.mGetPersonMoviesCreditsUseCase = getPersonMoviesCreditsUseCase;
        this.mGetPersonTvShowsCreditsUseCase = getPersonTvShowsCreditsUseCase;
        this.mAddPersonToFavoritesUseCase = addPersonToFavoritesUseCase;
        this.mDeleteFavoritePersonUseCase = deleteFavoritePersonUseCase;
    }

    public void getPersonDetails(final int personId) {
        addDisposable(mGetPersonDetailsUseCase.execute(personId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(mMapper::transform)
                .subscribe(this::setPersonDetails,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));

        //todo credits movie / tvshow
    }

    public void addPerson(final int personId) {
        mAddPersonToFavoritesUseCase.execute(personId);
    }

    public void deletePerson(final int personId) {
        mDeleteFavoritePersonUseCase.execute(personId);
    }

    private void setPersonDetails(final PersonDataModel person) {
        //todo log
        if (person != null) {
            mView.setPersonDetails(person);
        }
    }

    private void showErrorMessage(final String message) {
        //todo log
        mView.showToast(message);
    }

}
