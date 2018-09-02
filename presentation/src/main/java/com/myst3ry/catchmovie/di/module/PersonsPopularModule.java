package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.ui.person.presenter.PersonsPopularPresenter;
import com.myst3ry.domain.repository.PersonsRepository;
import com.myst3ry.domain.usecase.person.GetPopularPersonsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class PersonsPopularModule {

    @Provides
    @PersonsScope
    PersonsPopularPresenter providesPersonsPopularPresenter(final GetPopularPersonsUseCase getPopularPersonsUseCase) {
        return new PersonsPopularPresenter(getPopularPersonsUseCase);
    }

    @Provides
    @PersonsScope
    GetPopularPersonsUseCase providesGetPopularPersonsUseCase(final PersonsRepository personsRepository) {
        return new GetPopularPersonsUseCase(personsRepository);
    }
}
