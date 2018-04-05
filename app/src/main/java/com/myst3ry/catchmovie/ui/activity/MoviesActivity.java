package com.myst3ry.catchmovie.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.ui.adapter.MoviesPagerAdapter;

import butterknife.BindString;
import butterknife.BindView;

public class MoviesActivity extends NavDrawerBaseActivity {

    private static int navItemSelected;

    @BindString(R.string.bar_movies_title)
    String moviesTitle;
    @BindView(R.id.view_pager)
    ViewPager moviesPager;
    @BindView(R.id.tabs)
    TabLayout moviesTabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        setTitle(moviesTitle);
        super.setupDrawer();

        if (savedInstanceState == null) {
            navItemSelected = getIntent().getIntExtra(NAV_ITEM_SELECTED_EXTRA, 0);
        } else {
            navItemSelected = savedInstanceState.getInt(NAV_ITEM_SELECTED);
        }

        moviesPager.setAdapter(new MoviesPagerAdapter(getSupportFragmentManager(),
                getResources().getStringArray(R.array.movies_sections)));
        moviesTabs.setupWithViewPager(moviesPager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getNavigationView().setCheckedItem(navItemSelected);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NAV_ITEM_SELECTED, navItemSelected);
    }
}
