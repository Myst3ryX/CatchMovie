package com.myst3ry.catchmovie.di.component;

import com.myst3ry.catchmovie.di.module.TvShowDetailModule;
import com.myst3ry.catchmovie.di.module.TvShowSearchModule;
import com.myst3ry.catchmovie.di.module.TvShowsModule;
import com.myst3ry.catchmovie.di.scope.TvShowsScope;
import com.myst3ry.catchmovie.ui.tvshow.fragment.TvShowCatchFragment;
import com.myst3ry.catchmovie.ui.tvshow.fragment.TvShowDetailFragment;
import com.myst3ry.catchmovie.ui.tvshow.fragment.TvShowSearchFragment;
import com.myst3ry.catchmovie.ui.tvshow.fragment.TvShowsFragment;

import dagger.Subcomponent;

@TvShowsScope
@Subcomponent(modules = {TvShowsModule.class, TvShowDetailModule.class, TvShowSearchModule.class})
public interface TvShowsSubComponent {

    void inject(final TvShowsFragment tvShowsFragment);

    void inject(final TvShowDetailFragment tvShowDetailFragment);

    void inject(final TvShowSearchFragment tvShowSearchFragment);

    void inject(final TvShowCatchFragment tvShowCatchFragment);
}
