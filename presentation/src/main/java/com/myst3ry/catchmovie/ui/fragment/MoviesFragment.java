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
import com.myst3ry.catchmovie.model.MovieDataModel;
import com.myst3ry.catchmovie.ui.adapter.MoviesAdapter;
import com.myst3ry.catchmovie.ui.view.MoviesView;
import com.myst3ry.catchmovie.utils.LinearSpacingItemDecoration;
import com.myst3ry.catchmovie.utils.RecyclerViewScrollListener;

import java.util.List;

import butterknife.BindView;

public final class MoviesFragment extends BaseFragment implements MoviesView {

    public static final String TAG = MoviesFragment.class.getSimpleName();
    private static final String ARG_MOVIES_TYPE = BuildConfig.APPLICATION_ID + "ARG.MOVIES_TYPE";

    @BindView(R.id.fab_add_movie)
    FloatingActionButton mFloatingButtonAddMovie;
    @BindView(R.id.rv_movies)
    RecyclerView mMoviesRecyclerView;
    @BindView(R.id.tv_empty_movies)
    TextView mEmptyMoviesTextView;

    private int mMoviesType;
    private MoviesAdapter mMoviesAdapter;

    public static Fragment newInstance(final int moviesType) {
        final MoviesFragment fragment = new MoviesFragment();
        final Bundle args = new Bundle();
        args.putInt(MoviesFragment.ARG_MOVIES_TYPE, moviesType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMoviesType = getArguments().getInt(MoviesFragment.ARG_MOVIES_TYPE);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
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
    public void setMovies(List<MovieDataModel> movies) {
        //mMoviesAdapter.setMovies(movies);
    }

    //todo implement
    private void setFabListener() {
        mFloatingButtonAddMovie.setOnClickListener(v -> Toast.makeText(v.getContext(),
                getString(R.string.fab_click), Toast.LENGTH_SHORT).show());
    }

    private void initAdapter() {
        mMoviesAdapter = new MoviesAdapter(mMoviesType, this::onMovieClick);
    }

    private void prepareRecyclerView() {
        mMoviesRecyclerView.setAdapter(mMoviesAdapter);
        mMoviesRecyclerView.setWillNotDraw(false);
        mMoviesRecyclerView.addOnScrollListener(new RecyclerViewScrollListener(mFloatingButtonAddMovie));
        mMoviesRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_small))
                .setOrientation(LinearLayoutManager.VERTICAL)
                .includeEdge(true)
                .build());
    }

    private void showEmptyText() {
        if (mMoviesRecyclerView.getAdapter().getItemCount() == 0) {
            mEmptyMoviesTextView.setVisibility(View.VISIBLE);
            switch (mMoviesType) {
                case MovieDataModel.RECENT:
                    mEmptyMoviesTextView.setText(getString(R.string.text_empty_movies_recent));
                    break;
                case MovieDataModel.WATCH:
                    mEmptyMoviesTextView.setText(getString(R.string.text_empty_movies_watchlist));
                    break;
                case MovieDataModel.FAVORITE:
                    mEmptyMoviesTextView.setText(getString(R.string.text_empty_movies_favorites));
                    break;
                default:
                    break;
            }
        } else {
            mEmptyMoviesTextView.setVisibility(View.GONE);
        }
    }

    private void onMovieClick(final long movieId) {
        //todo implement
    }
}
