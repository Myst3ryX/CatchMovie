package com.myst3ry.catchmovie.ui.person.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.myst3ry.catchmovie.BuildConfig;
import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.listener.OnMovieClickListener;
import com.myst3ry.catchmovie.listener.OnTvShowClickListener;
import com.myst3ry.catchmovie.ui.base.BaseActivity;
import com.myst3ry.catchmovie.ui.person.fragment.PersonDetailFragment;

public final class PersonDetailActivity extends BaseActivity implements OnMovieClickListener, OnTvShowClickListener {

    public static final String EXTRA_PERSON_ID = BuildConfig.APPLICATION_ID + "EXTRA.PERSON_ID";

    public static Intent newIntent(final Context context) {
        return new Intent(context, PersonDetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);
        prepareActionBar();

        if (savedInstanceState == null) {
            if (getIntent() != null) {
                initUI(getIntent().getIntExtra(EXTRA_PERSON_ID, 0));
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle("");
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

    private void initUI(final int personId) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_person_detail, PersonDetailFragment.newInstance(personId), PersonDetailFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    private void prepareActionBar() {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onMovieClick(final int movieId) {
        getNavigator().navigateToMovieDetailScreen(this, movieId);
    }

    @Override
    public void onTvShowClick(final int tvShowId) {
        getNavigator().navigateToTvShowDetailScreen(this, tvShowId);
    }
}

