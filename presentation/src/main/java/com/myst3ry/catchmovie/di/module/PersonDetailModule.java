package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.ui.person.presenter.PersonDetailPresenter;
import com.myst3ry.domain.repository.PersonsRepository;
import com.myst3ry.domain.usecase.person.AddPersonToFavoritesUseCase;
import com.myst3ry.domain.usecase.person.DeleteFavoritePersonUseCase;
import com.myst3ry.domain.usecase.person.GetPersonDetailsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class PersonDetailModule {

    @Provides
    @PersonsScope
    PersonDetailPresenter providesPersonDetailPresenter(final GetPersonDetailsUseCase getPersonDetailsUseCase,
                                                        final AddPersonToFavoritesUseCase addPersonToFavoritesUseCase,
                                                        final DeleteFavoritePersonUseCase deleteFavoritePersonUseCase) {
        return new PersonDetailPresenter(getPersonDetailsUseCase, addPersonToFavoritesUseCase, deleteFavoritePersonUseCase);
    }

    @Provides
    @PersonsScope
    GetPersonDetailsUseCase providesPersonDetailInteractor(final PersonsRepository personsRepository) {
        return new GetPersonDetailsUseCase(personsRepository);
    }
}
