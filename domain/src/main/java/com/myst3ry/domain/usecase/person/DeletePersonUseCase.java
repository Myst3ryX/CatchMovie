package com.myst3ry.domain.usecase.person;

import com.myst3ry.domain.repository.PersonsRepository;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public final class DeletePersonUseCase {

    private final PersonsRepository mPersonsRepository;

    @Inject
    public DeletePersonUseCase(final PersonsRepository personsRepository) {
        this.mPersonsRepository = personsRepository;
    }

    public Disposable execute(final int personId) {
        return mPersonsRepository.deletePersonById(personId);
    }
}
