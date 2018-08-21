package com.myst3ry.catchmovie.ui.activity.tvshow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.ui.activity.NavDrawerBaseActivity;
import com.myst3ry.catchmovie.ui.adapter.pager.TvShowsPagerAdapter;

import butterknife.BindView;

public final class TvShowsActivity extends NavDrawerBaseActivity {

    @BindView(R.id.view_pager)
    ViewPager mTvShowsViewPager;
    @BindView(R.id.tab_layout)
    TabLayout mTvShowsTabLayout;

    public static Intent newIntent(final Context context) {
        return new Intent(context, TvShowsActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_shows);
        super.setupDrawer();

        initViewPager();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.app_title_tv_shows);
    }

    private void initViewPager() {
        mTvShowsViewPager.setAdapter(new TvShowsPagerAdapter(getSupportFragmentManager(),
                getResources().getStringArray(R.array.tv_shows_sections)));
        mTvShowsTabLayout.setupWithViewPager(mTvShowsViewPager);
    }
}
