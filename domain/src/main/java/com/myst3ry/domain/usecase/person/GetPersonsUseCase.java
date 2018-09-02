package com.myst3ry.domain.usecase.person;

import com.myst3ry.domain.model.item.PersonItemModel;
import com.myst3ry.domain.repository.PersonsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class GetPersonsUseCase {

    private final PersonsRepository mPersonsRepository;

    @Inject
    public GetPersonsUseCase(final PersonsRepository personsRepository) {
        this.mPersonsRepository = personsRepository;
    }

    public Observable<List<PersonItemModel>> execute() {
        return mPersonsRepository.getFavoritePersons();
    }
}
