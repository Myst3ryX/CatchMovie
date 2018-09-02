package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.ui.tvshow.presenter.TvShowsSearchPresenter;
import com.myst3ry.domain.repository.TvShowsRepository;
import com.myst3ry.domain.usecase.tvshow.SearchTvShowsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class TvShowsSearchModule {

    @Provides
    @TvShowsScope
    TvShowsSearchPresenter providesTvShowsSearchPresenter(final SearchTvShowsUseCase searchTvShowsUseCase) {
        return new TvShowsSearchPresenter(searchTvShowsUseCase);
    }

    @Provides
    @TvShowsScope
    SearchTvShowsUseCase providesSearchTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        return new SearchTvShowsUseCase(tvShowsRepository);
    }
}
