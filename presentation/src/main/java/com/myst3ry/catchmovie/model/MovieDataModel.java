package com.myst3ry.catchmovie.model;

public final class MovieDataModel {

    public static final int RECENT = 0;
    public static final int WATCH = 1;
    public static final int FAVORITE = 2;

    private final long mMovieId;
    private final int mMoviePosterImage;
    private final String mMovieReleaseYear;
    private final String mMovieTitle;
    private final String mMovieGenre;
    private final String mMovieRating;
    private final String mMovieTmdbRating;

    private MovieDataModel(final Builder builder) {
        this.mMovieId = builder.id;
        this.mMoviePosterImage = builder.poster;
        this.mMovieReleaseYear = builder.releaseYear;
        this.mMovieTitle = builder.title;
        this.mMovieGenre = builder.genre;
        this.mMovieRating = builder.rating;
        this.mMovieTmdbRating = builder.tmdbRating;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public long getMovieId() {
        return mMovieId;
    }

    public int getMoviePosterImage() {
        return mMoviePosterImage;
    }

    public String getMovieReleaseYear() {
        return mMovieReleaseYear;
    }

    public String getMovieTitle() {
        return mMovieTitle;
    }

    public String getMovieGenre() {
        return mMovieGenre;
    }

    public String getMovieRating() {
        return mMovieRating;
    }

    public String getMovieTmdbRating() {
        return mMovieTmdbRating;
    }


    public static final class Builder {

        private long id;
        private int poster;
        private String releaseYear;
        private String title;
        private String genre;
        private String rating;
        private String tmdbRating;

        private Builder() {
        }

        public Builder setMovieId(final long id) {
            this.id = id;
            return this;
        }

        public Builder setMoviePosterImage(final int poster) {
            this.poster = poster;
            return this;
        }

        public Builder setMovieReleaseYear(final String releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Builder setMovieTitle(final String title) {
            this.title = title;
            return this;
        }

        public Builder setMovieGenre(final String genre) {
            this.genre = genre;
            return this;
        }

        public Builder setMovieRating(final String rating) {
            this.rating = rating;
            return this;
        }

        public Builder setMovieTmdbRating(final String tmdbRating) {
            this.tmdbRating = tmdbRating;
            return this;
        }

        public MovieDataModel build() {
            return new MovieDataModel(this);
        }
    }
}
