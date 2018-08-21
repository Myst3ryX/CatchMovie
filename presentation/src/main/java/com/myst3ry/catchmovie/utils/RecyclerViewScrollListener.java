package com.myst3ry.catchmovie.utils;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;

public final class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {

    private static final int DY_POS = 0;

    private final FloatingActionButton mFab;

    public RecyclerViewScrollListener(final FloatingActionButton fab) {
        this.mFab = fab;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    //hide fab with scrolling down and show with scrolling up
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (dy > DY_POS && mFab.isShown()) {
            mFab.hide();
        } else if (dy < DY_POS && !mFab.isShown()) {
            mFab.show();
        }
    }
}
