package com.myst3ry.catchmovie.ui.activity.actor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.model.ActorDataModel;
import com.myst3ry.catchmovie.ui.activity.BaseDetailActivity;
import com.myst3ry.catchmovie.ui.view.ActorDetailView;

public final class ActorDetailActivity extends BaseDetailActivity implements ActorDetailView {

    public static Intent newIntent(final Context context) {
        return new Intent(context, ActorDetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_detail);
    }

    @Override
    public void setActorDetails(final ActorDataModel actor) {
        //todo implement
    }
}

