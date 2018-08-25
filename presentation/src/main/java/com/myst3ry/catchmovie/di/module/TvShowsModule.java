package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.model.mapper.TvShowDataModelMapper;
import com.myst3ry.catchmovie.ui.tvshow.presenter.TvShowsPresenter;
import com.myst3ry.domain.repository.TvShowsRepository;
import com.myst3ry.domain.usecase.tvshow.AddTvShowUseCase;
import com.myst3ry.domain.usecase.tvshow.DeleteTvShowUseCase;
import com.myst3ry.domain.usecase.tvshow.GetTvShowsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class TvShowsModule {

    @Provides
    @TvShowsScope
    TvShowsPresenter providesTvShowsPresenter(final TvShowDataModelMapper mapper,
                                              final GetTvShowsUseCase getTvShowsUseCase,
                                              final AddTvShowUseCase addTvShowUseCase,
                                              final DeleteTvShowUseCase deleteTvShowUseCase) {
        return new TvShowsPresenter(mapper, getTvShowsUseCase, addTvShowUseCase, deleteTvShowUseCase);
    }

    @Provides
    @TvShowsScope
    TvShowDataModelMapper providesTvShowDataModelMapper() {
        return new TvShowDataModelMapper();
    }

    @Provides
    @TvShowsScope
    GetTvShowsUseCase providesGetFavoriteTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        return new GetTvShowsUseCase(tvShowsRepository);
    }

    @Provides
    @TvShowsScope
    AddTvShowUseCase providesAddTvShowToFavoritesUseCase(final TvShowsRepository tvShowsRepository) {
        return new AddTvShowUseCase(tvShowsRepository);
    }

    @Provides
    @TvShowsScope
    DeleteTvShowUseCase providesDeleteFavoriteTvShowUseCase(final TvShowsRepository tvShowsRepository) {
        return new DeleteTvShowUseCase(tvShowsRepository);
    }
}