package com.myst3ry.domain.usecase.person;

import com.myst3ry.domain.repository.PersonsRepository;

import javax.inject.Inject;

public final class AddPersonToFavoritesUseCase {

    private final PersonsRepository mPersonsRepository;

    @Inject
    public AddPersonToFavoritesUseCase(final PersonsRepository personsRepository) {
        this.mPersonsRepository = personsRepository;
    }

    public void execute(final int personId) {
        mPersonsRepository.addPersonToFavorites(personId);
    }
}
