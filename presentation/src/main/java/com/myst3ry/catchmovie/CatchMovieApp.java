package com.myst3ry.catchmovie;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;

import com.myst3ry.catchmovie.di.component.AppComponent;
import com.myst3ry.catchmovie.di.component.DaggerAppComponent;
import com.myst3ry.catchmovie.di.module.AppModule;
import com.myst3ry.catchmovie.utils.TimberReleaseTree;
import com.myst3ry.data.local.database.CMDatabase;

import timber.log.Timber;

public final class CatchMovieApp extends Application {

    private AppComponent mAppComponent;
    private CMDatabase mCMDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
        initDatabase();
        configureTimber();
    }

    private void initAppComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    private void initDatabase() {
        mCMDatabase = Room.databaseBuilder(this, CMDatabase.class, "catch_movie_db").build();
    }

    private void configureTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected String createStackElementTag(@NonNull StackTraceElement element) {
                    return super.createStackElementTag(element) + ":" + element.getLineNumber();
                }
            });
        } else {
            Timber.plant(new TimberReleaseTree());
        }
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public CMDatabase getDatabase() {
        return mCMDatabase;
    }
}
