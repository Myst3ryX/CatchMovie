package com.myst3ry.catchmovie.ui.activity.movie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.ui.activity.NavDrawerBaseActivity;
import com.myst3ry.catchmovie.ui.adapter.pager.MoviesPagerAdapter;

import butterknife.BindView;

public final class MoviesActivity extends NavDrawerBaseActivity {

    @BindView(R.id.view_pager)
    ViewPager mMoviesViewPager;
    @BindView(R.id.tab_layout)
    TabLayout mMoviesTabLayout;

    public static Intent newIntent(final Context context) {
        return new Intent(context, MoviesActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        super.setupDrawer();

        initViewPager();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.app_title_movies);
    }

    private void initViewPager() {
        mMoviesViewPager.setAdapter(new MoviesPagerAdapter(getSupportFragmentManager(),
                getResources().getStringArray(R.array.movies_sections)));
        mMoviesTabLayout.setupWithViewPager(mMoviesViewPager);
    }
}
