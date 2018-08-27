package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.ui.person.presenter.PersonSearchPresenter;
import com.myst3ry.domain.repository.PersonsRepository;
import com.myst3ry.domain.usecase.person.SearchPersonsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class PersonSearchModule {

    @Provides
    @PersonsScope
    PersonSearchPresenter providesPersonSearchPresenter(final SearchPersonsUseCase searchPersonsUseCase) {
        return new PersonSearchPresenter(searchPersonsUseCase);
    }

    @Provides
    @PersonsScope
    SearchPersonsUseCase providesSearchPersonUseCase(final PersonsRepository personsRepository) {
        return new SearchPersonsUseCase(personsRepository);
    }
}
