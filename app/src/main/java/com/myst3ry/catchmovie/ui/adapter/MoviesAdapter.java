package com.myst3ry.catchmovie.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.model.Movie;
import com.myst3ry.catchmovie.ui.activity.MovieDetailActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder> {

    private int movieType;
    private List<Movie> movies = new ArrayList<>();

    public MoviesAdapter(int movieType) {
        this.movieType = movieType;
        initAdapter();
    }

    @Override
    public MoviesAdapter.MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        final Movie currentMovie = movies.get(position);

        holder.moviePosterImage.setImageResource(currentMovie.getMoviePosterImage());
        holder.movieContextMenuImage.setImageResource(R.drawable.ic_menu);
        holder.movieReleaseYear.setText(currentMovie.getMovieReleaseYear());
        holder.movieTitle.setText(currentMovie.getMovieTitle());
        holder.movieGenre.setText(currentMovie.getMovieGenre());
        holder.rateStarImage.setImageResource(R.drawable.ic_star_border);
        holder.movieRating.setText(currentMovie.getMovieRating());
        holder.tmdbLogoImage.setImageResource(R.drawable.tmdb_logo_stacked);
        holder.tmdbRating.setText(currentMovie.getMovieTmdbRating());
    }

    @Override
    public int getItemCount() {
        return movies != null ? movies.size() : 0;
    }

    private Movie getMovie(int position) {
        return movies != null ? movies.get(position) : null;
    }

    private void initAdapter() {
        switch (movieType) {
            case Movie.RECENT:
                setRecentMoviesList();
                break;
            case Movie.WATCH:
                //setWatchMoviesList();
                break;
            case Movie.FAVORITE:
                setFavoriteMoviesList();
                break;
            default:
                break;
        }
    }

    private void setRecentMoviesList() { //stub recent movies
        movies.clear();
        movies.addAll(Arrays.asList(fillList(10)));
    }

    private void setWatchMoviesList() { //stub watchlist movies
        movies.clear();
        movies.addAll(Arrays.asList(fillList(3)));
    }

    private void setFavoriteMoviesList() { //stub favorite movies
        movies.clear();
        movies.addAll(Arrays.asList(fillList(10)));
    }

    private Movie[] fillList(int size) {
        Movie[] moviesArr = new Movie[size];
        for (int i = 0; i < size; i++) {
            Movie movie = new Movie();
            movie.setMoviePosterImage(R.drawable.star_wars_poster);
            movie.setMovieReleaseYear("1977");
            movie.setMovieTitle("Star Wars");
            movie.setMovieGenre("Action, Adventure, Fantasy");
            movie.setMovieRating("10/10");
            movie.setMovieTmdbRating("10.0");
            moviesArr[i] = movie;
        }
        return moviesArr;
    }

    public final class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.movie_poster_image)
        ImageView moviePosterImage;
        @BindView(R.id.movie_context_menu_image)
        ImageView movieContextMenuImage;
        @BindView(R.id.movie_release_year)
        TextView movieReleaseYear;
        @BindView(R.id.movie_title)
        TextView movieTitle;
        @BindView(R.id.movie_genre)
        TextView movieGenre;
        @BindView(R.id.rate_star_image)
        ImageView rateStarImage;
        @BindView(R.id.movie_rating)
        TextView movieRating;
        @BindView(R.id.tmdb_logo_image)
        ImageView tmdbLogoImage;
        @BindView(R.id.tmdb_rating)
        TextView tmdbRating;

        public MovieHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent movieDetailIntent = new Intent(context, MovieDetailActivity.class);
            Movie movieSelected = getMovie(getLayoutPosition());

            if (movieSelected != null) {
                //movieDetailIntent.putExtra(MovieDetailActivity.MOVIE_EXTRA, movieSelected);
                context.startActivity(movieDetailIntent);
            }
        }
    }
}
