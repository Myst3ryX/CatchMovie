package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.ui.person.presenter.PersonDetailPresenter;
import com.myst3ry.domain.repository.PersonsRepository;
import com.myst3ry.domain.usecase.person.AddPersonUseCase;
import com.myst3ry.domain.usecase.person.DeletePersonUseCase;
import com.myst3ry.domain.usecase.person.GetPersonDetailsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class PersonDetailModule {

    @Provides
    @PersonsScope
    PersonDetailPresenter providesPersonDetailPresenter(final GetPersonDetailsUseCase getPersonDetailsUseCase,
                                                        final AddPersonUseCase addPersonUseCase,
                                                        final DeletePersonUseCase deletePersonUseCase) {
        return new PersonDetailPresenter(getPersonDetailsUseCase, addPersonUseCase, deletePersonUseCase);
    }

    @Provides
    @PersonsScope
    GetPersonDetailsUseCase providesGetPersonDetailsUseCase(final PersonsRepository personsRepository) {
        return new GetPersonDetailsUseCase(personsRepository);
    }
}
