package com.myst3ry.catchmovie.ui.person.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.listener.OnPersonClickListener;
import com.myst3ry.catchmovie.ui.base.NavigationBaseActivity;
import com.myst3ry.catchmovie.ui.person.fragment.PersonsFragment;

import butterknife.BindView;

public final class PersonsActivity extends NavigationBaseActivity implements OnPersonClickListener {

    @BindView(R.id.fab_find_person)
    FloatingActionButton mFloatingButtonFindPerson;

    public static Intent newIntent(final Context context) {
        return new Intent(context, PersonsActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);
        super.setupDrawer();
        setFabListener();

        if (savedInstanceState == null) {
            initUI();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.app_title_persons);
    }

    private void initUI() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_persons, PersonsFragment.newInstance(), PersonsFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    private void setFabListener() {
        mFloatingButtonFindPerson.setOnClickListener(v -> getNavigator().navigateToPersonSearchScreen(this));
    }

    @Override
    public void onPersonClick(int personId) {
        getNavigator().navigateToPersonDetailScreen(this, personId);
    }
}

