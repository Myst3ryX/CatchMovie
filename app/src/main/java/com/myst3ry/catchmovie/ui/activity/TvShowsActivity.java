package com.myst3ry.catchmovie.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.ui.adapter.TvShowsPagerAdapter;

import butterknife.BindString;
import butterknife.BindView;

public class TvShowsActivity extends NavDrawerBaseActivity {

    private static int navItemSelected;

    @BindString(R.string.bar_tv_shows_title)
    String tvShowsTitle;
    @BindView(R.id.view_pager)
    ViewPager tvShowsPager;
    @BindView(R.id.tabs)
    TabLayout tvShowsTabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_shows);
        setTitle(tvShowsTitle);
        super.setupDrawer();

        if (savedInstanceState == null) {
            navItemSelected = getIntent().getIntExtra(NAV_ITEM_SELECTED_EXTRA, 0);
        } else {
            navItemSelected = savedInstanceState.getInt(NAV_ITEM_SELECTED);
        }

        tvShowsPager.setAdapter(new TvShowsPagerAdapter(getSupportFragmentManager(),
                getResources().getStringArray(R.array.tv_shows_sections)));
        tvShowsTabs.setupWithViewPager(tvShowsPager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getNavigationView().setCheckedItem(navItemSelected);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NAV_ITEM_SELECTED, navItemSelected);
    }
}
