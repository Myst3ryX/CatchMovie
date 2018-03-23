package com.myst3ry.catchmovie.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.ui.adapter.ViewPagerAdapter;

public class TvShowsActivity extends NavDrawerBaseActivity {

    private static int navItemId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_shows);
        super.onCreateDrawer();

        if (savedInstanceState == null) {
            navItemId = getIntent().getIntExtra(NAV_ITEM_ID_EXTRA, 0);
        } else {
            navItemId = savedInstanceState.getInt(NAV_ITEM_ID);
        }

        final ViewPager showsPager = (ViewPager) findViewById(R.id.view_pager);
        showsPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),
                getResources().getStringArray(R.array.pager_sections)));

        final TabLayout moviesTabs = (TabLayout) findViewById(R.id.tabs);
        moviesTabs.setupWithViewPager(showsPager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getNavigationView().setCheckedItem(navItemId);
        getToolbar().setTitle(getString(R.string.bar_tv_shows_title));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NAV_ITEM_ID, navItemId);
    }
}
