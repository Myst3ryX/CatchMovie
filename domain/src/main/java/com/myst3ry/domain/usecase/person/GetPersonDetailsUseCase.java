package com.myst3ry.domain.usecase.person;

import com.myst3ry.domain.model.Person;
import com.myst3ry.domain.repository.PersonsRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetPersonDetailsUseCase {

    private final PersonsRepository mPersonsRepository;

    @Inject
    public GetPersonDetailsUseCase(final PersonsRepository personsRepository) {
        this.mPersonsRepository = personsRepository;
    }

    public Observable<Person> execute(final int personId) {
        return mPersonsRepository.getPersonDetailsById(personId);
    }
}
