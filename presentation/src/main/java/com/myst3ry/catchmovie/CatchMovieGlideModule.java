package com.myst3ry.catchmovie;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/*
 * Ensures that Glide's generated API is created
 */

@GlideModule
public final class CatchMovieGlideModule extends AppGlideModule {

    public static final int CROSS_FADE_DURATION = 400;

    @Inject
    OkHttpClient okHttpClient;

    //replace default networking logic to okhttp logic
    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        ((CatchMovieApp) context.getApplicationContext()).getAppComponent().inject(this);
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(okHttpClient));
    }
}
