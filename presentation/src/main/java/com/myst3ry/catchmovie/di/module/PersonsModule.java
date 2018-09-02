package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.ui.person.presenter.PersonsPresenter;
import com.myst3ry.domain.repository.PersonsRepository;
import com.myst3ry.domain.usecase.person.AddPersonUseCase;
import com.myst3ry.domain.usecase.person.DeletePersonUseCase;
import com.myst3ry.domain.usecase.person.GetPersonsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class PersonsModule {

    @Provides
    @PersonsScope
    PersonsPresenter providesPersonsPresenter(final GetPersonsUseCase getPersonsUseCase) {
        return new PersonsPresenter(getPersonsUseCase);
    }

    @Provides
    @PersonsScope
    GetPersonsUseCase providesGetPersonsUseCase(final PersonsRepository personsRepository) {
        return new GetPersonsUseCase(personsRepository);
    }

    @Provides
    @PersonsScope
    AddPersonUseCase providesAddPersonUseCase(final PersonsRepository personsRepository) {
        return new AddPersonUseCase(personsRepository);
    }

    @Provides
    @PersonsScope
    DeletePersonUseCase providesDeletePersonUseCase(final PersonsRepository personsRepository) {
        return new DeletePersonUseCase(personsRepository);
    }
}
