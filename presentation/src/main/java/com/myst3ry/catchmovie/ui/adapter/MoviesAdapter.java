package com.myst3ry.catchmovie.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.listener.OnMovieClickListener;
import com.myst3ry.catchmovie.model.MovieDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder> {

    private final int mMovieType;
    private final OnMovieClickListener mListener;
    private List<MovieDataModel> mMovies;

    public MoviesAdapter(final int movieType, final OnMovieClickListener listener) {
        this.mMovies = new ArrayList<>();
        this.mMovieType = movieType;
        this.mListener = listener;
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

    private MovieDataModel getMovie(final int position) {
        return mMovies.get(position);
    }

    public void setMovies(final List<MovieDataModel> movies) {
        switch (mMovieType) {
            case MovieDataModel.RECENT:
                setRecentMoviesList(movies);
                break;
            case MovieDataModel.WATCH:
                setWatchMoviesList(movies);
                break;
            case MovieDataModel.FAVORITE:
                setFavoriteMoviesList(movies);
                break;
            default:
                break;
        }
    }

    //todo replace
    private void setRecentMoviesList(final List<MovieDataModel> moviesRecent) {
        this.mMovies = moviesRecent;
        notifyDataSetChanged();
    }

    //todo replace
    private void setWatchMoviesList(final List<MovieDataModel> moviesToWatch) {
        this.mMovies = moviesToWatch;
        notifyDataSetChanged();
    }

    //todo replace
    private void setFavoriteMoviesList(final List<MovieDataModel> moviesFavorite) {
        this.mMovies = moviesFavorite;
        notifyDataSetChanged();
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
        void onContextMenuClick(final View view) {
            Toast.makeText(view.getContext(), "Item " + getLayoutPosition() + " clicked!", Toast.LENGTH_SHORT).show();
        }

        MovieHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
