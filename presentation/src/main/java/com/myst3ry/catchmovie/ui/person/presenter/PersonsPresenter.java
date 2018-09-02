package com.myst3ry.catchmovie.ui.person.presenter;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.mapper.PersonItemDataModelMapper;
import com.myst3ry.catchmovie.model.item.PersonItemDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.person.view.PersonsView;
import com.myst3ry.domain.usecase.person.GetPersonsUseCase;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@PersonsScope
public final class PersonsPresenter extends BasePresenter<PersonsView> {

    private final GetPersonsUseCase mGetPersonsUseCase;

    @Inject
    public PersonsPresenter(final GetPersonsUseCase getPersonsUseCase) {
        this.mGetPersonsUseCase = getPersonsUseCase;
    }

    public void getPersons() {
        addDisposable(Objects.requireNonNull(mGetPersonsUseCase.execute())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(PersonItemDataModelMapper::transform)
                .subscribe(this::setPersons,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void setPersons(final List<PersonItemDataModel> persons) {
        if (persons != null && !persons.isEmpty()) {
            Timber.i("Persons loaded successful, size: %s", persons.size());
            mView.hideEmptyText();
            mView.setPersons(persons);
        } else {
            Timber.w("Persons load failed: empty list");
            mView.clearPersons();
            mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Persons load error: %s", message);
        mView.showToast(message);
    }
}
