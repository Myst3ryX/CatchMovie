package com.myst3ry.catchmovie.ui.person.presenter;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.mapper.PersonResultDataModelMapper;
import com.myst3ry.catchmovie.model.result.PersonResultDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.person.view.PersonsPopularView;
import com.myst3ry.domain.usecase.person.GetPopularPersonsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@PersonsScope
public final class PersonsPopularPresenter extends BasePresenter<PersonsPopularView> {

    private final GetPopularPersonsUseCase mGetPopularPersonsUseCase;
    private static final int mPage = 1; //todo stub

    @Inject
    public PersonsPopularPresenter(final GetPopularPersonsUseCase getPopularPersonsUseCase) {
        this.mGetPopularPersonsUseCase = getPopularPersonsUseCase;
    }

    public void getPopularPersons() {
        addDisposable(mGetPopularPersonsUseCase.execute(mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(PersonResultDataModelMapper::transform)
                .subscribe(this::showPopularPersons,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showPopularPersons(final List<PersonResultDataModel> persons) {
        if (persons != null && !persons.isEmpty()) {
            Timber.i("Popular persons loaded successful, size: %s", persons.size());
            mView.showPopularPersons(persons);
        } else {
            Timber.w("Popular persons load failed: empty list");
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Popular persons load error: %s", message);
        mView.showToast(message);
    }
}
