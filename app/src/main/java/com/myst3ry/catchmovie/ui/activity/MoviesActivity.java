package com.myst3ry.catchmovie.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.ui.adapter.ViewPagerAdapter;

public class MoviesActivity extends NavDrawerBaseActivity {

    private static int navItemId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        super.onCreateDrawer();

        if (savedInstanceState == null) {
            navItemId = getIntent().getIntExtra(NAV_ITEM_ID_EXTRA, 0);
        } else {
            navItemId = savedInstanceState.getInt(NAV_ITEM_ID);
        }

        final ViewPager moviesPager = (ViewPager) findViewById(R.id.view_pager);
        moviesPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),
                getResources().getStringArray(R.array.pager_sections)));

        final TabLayout moviesTabs = (TabLayout) findViewById(R.id.tabs);
        moviesTabs.setupWithViewPager(moviesPager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getNavigationView().setCheckedItem(navItemId);
        getToolbar().setTitle(getString(R.string.bar_movies_title));
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
        outState.putInt(NAV_ITEM_ID, navItemId);
    }
}
