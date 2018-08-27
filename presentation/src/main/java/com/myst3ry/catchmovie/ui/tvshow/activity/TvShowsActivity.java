package com.myst3ry.catchmovie.ui.tvshow.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.listener.OnTvShowClickListener;
import com.myst3ry.catchmovie.ui.base.NavigationBaseActivity;
import com.myst3ry.catchmovie.ui.tvshow.adapter.TvShowsPagerAdapter;

import butterknife.BindView;

public final class TvShowsActivity extends NavigationBaseActivity implements OnTvShowClickListener {

    @BindView(R.id.view_pager)
    ViewPager mTvShowsViewPager;
    @BindView(R.id.tab_layout)
    TabLayout mTvShowsTabLayout;
    @BindView(R.id.fab_find_tv_show)
    FloatingActionButton mFloatingButtonFindTvShow;

    public static Intent newIntent(final Context context) {
        return new Intent(context, TvShowsActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_shows);
        super.setupDrawer();
        initViewPager();
        setFabListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.app_title_tv_shows);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                getNavigator().navigateToSettingsScreen(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initViewPager() {
        mTvShowsViewPager.setAdapter(new TvShowsPagerAdapter(getSupportFragmentManager(),
                getResources().getStringArray(R.array.tv_shows_sections)));
        mTvShowsTabLayout.setupWithViewPager(mTvShowsViewPager);
    }

    private void setFabListener() {
        mFloatingButtonFindTvShow.setOnClickListener(v -> getNavigator().navigateToTvShowFindScreen(this));
    }

    @Override
    public void onTvShowClick(int tvShowId) {
        getNavigator().navigateToTvShowDetailScreen(this, tvShowId);
    }
}
