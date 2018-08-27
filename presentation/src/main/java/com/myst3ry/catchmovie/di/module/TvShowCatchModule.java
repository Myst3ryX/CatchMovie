package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.ui.tvshow.presenter.TvShowCatchPresenter;
import com.myst3ry.domain.repository.TvShowsRepository;
import com.myst3ry.domain.usecase.tvshow.CatchTvShowUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class TvShowCatchModule {

    @Provides
    @TvShowsScope
    TvShowCatchPresenter providesTvShowCatchPresenter(final CatchTvShowUseCase catchTvShowUseCase) {
        return new TvShowCatchPresenter(catchTvShowUseCase);
    }

    @Provides
    @TvShowsScope
    CatchTvShowUseCase providesCatchTvShowUseCase(final TvShowsRepository tvShowsRepository) {
        return new CatchTvShowUseCase(tvShowsRepository);
    }
}
