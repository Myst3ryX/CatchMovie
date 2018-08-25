package com.myst3ry.catchmovie.di.component;

import com.myst3ry.catchmovie.di.module.MovieDetailModule;
import com.myst3ry.catchmovie.di.module.MovieSearchModule;
import com.myst3ry.catchmovie.di.module.MoviesModule;
import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.ui.movie.fragment.MovieCatchFragment;
import com.myst3ry.catchmovie.ui.movie.fragment.MovieDetailFragment;
import com.myst3ry.catchmovie.ui.movie.fragment.MovieSearchFragment;
import com.myst3ry.catchmovie.ui.movie.fragment.MoviesFragment;

import dagger.Subcomponent;

@MoviesScope
@Subcomponent(modules = {MoviesModule.class, MovieDetailModule.class, MovieSearchModule.class})
public interface MoviesSubComponent {

    void inject(final MoviesFragment moviesFragment);

    void inject(final MovieDetailFragment movieDetailFragment);

    void inject(final MovieSearchFragment movieSearchFragment);

    void inject(final MovieCatchFragment movieCatchFragment);
}
