package com.myst3ry.catchmovie.di.module;

import android.app.Application;
import android.content.Context;

import com.myst3ry.catchmovie.navigation.Navigator;
import com.myst3ry.data.repository.MoviesRepositoryImpl;
import com.myst3ry.data.repository.PersonsRepositoryImpl;
import com.myst3ry.data.repository.TvShowsRepositoryImpl;
import com.myst3ry.data.repository.datasource.LocalDataSource;
import com.myst3ry.data.repository.datasource.RemoteDataSource;
import com.myst3ry.domain.repository.MoviesRepository;
import com.myst3ry.domain.repository.PersonsRepository;
import com.myst3ry.domain.repository.TvShowsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class AppModule {

    private final Application mApplication;

    public AppModule(final Application application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    Context providesAppContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    Navigator providesNavigator() {
        return new Navigator();
    }

    @Provides
    @Singleton
    MoviesRepository providesMoviesRepository(final LocalDataSource localDataSource,
                                              final RemoteDataSource remoteDataSource) {
        return new MoviesRepositoryImpl(localDataSource, remoteDataSource);
    }

    @Provides
    @Singleton
    TvShowsRepository providesTvShowsRepository(final LocalDataSource localDataSource,
                                                final RemoteDataSource remoteDataSource) {
        return new TvShowsRepositoryImpl(localDataSource, remoteDataSource);
    }

    @Provides
    @Singleton
    PersonsRepository providesPersonsRepository(final LocalDataSource localDataSource,
                                                final RemoteDataSource remoteDataSource) {
        return new PersonsRepositoryImpl(localDataSource, remoteDataSource);
    }

    @Provides
    @Singleton
    LocalDataSource providesLocalDataSource() {
        return new LocalDataSource();
    }

    @Provides
    @Singleton
    RemoteDataSource providesRemoteDataSource() {
        return new RemoteDataSource();
    }
}
