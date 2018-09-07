package com.myst3ry.catchmovie.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.myst3ry.data.local.database.CMDatabase;
import com.myst3ry.data.local.database.dao.MoviesDAO;
import com.myst3ry.data.local.database.dao.PersonsDAO;
import com.myst3ry.data.local.database.dao.TvShowsDAO;
import com.myst3ry.data.remote.api.ApiMapper;
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
    MoviesRepository providesMoviesRepository(final MoviesDAO moviesDAO, final ApiMapper apiMapper) {
        return new MoviesRepositoryImpl(moviesDAO, apiMapper);
    }

    @Provides
    @Singleton
    TvShowsRepository providesTvShowsRepository(final TvShowsDAO tvShowsDAO, final ApiMapper apiMapper) {
        return new TvShowsRepositoryImpl(tvShowsDAO, apiMapper);
    }

    @Provides
    @Singleton
    PersonsRepository providesPersonsRepository(final PersonsDAO personsDAO, final ApiMapper apiMapper) {
        return new PersonsRepositoryImpl(personsDAO, apiMapper);
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
    CMDatabase providesDatabase(final Application app) {
        return Room.databaseBuilder(app, CMDatabase.class, "catch_movie_db").build();
    }
}
