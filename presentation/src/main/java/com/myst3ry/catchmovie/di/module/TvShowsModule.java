package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
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
    TvShowsPresenter providesTvShowsPresenter(final GetTvShowsUseCase getTvShowsUseCase,
                                              final AddTvShowUseCase addTvShowUseCase,
                                              final DeleteTvShowUseCase deleteTvShowUseCase) {
        return new TvShowsPresenter(getTvShowsUseCase, addTvShowUseCase, deleteTvShowUseCase);
    }

    @Provides
    @TvShowsScope
    GetTvShowsUseCase providesGetTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        return new GetTvShowsUseCase(tvShowsRepository);
    }

    @Provides
    @TvShowsScope
    AddTvShowUseCase providesAddTvShowUseCase(final TvShowsRepository tvShowsRepository) {
        return new AddTvShowUseCase(tvShowsRepository);
    }

    @Provides
    @TvShowsScope
    DeleteTvShowUseCase providesDeleteTvShowUseCase(final TvShowsRepository tvShowsRepository) {
        return new DeleteTvShowUseCase(tvShowsRepository);
    }
}
