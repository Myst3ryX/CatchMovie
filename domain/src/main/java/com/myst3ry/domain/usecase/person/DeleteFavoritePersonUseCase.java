package com.myst3ry.domain.usecase.person;

import com.myst3ry.domain.repository.PersonsRepository;

import javax.inject.Inject;

public final class DeleteFavoritePersonUseCase {

    private final PersonsRepository mPersonsRepository;

    @Inject
    public DeleteFavoritePersonUseCase(final PersonsRepository personsRepository) {
        this.mPersonsRepository = personsRepository;
    }

    public void execute(final int personId) {
        mPersonsRepository.deletePersonById(personId);
    }
}
