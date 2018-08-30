package com.myst3ry.catchmovie.di.component;

import com.myst3ry.catchmovie.di.module.MovieDetailModule;
import com.myst3ry.catchmovie.di.module.MoviesModule;
import com.myst3ry.catchmovie.di.module.MoviesPopularModule;
import com.myst3ry.catchmovie.di.module.MoviesSearchModule;
import com.myst3ry.catchmovie.di.scope.MoviesScope;
import com.myst3ry.catchmovie.ui.movie.fragment.MovieDetailFragment;
import com.myst3ry.catchmovie.ui.movie.fragment.MoviesFragment;
import com.myst3ry.catchmovie.ui.movie.fragment.MoviesPopularFragment;
import com.myst3ry.catchmovie.ui.movie.fragment.MoviesSearchFragment;

import dagger.Subcomponent;

@MoviesScope
@Subcomponent(modules = {MoviesModule.class, MovieDetailModule.class, MoviesSearchModule.class, MoviesPopularModule.class})
public interface MoviesSubComponent {

    void inject(final MoviesFragment moviesFragment);

    void inject(final MovieDetailFragment movieDetailFragment);

    void inject(final MoviesSearchFragment moviesSearchFragment);

    void inject(final MoviesPopularFragment moviesPopularFragment);
}
