package com.myst3ry.catchmovie.ui.activity.tvshow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.model.TvShowDataModel;
import com.myst3ry.catchmovie.ui.activity.BaseDetailActivity;
import com.myst3ry.catchmovie.ui.view.TvShowDetailView;

public final class TvShowDetailActivity extends BaseDetailActivity implements TvShowDetailView {

    public static Intent newIntent(final Context context) {
        return new Intent(context, TvShowDetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_detail);
    }

    @Override
    public void setTvShowDetails(final TvShowDataModel tvShow) {
        //todo implement
    }
}

