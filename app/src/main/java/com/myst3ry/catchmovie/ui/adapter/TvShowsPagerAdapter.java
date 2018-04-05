package com.myst3ry.catchmovie.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.myst3ry.catchmovie.model.TvShow;
import com.myst3ry.catchmovie.ui.fragment.TvShowsFragment;

public class TvShowsPagerAdapter extends FragmentPagerAdapter {

    private final String[] tvShowsSections;
    private final int[] tvShowsTypes = {TvShow.RECENT, TvShow.WATCH, TvShow.FAVORITE};

    public TvShowsPagerAdapter(FragmentManager fm, String[] sections) {
        super(fm);
        this.tvShowsSections = sections;
    }

    @Override
    public Fragment getItem(int position) {
        return TvShowsFragment.newInstance(tvShowsTypes[position]);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tvShowsSections[position];
    }

    @Override
    public int getCount() {
        return tvShowsSections.length;
    }
}