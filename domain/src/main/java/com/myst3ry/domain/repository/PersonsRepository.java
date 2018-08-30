package com.myst3ry.domain.repository;

import com.myst3ry.domain.model.detail.PersonDetailModel;
import com.myst3ry.domain.model.item.PersonItemModel;
import com.myst3ry.domain.model.result.PersonResultModel;

import java.util.List;

import io.reactivex.Observable;

public interface PersonsRepository {

    Observable<List<PersonItemModel>> getPersons();

    Observable<PersonDetailModel> getPersonDetailsById(final int personId);

    Observable<List<PersonResultModel>> getPopularPersons();

    Observable<List<PersonResultModel>> searchPersonsByQuery(final String query);

    void addPersonToFavorites(final int personId);

    void deletePersonById(final int personId);
}
