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
import com.myst3ry.catchmovie.model.TvShowDataModel;
import com.myst3ry.catchmovie.ui.base.BaseFragment;
import com.myst3ry.catchmovie.ui.tvshow.presenter.TvShowDetailPresenter;
import com.myst3ry.catchmovie.ui.tvshow.view.TvShowDetailView;

import java.util.List;

import javax.inject.Inject;

public final class TvShowDetailFragment extends BaseFragment implements TvShowDetailView {

    public static final String TAG = TvShowDetailFragment.class.getSimpleName();

    @Inject
    TvShowDetailPresenter mPresenter;

    public static Fragment newInstance() {
        final TvShowDetailFragment fragment = new TvShowDetailFragment();
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
        return inflater.inflate(R.layout.fragment_tv_show_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
    }

    @Override
    public void setTvShowDetails(final TvShowDataModel tvShow) {

    }

    @Override
    public void setTvShowPosters(final List<String> posters) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
        mPresenter.disposeAll();
    }
}