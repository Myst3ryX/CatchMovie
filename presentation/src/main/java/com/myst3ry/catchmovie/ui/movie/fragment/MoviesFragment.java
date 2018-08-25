package com.myst3ry.catchmovie.ui.movie.fragment;

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
import com.myst3ry.catchmovie.listener.OnMovieClickListener;
import com.myst3ry.catchmovie.model.MovieDataModel;
import com.myst3ry.catchmovie.ui.base.BaseFragment;
import com.myst3ry.catchmovie.ui.movie.adapter.MoviesAdapter;
import com.myst3ry.catchmovie.ui.movie.presenter.MoviesPresenter;
import com.myst3ry.catchmovie.ui.movie.view.MoviesView;
import com.myst3ry.catchmovie.utils.LinearSpacingItemDecoration;
import com.myst3ry.catchmovie.utils.RecyclerViewScrollListener;
import com.myst3ry.domain.model.types.MovieType;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;

public final class MoviesFragment extends BaseFragment implements MoviesView {

    public static final String TAG = MoviesFragment.class.getSimpleName();

    private static final String ARG_MOVIES_TYPE = BuildConfig.APPLICATION_ID + "ARG.MOVIES_TYPE";

    @BindView(R.id.rv_movies)
    RecyclerView mMoviesRecyclerView;
    @BindView(R.id.tv_empty_movies)
    TextView mEmptyMoviesTextView;

    @Inject
    MoviesPresenter mPresenter;

    private MovieType mType;
    private MoviesAdapter mMoviesAdapter;
    private OnMovieClickListener mMovieClickListener;

    public static Fragment newInstance(final MovieType type) {
        final MoviesFragment fragment = new MoviesFragment();
        final Bundle args = new Bundle();
        args.putSerializable(MoviesFragment.ARG_MOVIES_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((CatchMovieApp) context.getApplicationContext()).getAppComponent()
                .getMoviesSubComponent().inject(this);
        if (context instanceof OnMovieClickListener) {
            this.mMovieClickListener = (OnMovieClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = (MovieType) getArguments().getSerializable(MoviesFragment.ARG_MOVIES_TYPE);
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
        mPresenter.attachView(this);

        initAdapter();
        prepareRecyclerView();
    }

    @Override
    public void onStart() {
        super.onStart();
        getMovies();
    }

    private void initAdapter() {
        mMoviesAdapter = new MoviesAdapter(mMovieClickListener, this::onMovieMenuClick);
    }

    private void prepareRecyclerView() {
        final FloatingActionButton fab = Objects.requireNonNull(getActivity()).findViewById(R.id.fab_find_movie);
        mMoviesRecyclerView.setAdapter(mMoviesAdapter);
        mMoviesRecyclerView.setWillNotDraw(false);
        mMoviesRecyclerView.addOnScrollListener(new RecyclerViewScrollListener(fab));
        mMoviesRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_small))
                .setOrientation(LinearLayoutManager.VERTICAL)
                .includeEdge(true)
                .build());
    }

    private void getMovies() {
        mPresenter.getMovies(mType);
    }

    @Override
    public void setMovies(final List<MovieDataModel> movies) {
        mMoviesAdapter.setMovies(movies);
    }

    @Override
    public void showEmptyText() {
        mEmptyMoviesTextView.setVisibility(View.VISIBLE);
        switch (mType) {
            case RECENT:
                mEmptyMoviesTextView.setText(getString(R.string.text_empty_movies_recent));
                break;
            case WATCHLIST:
                mEmptyMoviesTextView.setText(getString(R.string.text_empty_movies_watchlist));
                break;
            case FAVORITE:
                mEmptyMoviesTextView.setText(getString(R.string.text_empty_movies_favorites));
                break;
            default:
                break;
        }

    }

    @Override
    public void hideEmptyText() {
        mEmptyMoviesTextView.setVisibility(View.GONE);
    }

    private void onMovieMenuClick(final int movieId) {
        //todo implement
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
        mPresenter.disposeAll();
    }
}
