package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.ui.person.presenter.PersonsSearchPresenter;
import com.myst3ry.domain.repository.PersonsRepository;
import com.myst3ry.domain.usecase.person.SearchPersonsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class PersonsSearchModule {

    @Provides
    @PersonsScope
    PersonsSearchPresenter providesPersonsSearchPresenter(final SearchPersonsUseCase searchPersonsUseCase) {
        return new PersonsSearchPresenter(searchPersonsUseCase);
    }

    @Provides
    @PersonsScope
    SearchPersonsUseCase providesSearchPersonsUseCase(final PersonsRepository personsRepository) {
        return new SearchPersonsUseCase(personsRepository);
    }
}
