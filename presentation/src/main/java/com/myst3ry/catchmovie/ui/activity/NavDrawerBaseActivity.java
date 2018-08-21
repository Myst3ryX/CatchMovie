package com.myst3ry.catchmovie.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.ui.activity.actor.ActorsActivity;
import com.myst3ry.catchmovie.ui.activity.movie.MoviesActivity;
import com.myst3ry.catchmovie.ui.activity.tvshow.TvShowsActivity;
import com.myst3ry.catchmovie.utils.Utils;

import butterknife.BindView;
import icepick.State;

public abstract class NavDrawerBaseActivity extends BaseActivity {

    private static final int NAV_CLOSE_DELAY = 250;

    @BindView(R.id.nav_view_main)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_main)
    DrawerLayout mDrawer;

    @State
    int mNavItemSelected;

    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler(getMainLooper());

        //if (savedInstanceState == null) {
        //    mNavItemSelected = getIntent().getIntExtra(IntentConstants.EXTRA_NAV_ITEM_SELECTED, 0);
        //}
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNavigationView.setCheckedItem(mNavItemSelected);
    }

    protected void setupDrawer() {
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer,
                getToolbar(), R.string.nav_drawer_open, R.string.nav_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(item -> {
            NavDrawerBaseActivity.this.onNavItemClick(item.getItemId());
            return false;
        });
    }

    private void onNavItemClick(final int id) {
        switch (id) {
            case R.id.nav_item_movies:
                if (!(this instanceof MoviesActivity)) {
                    mHandler.postDelayed(() -> {
                        getNavigator().navigateToMoviesScreen(this);
                        overridePendingTransition(R.anim.activity_fade_in, R.anim.activity_fade_out);
                    }, NAV_CLOSE_DELAY);
                }
                break;
            case R.id.nav_item_tv_shows:
                if (!(this instanceof TvShowsActivity)) {
                    mHandler.postDelayed(() -> {
                        getNavigator().navigateToTvShowsScreen(this);
                        overridePendingTransition(R.anim.activity_fade_in, R.anim.activity_fade_out);
                    }, NAV_CLOSE_DELAY);
                }
                break;
            case R.id.nav_item_actors:
                if (!(this instanceof ActorsActivity)) {
                    mHandler.postDelayed(() -> {
                        getNavigator().navigateToActorsScreen(this);
                        overridePendingTransition(R.anim.activity_fade_in, R.anim.activity_fade_out);
                    }, NAV_CLOSE_DELAY);
                }
                break;
            case R.id.nav_item_settings:
                getNavigator().navigateToSettingsScreen(this);
                break;
            case R.id.nav_item_contact:
                final String subject = String.format(getString(R.string.mail_subject), Utils.getAppVersionInfo());
                final String body = String.format(getString(R.string.mail_body), Utils.getDeviceInfo(),
                        Utils.getBuildInfo(), Utils.getVersionInfo());
                final String mail = getString(R.string.mail_address);
                getNavigator().navigateToContactScreen(this, subject, body, mail);
                break;
            case R.id.nav_item_rate:
                getNavigator().navigateToMarketAppRating(this);
                break;
            default:
                break;
        }

        //launchIntent.putExtra(IntentConstants.EXTRA_NAV_ITEM_SELECTED, id);
        mDrawer.closeDrawer(Gravity.START);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
