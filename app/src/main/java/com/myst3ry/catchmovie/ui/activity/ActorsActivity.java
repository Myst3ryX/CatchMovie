package com.myst3ry.catchmovie.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.myst3ry.catchmovie.R;

public class ActorsActivity extends NavDrawerBaseActivity {

    private static int navItemId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        super.onCreateDrawer();

        if (savedInstanceState == null) {
            navItemId = getIntent().getIntExtra(NAV_ITEM_ID_EXTRA, 0);
        } else {
            navItemId = savedInstanceState.getInt(NAV_ITEM_ID);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getNavigationView().setCheckedItem(navItemId);
        getToolbar().setTitle(getString(R.string.bar_actors_title));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(NAV_ITEM_ID, navItemId);
    }

}

