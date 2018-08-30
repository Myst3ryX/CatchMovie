package com.myst3ry.catchmovie.di.component;

import com.myst3ry.catchmovie.di.module.TvShowDetailModule;
import com.myst3ry.catchmovie.di.module.TvShowsModule;
import com.myst3ry.catchmovie.di.module.TvShowsPopularModule;
import com.myst3ry.catchmovie.di.module.TvShowsSearchModule;
import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.ui.tvshow.fragment.TvShowDetailFragment;
import com.myst3ry.catchmovie.ui.tvshow.fragment.TvShowsFragment;
import com.myst3ry.catchmovie.ui.tvshow.fragment.TvShowsPopularFragment;
import com.myst3ry.catchmovie.ui.tvshow.fragment.TvShowsSearchFragment;

import dagger.Subcomponent;

@TvShowsScope
@Subcomponent(modules = {TvShowsModule.class, TvShowDetailModule.class, TvShowsSearchModule.class, TvShowsPopularModule.class})
public interface TvShowsSubComponent {

    void inject(final TvShowsFragment tvShowsFragment);

    void inject(final TvShowDetailFragment tvShowDetailFragment);

    void inject(final TvShowsSearchFragment tvShowsSearchFragment);

    void inject(final TvShowsPopularFragment tvShowsPopularFragment);
}
