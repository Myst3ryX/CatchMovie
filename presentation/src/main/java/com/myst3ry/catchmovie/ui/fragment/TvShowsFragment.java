package com.myst3ry.catchmovie.ui.fragment;

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
import android.widget.Toast;

import com.myst3ry.catchmovie.BuildConfig;
import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.model.TvShowDataModel;
import com.myst3ry.catchmovie.ui.adapter.TvShowsAdapter;
import com.myst3ry.catchmovie.ui.view.TvShowsView;
import com.myst3ry.catchmovie.utils.LinearSpacingItemDecoration;
import com.myst3ry.catchmovie.utils.RecyclerViewScrollListener;

import java.util.List;

import butterknife.BindView;

public final class TvShowsFragment extends BaseFragment implements TvShowsView {

    public static final String TAG = TvShowsFragment.class.getSimpleName();
    private static final String ARG_TV_SHOWS_TYPE = BuildConfig.APPLICATION_ID + "ARG.TV_SHOWS_TYPE";

    @BindView(R.id.fab_add_tv_show)
    FloatingActionButton mFloatingButtonAddTvShow;
    @BindView(R.id.rv_tv_shows)
    RecyclerView mTvShowsRecyclerView;
    @BindView(R.id.tv_empty_tv_shows)
    TextView mEmptyTvShowsTextView;

    private int mTvShowsType;
    private TvShowsAdapter mTvShowsAdapter;

    public static Fragment newInstance(final int tvShowsType) {
        final TvShowsFragment fragment = new TvShowsFragment();
        final Bundle args = new Bundle();
        args.putInt(TvShowsFragment.ARG_TV_SHOWS_TYPE, tvShowsType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTvShowsType = getArguments().getInt(TvShowsFragment.ARG_TV_SHOWS_TYPE);
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
        setFabListener();
        initAdapter();
        prepareRecyclerView();

        showEmptyText(); //todo ?
    }

    @Override
    public void setTvShows(List<TvShowDataModel> tvShows) {
        //mTvShowsAdapter.setTvShows(tvShows);
    }

    //todo implement
    private void setFabListener() {
        mFloatingButtonAddTvShow.setOnClickListener(v -> Toast.makeText(v.getContext(),
                getString(R.string.fab_click), Toast.LENGTH_SHORT).show());
    }

    private void initAdapter() {
        mTvShowsAdapter = new TvShowsAdapter(mTvShowsType, this::onTvShowClick);
    }

    private void prepareRecyclerView() {
        mTvShowsRecyclerView.setAdapter(mTvShowsAdapter);
        mTvShowsRecyclerView.setWillNotDraw(false);
        mTvShowsRecyclerView.addOnScrollListener(new RecyclerViewScrollListener(mFloatingButtonAddTvShow));
        mTvShowsRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_small))
                .setOrientation(LinearLayoutManager.VERTICAL)
                .includeEdge(true)
                .build());
    }

    private void showEmptyText() {
        if (mTvShowsRecyclerView.getAdapter().getItemCount() == 0) {
            mEmptyTvShowsTextView.setVisibility(View.VISIBLE);
            switch (mTvShowsType) {
                case TvShowDataModel.RECENT:
                    mEmptyTvShowsTextView.setText(getString(R.string.text_empty_tv_shows_recent));
                    break;
                case TvShowDataModel.WATCH:
                    mEmptyTvShowsTextView.setText(getString(R.string.text_empty_tv_shows_watchlist));
                    break;
                case TvShowDataModel.FAVORITE:
                    mEmptyTvShowsTextView.setText(getString(R.string.text_empty_tv_shows_favorites));
                    break;
                default:
                    break;
            }
        } else {
            mEmptyTvShowsTextView.setVisibility(View.GONE);
        }
    }

    private void onTvShowClick(final long tvShowId) {
        //todo implement
    }
}
