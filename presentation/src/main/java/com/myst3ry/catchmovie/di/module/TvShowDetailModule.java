package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.ui.tvshow.presenter.TvShowDetailPresenter;
import com.myst3ry.domain.repository.TvShowsRepository;
import com.myst3ry.domain.usecase.tvshow.AddTvShowUseCase;
import com.myst3ry.domain.usecase.tvshow.DeleteTvShowUseCase;
import com.myst3ry.domain.usecase.tvshow.GetTvShowDetailsUseCase;
import com.myst3ry.domain.usecase.tvshow.SetTvShowRatingUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class TvShowDetailModule {

    @Provides
    @TvShowsScope
    TvShowDetailPresenter providesTvShowDetailPresenter(final GetTvShowDetailsUseCase getTvShowDetailsUseCase,
                                                        final SetTvShowRatingUseCase setTvShowRatingUseCase,
                                                        final AddTvShowUseCase addTvShowUseCase,
                                                        final DeleteTvShowUseCase deleteTvShowUseCase) {
        return new TvShowDetailPresenter(getTvShowDetailsUseCase, setTvShowRatingUseCase,
                addTvShowUseCase, deleteTvShowUseCase);
    }

    @Provides
    @TvShowsScope
    GetTvShowDetailsUseCase providesGetTvShowDetailsUseCase(final TvShowsRepository moviesRepository) {
        return new GetTvShowDetailsUseCase(moviesRepository);
    }

    @Provides
    @TvShowsScope
    SetTvShowRatingUseCase providesSetTvShowRatingUseCase(final TvShowsRepository tvShowsRepository) {
        return new SetTvShowRatingUseCase(tvShowsRepository);
    }
}
