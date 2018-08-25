package com.myst3ry.catchmovie.di.component;

import com.myst3ry.catchmovie.di.module.AppModule;
import com.myst3ry.catchmovie.ui.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(final BaseActivity baseActivity);

    MoviesSubComponent getMoviesSubComponent();

    TvShowsSubComponent getTvShowsSubComponent();

    PersonsSubComponent getPersonsSubComponent();
}
