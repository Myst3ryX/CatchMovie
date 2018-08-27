package com.myst3ry.catchmovie.model.item;

import java.util.List;

public final class MovieItemDataModel {

    private final int mMovieId;
    private final String mMovieTitle;
    private final String mMoviePoster;
    private final String mMovieReleaseDate;
    private final List<String> mMovieGenres;
    private final double mMovieRating;
    private final double mMovieTmdbRating;

    private MovieItemDataModel(final Builder builder) {
        this.mMovieId = builder.id;
        this.mMovieTitle = builder.title;
        this.mMoviePoster = builder.poster;
        this.mMovieReleaseDate = builder.releaseDate;
        this.mMovieGenres = builder.genres;
        this.mMovieRating = builder.rating;
        this.mMovieTmdbRating = builder.tmdbRating;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getMovieId() {
        return mMovieId;
    }

    public String getMovieTitle() {
        return mMovieTitle;
    }

    public String getMoviePoster() {
        return mMoviePoster;
    }

    public String getMovieReleaseDate() {
        return mMovieReleaseDate;
    }

    public List<String> getMovieGenres() {
        return mMovieGenres;
    }

    public double getMovieRating() {
        return mMovieRating;
    }

    public double getMovieTmdbRating() {
        return mMovieTmdbRating;
    }

    public static final class Builder {

        private int id;
        private String title;
        private String poster;
        private String releaseDate;
        private List<String> genres;
        private double rating;
        private double tmdbRating;

        private Builder() {
        }

        public Builder setId(final int id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(final String title) {
            this.title = title;
            return this;
        }

        public Builder setPoster(final String poster) {
            this.poster = poster;
            return this;
        }

        public Builder setReleaseDate(final String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder setGenres(final List<String> genres) {
            this.genres = genres;
            return this;
        }

        public Builder setRating(final double rating) {
            this.rating = rating;
            return this;
        }

        public Builder setTmdbRating(final double tmdbRating) {
            this.tmdbRating = tmdbRating;
            return this;
        }

        public MovieItemDataModel build() {
            return new MovieItemDataModel(this);
        }
    }
}
