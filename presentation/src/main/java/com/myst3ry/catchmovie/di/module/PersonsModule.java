package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.ui.person.presenter.PersonsPresenter;
import com.myst3ry.domain.repository.PersonsRepository;
import com.myst3ry.domain.usecase.person.AddPersonToFavoritesUseCase;
import com.myst3ry.domain.usecase.person.DeleteFavoritePersonUseCase;
import com.myst3ry.domain.usecase.person.GetFavoritePersonsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class PersonsModule {

    @Provides
    @PersonsScope
    PersonsPresenter providesPersonsPresenter(final GetFavoritePersonsUseCase getFavoritePersonsUseCase,
                                              final AddPersonToFavoritesUseCase addPersonToFavoritesUseCase,
                                              final DeleteFavoritePersonUseCase deleteFavoritePersonUseCase) {
        return new PersonsPresenter(getFavoritePersonsUseCase, addPersonToFavoritesUseCase, deleteFavoritePersonUseCase);
    }

    @Provides
    @PersonsScope
    GetFavoritePersonsUseCase providesGetFavoritePersonsUseCase(final PersonsRepository personsRepository) {
        return new GetFavoritePersonsUseCase(personsRepository);
    }

    @Provides
    @PersonsScope
    AddPersonToFavoritesUseCase providesAddPersonToFavoritesUseCase(final PersonsRepository personsRepository) {
        return new AddPersonToFavoritesUseCase(personsRepository);
    }

    @Provides
    @PersonsScope
    DeleteFavoritePersonUseCase providesDeleteFavoritePersonUseCase(final PersonsRepository personsRepository) {
        return new DeleteFavoritePersonUseCase(personsRepository);
    }
}
