package com.myst3ry.catchmovie.ui.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;

import com.myst3ry.catchmovie.DeviceConfigurationHelper;
import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.ui.movie.activity.MoviesActivity;
import com.myst3ry.catchmovie.ui.person.activity.PersonsActivity;
import com.myst3ry.catchmovie.ui.tvshow.activity.TvShowsActivity;

import butterknife.BindView;

/**
 * A abstract NavigationBaseActivity
 *
 * @see BaseActivity
 * @see NavigationView
 * @see DrawerLayout
 */
public abstract class NavigationBaseActivity extends BaseActivity {

    private static final int NAV_CLOSE_DELAY = 275;

    @BindView(R.id.nav_view_main)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_main)
    DrawerLayout mDrawer;

    private static int mNavItemSelected;
    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler(getMainLooper());
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
            NavigationBaseActivity.this.onNavItemClick(item.getItemId());
            return true;
        });
    }

    private void onNavItemClick(final int id) {
        switch (id) {
            case R.id.nav_item_movies:
                if (!(this instanceof MoviesActivity)) {
                    mNavItemSelected = id;
                    mHandler.postDelayed(() -> {
                        getNavigator().navigateToMoviesScreen(this);
                        overridePendingTransition(R.anim.activity_fade_in, R.anim.activity_fade_out);
                    }, NAV_CLOSE_DELAY);
                }
                break;
            case R.id.nav_item_tv_shows:
                if (!(this instanceof TvShowsActivity)) {
                    mNavItemSelected = id;
                    mHandler.postDelayed(() -> {
                        getNavigator().navigateToTvShowsScreen(this);
                        overridePendingTransition(R.anim.activity_fade_in, R.anim.activity_fade_out);
                    }, NAV_CLOSE_DELAY);
                }
                break;
            case R.id.nav_item_persons:
                if (!(this instanceof PersonsActivity)) {
                    mNavItemSelected = id;
                    mHandler.postDelayed(() -> {
                        getNavigator().navigateToPersonsScreen(this);
                        overridePendingTransition(R.anim.activity_fade_in, R.anim.activity_fade_out);
                    }, NAV_CLOSE_DELAY);
                }
                break;
            case R.id.nav_item_settings:
                getNavigator().navigateToSettingsScreen(this);
                break;
            case R.id.nav_item_contact:
                final String subject = String.format(getString(R.string.mail_subject), DeviceConfigurationHelper.getAppVersionInfo());
                final String body = String.format(getString(R.string.mail_body), DeviceConfigurationHelper.getDeviceInfo(),
                        DeviceConfigurationHelper.getBuildInfo(), DeviceConfigurationHelper.getVersionInfo());
                final String mail = getString(R.string.mail_address);
                getNavigator().navigateToContactScreen(this, subject, body, mail);
                break;
            case R.id.nav_item_rate:
                getNavigator().navigateToMarketAppRating(this);
                break;
            default:
                break;
        }
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
