package com.myst3ry.catchmovie.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.model.TvShow;
import com.myst3ry.catchmovie.ui.adapter.TvShowsAdapter;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TvShowsFragment extends Fragment {

    public static final String ARG_TYPE = "TVShow";
    private int tvType;

    @BindString(R.string.tv_shows_recent_empty)
    String recentEmpty;
    @BindString(R.string.tv_shows_watchlist_empty)
    String watchlistEmpty;
    @BindString(R.string.tv_shows_favorites_empty)
    String favoritesEmpty;

    @BindView(R.id.fab_catch_tv_show)
    FloatingActionButton fabCatchTvShow;
    @BindView(R.id.tv_shows_recycler_view)
    RecyclerView tvShowsRecyclerView;
    @BindView(R.id.tv_shows_empty_text)
    TextView emptyText;

    public static Fragment newInstance(int tvShowsType) {
        TvShowsFragment tvFragment = new TvShowsFragment();
        Bundle args = new Bundle();
        args.putInt(TvShowsFragment.ARG_TYPE, tvShowsType);
        tvFragment.setArguments(args);
        return tvFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv_shows, container, false);
        ButterKnife.bind(this, view);

        tvType = getArguments().getInt(TvShowsFragment.ARG_TYPE);

        fabCatchTvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), getString(R.string.fab_click), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvShowsRecyclerView.setAdapter(new TvShowsAdapter(tvType));
        tvShowsRecyclerView.setWillNotDraw(false);
        tvShowsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    fabCatchTvShow.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 || (dy < 0 && fabCatchTvShow.isShown())) {
                    fabCatchTvShow.hide();
                }
            }
        });

        if (tvShowsRecyclerView.getAdapter().getItemCount() == 0) {

            emptyText.setVisibility(View.VISIBLE);
            switch (tvType) {
                case TvShow.RECENT:
                    emptyText.setText(recentEmpty);
                    break;
                case TvShow.WATCH:
                    emptyText.setText(watchlistEmpty);
                    break;
                case TvShow.FAVORITE:
                    emptyText.setText(favoritesEmpty);
                    break;
                default:
                    break;
            }
        } else {
            emptyText.setVisibility(View.GONE);
        }
    }
}
