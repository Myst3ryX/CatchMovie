package com.myst3ry.catchmovie.ui.person.presenter;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.mapper.PersonDetailDataModelMapper;
import com.myst3ry.catchmovie.model.detail.PersonDetailDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.person.view.PersonDetailView;
import com.myst3ry.domain.usecase.person.AddPersonUseCase;
import com.myst3ry.domain.usecase.person.DeletePersonUseCase;
import com.myst3ry.domain.usecase.person.GetPersonDetailsUseCase;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@PersonsScope
public final class PersonDetailPresenter extends BasePresenter<PersonDetailView> {

    private final GetPersonDetailsUseCase mGetPersonDetailsUseCase;
    private final AddPersonUseCase mAddPersonUseCase;
    private final DeletePersonUseCase mDeletePersonUseCase;

    @Inject
    public PersonDetailPresenter(final GetPersonDetailsUseCase getPersonDetailsUseCase,
                                 final AddPersonUseCase addPersonUseCase,
                                 final DeletePersonUseCase deletePersonUseCase) {
        this.mGetPersonDetailsUseCase = getPersonDetailsUseCase;
        this.mAddPersonUseCase = addPersonUseCase;
        this.mDeletePersonUseCase = deletePersonUseCase;
    }

    public void getPersonDetails(final int personId) {
        addDisposable(mGetPersonDetailsUseCase.execute(personId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(PersonDetailDataModelMapper::transform)
                .subscribe(this::setPersonDetails,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void addToFavorites(final int personId) {
        addDisposable(mAddPersonUseCase.execute(personId));
        mView.setFavoriteStatus(true);
    }

    public void deleteFromFavorites(final int personId) {
        addDisposable(mDeletePersonUseCase.execute(personId));
        mView.setFavoriteStatus(false);
    }

    private void setPersonDetails(final PersonDetailDataModel person) {
        if (person != null) {
            Timber.i("PersonDetail /" + person.getPersonName() + "/ details loaded successful");
            mView.setPersonDetails(person);
        } else {
            Timber.w("PersonDetail details load failed: null object");
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("PersonDetail details load error: %s", message);
        mView.showToast(message);
    }
}
