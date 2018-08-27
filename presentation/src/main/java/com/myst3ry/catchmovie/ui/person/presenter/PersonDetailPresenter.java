package com.myst3ry.catchmovie.ui.person.presenter;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.mapper.PersonDetailDataModelMapper;
import com.myst3ry.catchmovie.model.detail.PersonDetailDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.person.view.PersonDetailView;
import com.myst3ry.domain.usecase.person.AddPersonToFavoritesUseCase;
import com.myst3ry.domain.usecase.person.DeleteFavoritePersonUseCase;
import com.myst3ry.domain.usecase.person.GetPersonDetailsUseCase;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@PersonsScope
public final class PersonDetailPresenter extends BasePresenter<PersonDetailView> {

    private static final String TAG = "PersonDetailPresenter";

    private final GetPersonDetailsUseCase mGetPersonDetailsUseCase;
    private final AddPersonToFavoritesUseCase mAddPersonToFavoritesUseCase;
    private final DeleteFavoritePersonUseCase mDeleteFavoritePersonUseCase;

    @Inject
    public PersonDetailPresenter(final GetPersonDetailsUseCase getPersonDetailsUseCase,
                                 final AddPersonToFavoritesUseCase addPersonToFavoritesUseCase,
                                 final DeleteFavoritePersonUseCase deleteFavoritePersonUseCase) {
        this.mGetPersonDetailsUseCase = getPersonDetailsUseCase;
        this.mAddPersonToFavoritesUseCase = addPersonToFavoritesUseCase;
        this.mDeleteFavoritePersonUseCase = deleteFavoritePersonUseCase;
    }

    public void getPersonDetails(final int personId) {
        addDisposable(mGetPersonDetailsUseCase.execute(personId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(PersonDetailDataModelMapper::transform)
                .subscribe(this::setPersonDetails,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void addPerson(final int personId) {
        mAddPersonToFavoritesUseCase.execute(personId);
    }

    public void deletePerson(final int personId) {
        mDeleteFavoritePersonUseCase.execute(personId);
    }

    private void setPersonDetails(final PersonDetailDataModel person) {
        if (person != null) {
            Timber.i("Person /" + person.getPersonName() + "/ details loaded successful");
            mView.setPersonDetails(person);
        } else {
            Timber.w("Person details load failed: null object");
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Person details load error: %s", message);
        mView.showToast(message);
    }

}
