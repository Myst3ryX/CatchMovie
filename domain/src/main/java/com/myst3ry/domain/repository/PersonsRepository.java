package com.myst3ry.domain.repository;

import com.myst3ry.domain.model.detail.PersonDetailModel;
import com.myst3ry.domain.model.item.PersonItemModel;

import java.util.List;

import io.reactivex.Observable;

public interface PersonsRepository {

    Observable<List<PersonItemModel>> getPersons();

    Observable<List<PersonItemModel>> searchPersonsByQuery(final String query);

    Observable<PersonDetailModel> getPersonDetailsById(final int personId);

    void addPersonToFavorites(final int personId);

    void deletePersonById(final int personId);
}
