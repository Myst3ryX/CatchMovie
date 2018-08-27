package com.myst3ry.catchmovie.di.module;

import com.myst3ry.catchmovie.CatchMovieApp;
import com.myst3ry.data.local.database.CMDatabase;
import com.myst3ry.data.local.database.dao.MoviesDAO;
import com.myst3ry.data.local.database.dao.PersonsDAO;
import com.myst3ry.data.local.database.dao.TvShowsDAO;
import com.myst3ry.data.repository.MoviesRepositoryImpl;
import com.myst3ry.data.repository.PersonsRepositoryImpl;
import com.myst3ry.data.repository.TvShowsRepositoryImpl;
import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.repository.PersonsRepository;
import com.myst3ry.domain.repository.TvShowsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class DataModule {

    @Provides
    @Singleton
    MoviesRepository providesMoviesRepository(final MoviesDAO moviesDAO) {
        return new MoviesRepositoryImpl(moviesDAO);
    }

    @Provides
    @Singleton
    TvShowsRepository providesTvShowsRepository(final TvShowsDAO tvShowsDAO) {
        return new TvShowsRepositoryImpl(tvShowsDAO);
    }

    @Provides
    @Singleton
    PersonsRepository providesPersonsRepository(final PersonsDAO personsDAO) {
        return new PersonsRepositoryImpl(personsDAO);
    }

    @Provides
    @Singleton
    MoviesDAO providesMoviesDao(final CMDatabase database) {
        return database.getMoviesDao();
    }

    @Provides
    @Singleton
    TvShowsDAO providesTvShowsDao(final CMDatabase database) {
        return database.getTvShowsDao();
    }

    @Provides
    @Singleton
    PersonsDAO providesPersonsDao(final CMDatabase database) {
        return database.getPersonsDao();
    }

    @Provides
    @Singleton
    CMDatabase providesDatabase(final CatchMovieApp app) {
        return app.getDatabase();
    }
}
