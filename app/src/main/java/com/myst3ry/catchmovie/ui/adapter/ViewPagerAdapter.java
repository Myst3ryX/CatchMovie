package com.myst3ry.catchmovie.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.myst3ry.catchmovie.ui.fragment.CatchingHistoryFragment;
import com.myst3ry.catchmovie.ui.fragment.FavoritesFragment;
import com.myst3ry.catchmovie.ui.fragment.WatchlistFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final String[] titles;

    public ViewPagerAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        this.titles = titles;
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
        return titles[position];
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}