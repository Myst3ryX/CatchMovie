package com.myst3ry.catchmovie.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.ui.fragment.CatchingHistoryFragment;
import com.myst3ry.catchmovie.ui.fragment.FavoritesFragment;
import com.myst3ry.catchmovie.ui.fragment.WatchlistFragment;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        final ViewPager moviesPager = (ViewPager) findViewById(R.id.movies_pager);
        moviesPager.setAdapter(new MoviesPagerAdapter(getSupportFragmentManager()));

        final TabLayout moviesTabs = (TabLayout) findViewById(R.id.movies_tabs);
        moviesTabs.setupWithViewPager(moviesPager);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    private class MoviesPagerAdapter extends FragmentPagerAdapter {
        private final String[] moviesTabSections;

        MoviesPagerAdapter(FragmentManager fm) {
            super(fm);
            moviesTabSections = getResources().getStringArray(R.array.movies_tab_sections);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CatchingHistoryFragment();
                case 1:
                    return new WatchlistFragment();
                case 2:
                    return new FavoritesFragment();
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return moviesTabSections[position];
        }

        @Override
        public int getCount() {
            return moviesTabSections.length;
        }
    }
}
