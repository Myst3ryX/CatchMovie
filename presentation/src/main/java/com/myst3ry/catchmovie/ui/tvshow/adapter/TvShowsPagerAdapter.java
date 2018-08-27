package com.myst3ry.catchmovie.ui.tvshow.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.myst3ry.catchmovie.ui.tvshow.fragment.TvShowsFragment;
import com.myst3ry.domain.types.TvShowType;

public final class TvShowsPagerAdapter extends FragmentStatePagerAdapter {

    private final String[] mTvShowsSections;

    public TvShowsPagerAdapter(final FragmentManager fragmentManager, final String[] sections) {
        super(fragmentManager);
        this.mTvShowsSections = sections;
    }

    @Override
    public Fragment getItem(final int position) {
        return TvShowsFragment.newInstance(TvShowType.getValues()[position]);
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        return mTvShowsSections[position];
    }

    @Override
    public int getCount() {
        return mTvShowsSections.length;
    }
}