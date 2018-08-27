package com.myst3ry.catchmovie.ui.person.presenter;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.mapper.PersonItemDataModelMapper;
import com.myst3ry.catchmovie.model.item.PersonItemDataModel;
import com.myst3ry.catchmovie.ui.base.BasePresenter;
import com.myst3ry.catchmovie.ui.person.view.PersonSearchView;
import com.myst3ry.domain.usecase.person.SearchPersonsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@PersonsScope
public final class PersonSearchPresenter extends BasePresenter<PersonSearchView> {

    private static final String TAG = "PersonSearchPresenter";

    private final SearchPersonsUseCase mSearchPersonsUseCase;

    @Inject
    public PersonSearchPresenter(final SearchPersonsUseCase searchPersonsUseCase) {
        this.mSearchPersonsUseCase = searchPersonsUseCase;
    }

    public void searchPersonsByQuery(final String query) {
        addDisposable(mSearchPersonsUseCase.execute(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(PersonItemDataModelMapper::transform)
                .subscribe(this::showSearchResult,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showSearchResult(final List<PersonItemDataModel> persons) {
        if (persons != null && !persons.isEmpty()) {
            Timber.i("Persons search successful, found: %s", persons.size());
            mView.showPersonsSearchResult(persons);
        } else {
            Timber.w("Persons search failed: null or empty list");
            //mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Persons search error: %s", message);
        mView.showToast(message);
    }
}
