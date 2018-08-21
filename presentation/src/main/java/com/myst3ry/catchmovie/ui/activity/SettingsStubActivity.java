package com.myst3ry.catchmovie.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.myst3ry.catchmovie.R;

public final class SettingsStubActivity extends BaseDetailActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_stub);
    }

    public static Intent newIntent(final Context context) {
        return new Intent(context, SettingsStubActivity.class);
    }
}

