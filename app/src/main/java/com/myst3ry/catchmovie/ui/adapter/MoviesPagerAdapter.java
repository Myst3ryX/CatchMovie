package com.myst3ry.catchmovie.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.myst3ry.catchmovie.model.Movie;
import com.myst3ry.catchmovie.ui.fragment.MoviesFragment;

public class MoviesPagerAdapter extends FragmentPagerAdapter {

    private final String[] moviesSections;
    private final int[] moviesTypes = {Movie.RECENT, Movie.WATCH, Movie.FAVORITE};

    public MoviesPagerAdapter(FragmentManager fm, String[] sections) {
        super(fm);
        this.moviesSections = sections;
    }

    @Override
    public Fragment getItem(int position) {
        return MoviesFragment.newInstance(moviesTypes[position]);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return moviesSections[position];
    }

    @Override
    public int getCount() {
        return moviesSections.length;
    }


}