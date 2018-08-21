package com.myst3ry.catchmovie.ui.activity.movie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.model.MovieDataModel;
import com.myst3ry.catchmovie.ui.activity.BaseDetailActivity;
import com.myst3ry.catchmovie.ui.view.MovieDetailView;

public final class MovieDetailActivity extends BaseDetailActivity implements MovieDetailView {

    public static Intent newIntent(final Context context) {
        return new Intent(context, MovieDetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
    }

    @Override
    public void setMovieDetails(final MovieDataModel movie) {
        //todo implement
    }
}

