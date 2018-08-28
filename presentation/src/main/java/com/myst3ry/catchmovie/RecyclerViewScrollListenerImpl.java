package com.myst3ry.catchmovie;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;

public final class RecyclerViewScrollListenerImpl extends RecyclerView.OnScrollListener {

    private static final int DY_POS = 0;

    private final FloatingActionButton mFab;

    public RecyclerViewScrollListenerImpl(final FloatingActionButton fab) {
        this.mFab = fab;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (mFab != null) {
            if (dy > DY_POS && mFab.isShown()) {
                mFab.hide();
            } else if (dy < DY_POS && !mFab.isShown()) {
                mFab.show();
            }
        }
    }
}
