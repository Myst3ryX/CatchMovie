package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.ui.tvshow.presenter.TvShowSearchPresenter;
import com.myst3ry.domain.repository.TvShowsRepository;
import com.myst3ry.domain.usecase.tvshow.SearchTvShowsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class TvShowSearchModule {

    @Provides
    @TvShowsScope
    TvShowSearchPresenter providesTvShowSearchPresenter(final SearchTvShowsUseCase searchTvShowsUseCase) {
        return new TvShowSearchPresenter(searchTvShowsUseCase);
    }

    @Provides
    @TvShowsScope
    SearchTvShowsUseCase providesSearchTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        return new SearchTvShowsUseCase(tvShowsRepository);
    }
}
