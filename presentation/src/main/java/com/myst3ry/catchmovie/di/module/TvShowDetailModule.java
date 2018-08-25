package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.model.mapper.TvShowDataModelMapper;
import com.myst3ry.catchmovie.ui.tvshow.presenter.TvShowDetailPresenter;
import com.myst3ry.domain.repository.TvShowsRepository;
import com.myst3ry.domain.usecase.tvshow.AddTvShowUseCase;
import com.myst3ry.domain.usecase.tvshow.DeleteTvShowUseCase;
import com.myst3ry.domain.usecase.tvshow.GetTvShowCreditsUseCase;
import com.myst3ry.domain.usecase.tvshow.GetTvShowDetailsUseCase;
import com.myst3ry.domain.usecase.tvshow.GetTvShowPostersUseCase;
import com.myst3ry.domain.usecase.tvshow.SetTvShowRatingUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class TvShowDetailModule {

    @Provides
    @TvShowsScope
    TvShowDetailPresenter providesTvShowDetailPresenter(final TvShowDataModelMapper mapper,
                                                        final GetTvShowDetailsUseCase getTvShowDetailsUseCase,
                                                        final GetTvShowCreditsUseCase getTvShowCreditsUseCase,
                                                        final GetTvShowPostersUseCase getTvShowPostersUseCase,
                                                        final SetTvShowRatingUseCase setTvShowRatingUseCase,
                                                        final AddTvShowUseCase addTvShowUseCase,
                                                        final DeleteTvShowUseCase deleteTvShowUseCase) {
        return new TvShowDetailPresenter(mapper, getTvShowDetailsUseCase, getTvShowCreditsUseCase,
                getTvShowPostersUseCase, setTvShowRatingUseCase, addTvShowUseCase, deleteTvShowUseCase);
    }

    @Provides
    @TvShowsScope
    GetTvShowDetailsUseCase providesGetTvShowDetailsUseCase(final TvShowsRepository moviesRepository) {
        return new GetTvShowDetailsUseCase(moviesRepository);
    }

    @Provides
    @TvShowsScope
    GetTvShowCreditsUseCase providesGetTvShowCreditsUseCase(final TvShowsRepository moviesRepository) {
        return new GetTvShowCreditsUseCase(moviesRepository);
    }

    @Provides
    @TvShowsScope
    GetTvShowPostersUseCase providesGetTvShowPostersUseCase(final TvShowsRepository moviesRepository) {
        return new GetTvShowPostersUseCase(moviesRepository);
    }

    @Provides
    @TvShowsScope
    SetTvShowRatingUseCase providesSetTvShowRatingUseCase(final TvShowsRepository tvShowsRepository) {
        return new SetTvShowRatingUseCase(tvShowsRepository);
    }
}
