package com.myst3ry.catchmovie.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import com.myst3ry.catchmovie.R;

import butterknife.BindView;

public class NavDrawerBaseActivity extends BaseActivity {

    public static final String NAV_ITEM_SELECTED = "NavItemSelected";
    public static final String NAV_ITEM_SELECTED_EXTRA = "NavItemSelectedExtra";
    private static final int NAV_CLOSE_DELAY = 250;

    private Handler handler;

    @BindView(R.id.nav_view_main)
    NavigationView navigationView;
    @BindView(R.id.drawer_main)
    DrawerLayout drawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }

    protected void setupDrawer() {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, getToolbar(), R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                NavDrawerBaseActivity.this.onNavItemClick(item.getItemId());
                return false; //don't work properly with drawer close delay
            }
        });
    }

    private void onNavItemClick(int id) {
        Intent launchIntent = null;

        switch (id) {
            case R.id.nav_item_movies:
                if (!(this instanceof MoviesActivity)) {
                    launchIntent = new Intent(this, MoviesActivity.class);
                }
                break;
            case R.id.nav_item_tv_shows:
                if (!(this instanceof TvShowsActivity)) {
                    launchIntent = new Intent(this, TvShowsActivity.class);
                }
                break;
            case R.id.nav_item_actors:
                if (!(this instanceof ActorsActivity)) {
                    launchIntent = new Intent(this, ActorsActivity.class);
                }
                break;
            case R.id.nav_item_settings:
                launchIntent = new Intent(this, SettingsStubActivity.class);
                break;
            case R.id.nav_item_contact:
                Intent sendToIntent = new Intent(Intent.ACTION_SENDTO);
                String uriString = "mailto:" + Uri.encode(getString(R.string.mail_address)) +
                        "?subject=" + Uri.encode(getString(R.string.mail_subject)) +
                        "&body=" + Uri.encode(getString(R.string.mail_body));
                sendToIntent.setData(Uri.parse(uriString));
                startActivity(Intent.createChooser(sendToIntent, getString(R.string.mail_chooser_text)));
                break;
            case R.id.nav_item_rate: //Open market rating window (implement later)
                break;
            default:
                break;
        }

        if (launchIntent != null) {
            launchIntent.putExtra(NAV_ITEM_SELECTED_EXTRA, id);
            final Intent finalLaunchIntent = new Intent(launchIntent);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(finalLaunchIntent);
                    overridePendingTransition(R.anim.activity_fade_in, R.anim.activity_fade_out);
                }
            }, NAV_CLOSE_DELAY);
        }

        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }
}
