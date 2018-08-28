package com.myst3ry.catchmovie.ui.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import com.myst3ry.catchmovie.BuildConfig;
import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.ui.base.BaseActivity;
import com.myst3ry.catchmovie.ui.movie.fragment.MovieDetailFragment;

public final class MovieDetailActivity extends BaseActivity {

    public static final String EXTRA_MOVIE_ID = BuildConfig.APPLICATION_ID + "EXTRA.MOVIE_ID";

    public static Intent newIntent(final Context context) {
        return new Intent(context, MovieDetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        prepareActionBar();
        if (savedInstanceState == null) {
            initUI();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initUI() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_movie_detail, MovieDetailFragment.newInstance(), MovieDetailFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    private void prepareActionBar() {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}

