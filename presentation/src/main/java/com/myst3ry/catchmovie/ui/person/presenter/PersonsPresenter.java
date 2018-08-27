package com.myst3ry.catchmovie.ui.person.presenter;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.mapper.PersonItemDataModelMapper;
import com.myst3ry.catchmovie.model.item.PersonItemDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.person.view.PersonsView;
import com.myst3ry.domain.usecase.person.AddPersonToFavoritesUseCase;
import com.myst3ry.domain.usecase.person.DeleteFavoritePersonUseCase;
import com.myst3ry.domain.usecase.person.GetFavoritePersonsUseCase;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@PersonsScope
public final class PersonsPresenter extends BasePresenter<PersonsView> {

    private static final String TAG = "PersonsPresenter";

    private final GetFavoritePersonsUseCase mGetFavoritePersonsUseCase;
    private final AddPersonToFavoritesUseCase mAddPersonToFavoritesUseCase;
    private final DeleteFavoritePersonUseCase mDeleteFavoritePersonUseCase;

    @Inject
    public PersonsPresenter(final GetFavoritePersonsUseCase getFavoritePersonsUseCase,
                            final AddPersonToFavoritesUseCase addPersonToFavoritesUseCase,
                            final DeleteFavoritePersonUseCase deleteFavoritePersonUseCase) {
        this.mGetFavoritePersonsUseCase = getFavoritePersonsUseCase;
        this.mAddPersonToFavoritesUseCase = addPersonToFavoritesUseCase;
        this.mDeleteFavoritePersonUseCase = deleteFavoritePersonUseCase;
    }

    public void getPersons() {
        addDisposable(Objects.requireNonNull(mGetFavoritePersonsUseCase.execute())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(PersonItemDataModelMapper::transform)
                .subscribe(this::setPersons,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void addPerson(final int personId) {
        mAddPersonToFavoritesUseCase.execute(personId);
    }

    public void deletePerson(final int personId) {
        mDeleteFavoritePersonUseCase.execute(personId);
    }

    private void setPersons(final List<PersonItemDataModel> persons) {
        if (persons != null && !persons.isEmpty()) {
            Timber.i("Persons loaded successful, size: %s", persons.size());
            mView.setPersons(persons);
        } else {
            Timber.w("Persons load failed: null or empty list");
            mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Persons load error: %s", message);
        mView.showToast(message);
    }
}
