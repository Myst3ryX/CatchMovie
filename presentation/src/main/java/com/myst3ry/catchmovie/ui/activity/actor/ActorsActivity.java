package com.myst3ry.catchmovie.ui.activity.actor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.ui.activity.NavDrawerBaseActivity;
import com.myst3ry.catchmovie.ui.fragment.ActorsFragment;

public final class ActorsActivity extends NavDrawerBaseActivity {

    public static Intent newIntent(final Context context) {
        return new Intent(context, ActorsActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        super.setupDrawer();

        initUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.app_title_actors);
    }

    private void initUI() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_actors, ActorsFragment.newInstance(), ActorsFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}

