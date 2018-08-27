package com.myst3ry.catchmovie.ui.tvshow.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myst3ry.catchmovie.CatchMovieApp;
import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.model.item.TvShowItemDataModel;
import com.myst3ry.catchmovie.ui.base.BaseFragment;
import com.myst3ry.catchmovie.ui.tvshow.presenter.TvShowCatchPresenter;
import com.myst3ry.catchmovie.ui.tvshow.view.TvShowCatchView;

import java.util.Objects;

import javax.inject.Inject;

public final class TvShowCatchFragment extends BaseFragment implements TvShowCatchView {

    public static final String TAG = TvShowCatchFragment.class.getSimpleName();

    @Inject
    TvShowCatchPresenter mPresenter;

    public static Fragment newInstance() {
        final TvShowCatchFragment fragment = new TvShowCatchFragment();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((CatchMovieApp) context.getApplicationContext()).getAppComponent()
                .getTvShowsSubComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv_show_catch, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        Objects.requireNonNull(getActivity()).setTitle(getString(R.string.app_title_catch_tv_show));
    }

    @Override
    public void showTvShowCatchResult(final TvShowItemDataModel tvShow) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
        mPresenter.disposeAll();
    }
}
