package com.myst3ry.catchmovie.ui.movie.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.listener.OnMovieClickListener;
import com.myst3ry.catchmovie.listener.OnMovieMenuClickListener;
import com.myst3ry.catchmovie.model.MovieDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder> {

    private static final int INIT_POS = 0;

    private List<MovieDataModel> mMovies;
    private final OnMovieClickListener mListener;
    private final OnMovieMenuClickListener mMenuListener;

    public MoviesAdapter(final OnMovieClickListener listener, final OnMovieMenuClickListener menuListener) {
        this.mMovies = new ArrayList<>();
        this.mListener = listener;
        this.mMenuListener = menuListener;
    }

    @Override
    public MoviesAdapter.MovieHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new MovieHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(final MovieHolder holder, final int position) {
        final MovieDataModel currentMovie = mMovies.get(position);
        holder.mPosterImageView.setImageResource(currentMovie.getMoviePosterImage());
        holder.mReleaseYearTextView.setText(currentMovie.getMovieReleaseYear());
        holder.mTitleTextView.setText(currentMovie.getMovieTitle());
        holder.mGenreTextView.setText(currentMovie.getMovieGenre());
        holder.mRatingTextView.setText(currentMovie.getMovieRating());
        holder.mTmdbRatingTextView.setText(currentMovie.getMovieTmdbRating());
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void setMovies(final List<MovieDataModel> movies) {
        this.mMovies = movies;
        notifyDataSetChanged();
    }

    public void addMovie(final MovieDataModel movie) {
        mMovies.add(INIT_POS, movie);
        notifyItemInserted(INIT_POS);
    }

    public void removeMovie(final int movieId) {
        MovieDataModel movie = null;
        int position = Integer.MIN_VALUE;

        for (int i = 0; i < mMovies.size(); i++) {
            if (mMovies.get(i).getMovieId() == movieId) {
                movie = mMovies.get(i);
                position = i;
                break;
            }
        }

        if (movie != null) {
            mMovies.remove(movie);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mMovies.size());
        }
    }

    public void clearMovies() {
        final int size = mMovies.size();
        mMovies.clear();
        notifyItemRangeRemoved(INIT_POS, size);
    }

    private MovieDataModel getMovie(final int position) {
        return mMovies.get(position);
    }

    public final class MovieHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_poster_image)
        ImageView mPosterImageView;
        @BindView(R.id.movie_release_year)
        TextView mReleaseYearTextView;
        @BindView(R.id.movie_title)
        TextView mTitleTextView;
        @BindView(R.id.movie_genre)
        TextView mGenreTextView;
        @BindView(R.id.movie_rating)
        TextView mRatingTextView;
        @BindView(R.id.tmdb_rating)
        TextView mTmdbRatingTextView;

        @OnClick(R.id.movie_container)
        void onItemClick() {
            mListener.onMovieClick(getMovie(getLayoutPosition()).getMovieId());
        }

        @OnClick(R.id.movie_context_menu)
        void onContextMenuClick() {
            mMenuListener.onMovieMenuClick(getMovie(getLayoutPosition()).getMovieId());
        }

        MovieHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
