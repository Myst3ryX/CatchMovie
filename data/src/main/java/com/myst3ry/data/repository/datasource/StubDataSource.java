package com.myst3ry.data.repository.datasource;

import com.myst3ry.data.local.entity.ActorEntity;
import com.myst3ry.data.local.entity.MovieEntity;
import com.myst3ry.data.local.entity.TvShowEntity;

import java.util.ArrayList;
import java.util.List;

public final class StubDataSource implements DataSource {

    public List<ActorEntity> getActorsList() {
        final int actorsSize = 5;
        List<ActorEntity> actors = new ArrayList<>(actorsSize);
        for (int i = 0; i < actorsSize; i++) {
            final ActorEntity actor = new ActorEntity();
            //actor.setActorPhotoImage(R.drawable.jordana_photo);
            //actor.setActorName("Jordana Brewster");
            actors.add(actor);
        }

        return actors;
    }

    public List<MovieEntity> getRecentMoviesList() {
        return fillMoviesList(10);
    }

    public List<MovieEntity> getWatchlistMoviesList() {
        return fillMoviesList(2);
    }

    public List<MovieEntity> getFavoritesMoviesList() {
        return fillMoviesList(0);
    }

    public List<TvShowEntity> getRecentTvShowsList() {
        return fillTvShowsList(5);
    }

    public List<TvShowEntity> getWatchlistTvShowsList() {
        return fillTvShowsList(7);
    }

    public List<TvShowEntity> getFavoritesTvShowsList() {
        return fillTvShowsList(1);
    }

    private List<MovieEntity> fillMoviesList(final int size) {
        final List<MovieEntity> movies = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            final MovieEntity movie = new MovieEntity();
//            movie.setId((long)i);
//            movie.setMoviePosterImage(R.drawable.star_wars_poster);
//            movie.setMovieReleaseYear("1977");
//            movie.setMovieTitle("Star Wars");
//            movie.setMovieGenre("Action, Adventure, Fantasy");
//            movie.setMovieRating("10/10");
//            movie.setMovieTmdbRating("10.0");
            movies.add(movie);
        }
        return movies;
    }

    private List<TvShowEntity> fillTvShowsList(final int size) {
        final List<TvShowEntity> tvShows = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            final TvShowEntity tvShow = new TvShowEntity();
//            tvShow.setId((long)i);
//            tvShow.setTvShowPosterImage(R.drawable.star_wars_poster);
//            tvShow.setTvShowReleaseYear("NONE");
//            tvShow.setTvShowTitle("NO NAME");
//            tvShow.setTvShowGenre("NO DATA");
//            tvShow.setTvShowRating("0/0");
//            tvShow.setTvShowTmdbRating("0.0");
            tvShows.add(tvShow);
        }
        return tvShows;
    }
}
