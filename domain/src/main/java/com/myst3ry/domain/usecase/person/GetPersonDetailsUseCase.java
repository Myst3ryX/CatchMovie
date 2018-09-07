package com.myst3ry.domain.usecase.person;

import com.myst3ry.domain.model.detail.PersonDetailModel;
import com.myst3ry.domain.repository.PersonsRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * A UseCase class for getting person details
 */
public final class GetPersonDetailsUseCase {

    private final PersonsRepository mPersonsRepository;

    @Inject
    public GetPersonDetailsUseCase(final PersonsRepository personsRepository) {
        this.mPersonsRepository = personsRepository;
    }

    public Observable<PersonDetailModel> execute(final int personId) {
        return mPersonsRepository.getPersonDetailsById(personId);
    }
}
