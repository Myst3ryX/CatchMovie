package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.ui.tvshow.presenter.TvShowsPopularPresenter;
import com.myst3ry.domain.repository.TvShowsRepository;
import com.myst3ry.domain.usecase.tvshow.GetPopularTvShowsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class TvShowsPopularModule {

    @Provides
    @TvShowsScope
    TvShowsPopularPresenter providesPopularTvShowsPresenter(final GetPopularTvShowsUseCase getPopularTvShowsUseCase) {
        return new TvShowsPopularPresenter(getPopularTvShowsUseCase);
    }

    @Provides
    @TvShowsScope
    GetPopularTvShowsUseCase providesGetPopularTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        return new GetPopularTvShowsUseCase(tvShowsRepository);
    }
}
