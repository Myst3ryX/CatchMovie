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
import com.myst3ry.catchmovie.model.Movie;
import com.myst3ry.catchmovie.ui.adapter.MoviesAdapter;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesFragment extends Fragment {

    public static final String ARG_TYPE = "Movie";
    private int mType;

    @BindString(R.string.movies_recent_empty)
    String recentEmpty;
    @BindString(R.string.movies_watchlist_empty)
    String watchlistEmpty;
    @BindString(R.string.movies_favorites_empty)
    String favoritesEmpty;

    @BindView(R.id.fab_catch_movie)
    FloatingActionButton fabCatchMovie;
    @BindView(R.id.movies_recycler_view)
    RecyclerView moviesRecyclerView;
    @BindView(R.id.movies_empty_text)
    TextView emptyText;

    public static Fragment newInstance(int moviesType) {
        MoviesFragment mFragment = new MoviesFragment();
        Bundle args = new Bundle();
        args.putInt(MoviesFragment.ARG_TYPE, moviesType);
        mFragment.setArguments(args);
        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        ButterKnife.bind(this, view);

        mType = getArguments().getInt(MoviesFragment.ARG_TYPE);

        fabCatchMovie.setOnClickListener(new View.OnClickListener() {
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
        moviesRecyclerView.setAdapter(new MoviesAdapter(mType));
        moviesRecyclerView.setWillNotDraw(false);
        moviesRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    fabCatchMovie.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 || (dy < 0 && fabCatchMovie.isShown())) {
                    fabCatchMovie.hide();
                }
            }
        });

        if (moviesRecyclerView.getAdapter().getItemCount() == 0) {

            emptyText.setVisibility(View.VISIBLE);
            switch (mType) {
                case Movie.RECENT:
                    emptyText.setText(recentEmpty);
                    break;
                case Movie.WATCH:
                    emptyText.setText(watchlistEmpty);
                    break;
                case Movie.FAVORITE:
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
