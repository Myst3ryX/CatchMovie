package com.myst3ry.domain.usecase.person;

import com.myst3ry.domain.model.Person;
import com.myst3ry.domain.repository.PersonsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class SearchPersonsUseCase {

    private final PersonsRepository mPersonsRepository;

    @Inject
    public SearchPersonsUseCase(final PersonsRepository personsRepository) {
        this.mPersonsRepository = personsRepository;
    }

    public Observable<List<Person>> execute(final String query) {
        return mPersonsRepository.searchPersonsByQuery(query);
    }
}