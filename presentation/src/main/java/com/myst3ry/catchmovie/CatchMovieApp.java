package com.myst3ry.catchmovie;

import android.app.Application;

import com.myst3ry.catchmovie.di.component.AppComponent;
import com.myst3ry.catchmovie.di.component.DaggerAppComponent;
import com.myst3ry.catchmovie.di.module.AppModule;

public final class CatchMovieApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
