package com.myst3ry.catchmovie;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.myst3ry.catchmovie.di.component.AppComponent;
import com.myst3ry.catchmovie.di.component.DaggerAppComponent;
import com.myst3ry.catchmovie.di.module.AppModule;
import com.myst3ry.data.local.database.CMDatabase;

public final class CatchMovieApp extends Application {

    private AppComponent mAppComponent;
    private CMDatabase mCMDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
        initDatabase();
    }

    private void initAppComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    private void initDatabase() {
        mCMDatabase = Room.databaseBuilder(this, CMDatabase.class, "catch_movie_db").build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public CMDatabase getDatabase() {
        return mCMDatabase;
    }
}
