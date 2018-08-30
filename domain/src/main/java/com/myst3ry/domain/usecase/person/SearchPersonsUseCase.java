package com.myst3ry.domain.usecase.person;

import com.myst3ry.domain.model.result.PersonResultModel;
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

    public Observable<List<PersonResultModel>> execute(final String query) {
        return mPersonsRepository.searchPersonsByQuery(query);
    }
}
