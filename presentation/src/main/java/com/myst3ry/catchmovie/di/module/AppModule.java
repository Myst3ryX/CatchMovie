package com.myst3ry.catchmovie.di.module;

import android.app.Application;

import com.myst3ry.catchmovie.navigation.Navigator;

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
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Navigator providesNavigator() {
        return new Navigator();
    }
}
