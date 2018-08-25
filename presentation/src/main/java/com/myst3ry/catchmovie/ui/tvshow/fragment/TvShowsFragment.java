package com.myst3ry.catchmovie.ui.tvshow.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myst3ry.catchmovie.BuildConfig;
import com.myst3ry.catchmovie.CatchMovieApp;
import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.listener.OnTvShowClickListener;
import com.myst3ry.catchmovie.model.TvShowDataModel;
import com.myst3ry.catchmovie.ui.base.BaseFragment;
import com.myst3ry.catchmovie.ui.tvshow.adapter.TvShowsAdapter;
import com.myst3ry.catchmovie.ui.tvshow.presenter.TvShowsPresenter;
import com.myst3ry.catchmovie.ui.tvshow.view.TvShowsView;
import com.myst3ry.catchmovie.utils.LinearSpacingItemDecoration;
import com.myst3ry.catchmovie.utils.RecyclerViewScrollListener;
import com.myst3ry.domain.model.types.TvShowType;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;

public final class TvShowsFragment extends BaseFragment implements TvShowsView {

    public static final String TAG = TvShowsFragment.class.getSimpleName();

    private static final String ARG_TV_SHOWS_TYPE = BuildConfig.APPLICATION_ID + "ARG.TV_SHOWS_TYPE";

    @BindView(R.id.rv_tv_shows)
    RecyclerView mTvShowsRecyclerView;
    @BindView(R.id.tv_empty_tv_shows)
    TextView mEmptyTvShowsTextView;

    @Inject
    TvShowsPresenter mPresenter;

    private TvShowType mType;
    private TvShowsAdapter mTvShowsAdapter;
    private OnTvShowClickListener mTvShowClickListener;

    public static Fragment newInstance(final TvShowType type) {
        final TvShowsFragment fragment = new TvShowsFragment();
        final Bundle args = new Bundle();
        args.putSerializable(TvShowsFragment.ARG_TV_SHOWS_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((CatchMovieApp) context.getApplicationContext()).getAppComponent()
                .getTvShowsSubComponent().inject(this);
        if (context instanceof OnTvShowClickListener) {
            this.mTvShowClickListener = (OnTvShowClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = (TvShowType) getArguments().getSerializable(TvShowsFragment.ARG_TV_SHOWS_TYPE);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv_shows, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);

        initAdapter();
        prepareRecyclerView();
    }

    @Override
    public void onStart() {
        super.onStart();
        getTvShows();
    }

    private void initAdapter() {
        mTvShowsAdapter = new TvShowsAdapter(mTvShowClickListener, this::onTvShowMenuClick);
    }

    //todo callback to fab
    private void prepareRecyclerView() {
        final FloatingActionButton fab = Objects.requireNonNull(getActivity()).findViewById(R.id.fab_find_tv_show);
        mTvShowsRecyclerView.setAdapter(mTvShowsAdapter);
        mTvShowsRecyclerView.setWillNotDraw(false);
        mTvShowsRecyclerView.addOnScrollListener(new RecyclerViewScrollListener(fab));
        mTvShowsRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_small))
                .setOrientation(LinearLayoutManager.VERTICAL)
                .includeEdge(true)
                .build());
    }

    private void getTvShows() {
        mPresenter.getTvShows(mType);
    }

    @Override
    public void setTvShows(final List<TvShowDataModel> tvShows) {
        mTvShowsAdapter.setTvShows(tvShows);
    }

    @Override
    public void showEmptyText() {
        mEmptyTvShowsTextView.setVisibility(View.VISIBLE);
        switch (mType) {
            case RECENT:
                mEmptyTvShowsTextView.setText(getString(R.string.text_empty_tv_shows_recent));
                break;
            case WATCHLIST:
                mEmptyTvShowsTextView.setText(getString(R.string.text_empty_tv_shows_watchlist));
                break;
            case FAVORITE:
                mEmptyTvShowsTextView.setText(getString(R.string.text_empty_tv_shows_favorites));
                break;
            default:
                break;
        }
    }

    @Override
    public void hideEmptyText() {
        if (mEmptyTvShowsTextView.getVisibility() == View.VISIBLE) {
            mEmptyTvShowsTextView.setVisibility(View.GONE);
        }
    }

    private void onTvShowMenuClick(final int tvShowId) {
        //todo implement
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
        mPresenter.disposeAll();
    }
}
