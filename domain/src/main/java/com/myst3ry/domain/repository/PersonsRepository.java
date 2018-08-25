package com.myst3ry.domain.repository;

import com.myst3ry.domain.model.Person;

import java.util.List;

import io.reactivex.Observable;

public interface PersonsRepository {

    Observable<List<Person>> getFavoriteActors();

    Observable<List<Person>> searchPersonsByQuery(final String query);

    Observable<Person> getPersonDetailsById(final int personId);

    void addPersonToFavorites(final int personId);

    void deletePersonById(final int personId);
}
