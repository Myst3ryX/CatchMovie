package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.model.mapper.PersonDataModelMapper;
import com.myst3ry.catchmovie.ui.person.presenter.PersonDetailPresenter;
import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.repository.PersonsRepository;
import com.myst3ry.domain.repository.TvShowsRepository;
import com.myst3ry.domain.usecase.person.AddPersonToFavoritesUseCase;
import com.myst3ry.domain.usecase.person.DeleteFavoritePersonUseCase;
import com.myst3ry.domain.usecase.person.GetPersonDetailsUseCase;
import com.myst3ry.domain.usecase.person.GetPersonMoviesCreditsUseCase;
import com.myst3ry.domain.usecase.person.GetPersonTvShowsCreditsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class PersonDetailModule {

    @Provides
    @PersonsScope
    PersonDetailPresenter providesPersonDetailPresenter(final PersonDataModelMapper mapper,
                                                        final GetPersonDetailsUseCase getPersonDetailsUseCase,
                                                        final GetPersonMoviesCreditsUseCase getPersonMoviesCreditsUseCase,
                                                        final GetPersonTvShowsCreditsUseCase getPersonTvShowsCreditsUseCase,
                                                        final AddPersonToFavoritesUseCase addPersonToFavoritesUseCase,
                                                        final DeleteFavoritePersonUseCase deleteFavoritePersonUseCase) {
        return new PersonDetailPresenter(mapper, getPersonDetailsUseCase, getPersonMoviesCreditsUseCase,
                getPersonTvShowsCreditsUseCase, addPersonToFavoritesUseCase, deleteFavoritePersonUseCase);
    }

    @Provides
    @PersonsScope
    GetPersonDetailsUseCase providesPersonDetailInteractor(final PersonsRepository personsRepository) {
        return new GetPersonDetailsUseCase(personsRepository);
    }

    @Provides
    @PersonsScope
    GetPersonMoviesCreditsUseCase providesGetPersonMoviesCreditsUseCase(final MoviesRepository moviesRepository) {
        return new GetPersonMoviesCreditsUseCase(moviesRepository);
    }

    @Provides
    @PersonsScope
    GetPersonTvShowsCreditsUseCase providesGetPersonTvShowsCreditsUseCase(final TvShowsRepository tvShowsRepository) {
        return new GetPersonTvShowsCreditsUseCase(tvShowsRepository);
    }
}
