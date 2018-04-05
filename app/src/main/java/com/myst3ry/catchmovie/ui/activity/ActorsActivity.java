package com.myst3ry.catchmovie.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.myst3ry.catchmovie.R;

import butterknife.BindString;

public class ActorsActivity extends NavDrawerBaseActivity {

    @BindString(R.string.bar_actors_title)
    String actorsTitle;

    private static int navItemSelected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        setTitle(actorsTitle);
        super.setupDrawer();

        if (savedInstanceState == null) {
            navItemSelected = getIntent().getIntExtra(NAV_ITEM_SELECTED_EXTRA, 0);
        } else {
            navItemSelected = savedInstanceState.getInt(NAV_ITEM_SELECTED);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getNavigationView().setCheckedItem(navItemSelected);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(NAV_ITEM_SELECTED, navItemSelected);
    }

}

