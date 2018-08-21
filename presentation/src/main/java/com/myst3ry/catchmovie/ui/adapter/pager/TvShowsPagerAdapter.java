package com.myst3ry.catchmovie.ui.adapter.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.myst3ry.catchmovie.ui.fragment.TvShowsFragment;
import com.myst3ry.domain.model.types.TvShowType;

public final class TvShowsPagerAdapter extends FragmentPagerAdapter {

    private final String[] mTvShowsSections;

    public TvShowsPagerAdapter(final FragmentManager fragmentManager, final String[] sections) {
        super(fragmentManager);
        this.mTvShowsSections = sections;
    }

    @Override
    public Fragment getItem(final int position) {
        return TvShowsFragment.newInstance(TvShowType.getValues()[position].getType());
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