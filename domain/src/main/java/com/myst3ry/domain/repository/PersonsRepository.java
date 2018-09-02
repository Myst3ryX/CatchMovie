package com.myst3ry.domain.repository;

import com.myst3ry.domain.model.detail.PersonDetailModel;
import com.myst3ry.domain.model.item.PersonItemModel;
import com.myst3ry.domain.model.result.PersonResultModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public interface PersonsRepository {

    Observable<List<PersonItemModel>> getFavoritePersons();

    Observable<PersonDetailModel> getPersonDetailsById(final int personId);

    Observable<List<PersonResultModel>> getPopularPersons(final int page);

    Observable<List<PersonResultModel>> searchPersonsByQuery(final String query, final int page);

    Disposable addPersonById(final int personId);

    Disposable deletePersonById(final int personId);
}