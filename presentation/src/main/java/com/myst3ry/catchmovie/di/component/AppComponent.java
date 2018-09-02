package com.myst3ry.catchmovie.di.component;

import com.myst3ry.catchmovie.CatchMovieGlideModule;
import com.myst3ry.catchmovie.di.module.AppModule;
import com.myst3ry.catchmovie.di.module.DataModule;
import com.myst3ry.catchmovie.di.module.NetworkModule;
import com.myst3ry.catchmovie.ui.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(final BaseActivity baseActivity);

    void inject(final CatchMovieGlideModule catchMovieGlideModule);

    MoviesSubComponent getMoviesSubComponent();

    TvShowsSubComponent getTvShowsSubComponent();

    PersonsSubComponent getPersonsSubComponent();
}
