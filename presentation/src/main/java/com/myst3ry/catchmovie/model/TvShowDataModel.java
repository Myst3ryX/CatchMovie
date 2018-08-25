package com.myst3ry.catchmovie.model;

public final class TvShowDataModel {

    public static final int RECENT = 0;
    public static final int FAVORITE = 1;
    public static final int WATCH = 2;

    private final int mTvShowId;
    private final int mTvShowPosterImage;
    private final String mTvShowReleaseYear;
    private final String mTvShowTitle;
    private final String mTvShowGenre;
    private final String mTvShowRating;
    private final String mTvShowTmdbRating;

    private TvShowDataModel(final Builder builder) {
        this.mTvShowId = builder.id;
        this.mTvShowPosterImage = builder.poster;
        this.mTvShowReleaseYear = builder.releaseYear;
        this.mTvShowTitle = builder.title;
        this.mTvShowGenre = builder.genre;
        this.mTvShowRating = builder.rating;
        this.mTvShowTmdbRating = builder.tmdbRating;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getTvShowId() {
        return mTvShowId;
    }

    public int getTvShowPosterImage() {
        return mTvShowPosterImage;
    }

    public String getTvShowReleaseYear() {
        return mTvShowReleaseYear;
    }

    public String getTvShowTitle() {
        return mTvShowTitle;
    }

    public String getTvShowGenre() {
        return mTvShowGenre;
    }

    public String getTvShowRating() {
        return mTvShowRating;
    }

    public String getTvShowTmdbRating() {
        return mTvShowTmdbRating;
    }


    public static final class Builder {

        private int id;
        private int poster;
        private String releaseYear;
        private String title;
        private String genre;
        private String rating;
        private String tmdbRating;

        private Builder() {
        }

        public Builder setTvShowId(final int id) {
            this.id = id;
            return this;
        }

        public Builder setTvShowPosterImage(final int poster) {
            this.poster = poster;
            return this;
        }

        public Builder setTvShowReleaseYear(final String releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Builder setTvShowTitle(final String title) {
            this.title = title;
            return this;
        }

        public Builder setTvShowGenre(final String genre) {
            this.genre = genre;
            return this;
        }

        public Builder setTvShowRating(final String rating) {
            this.rating = rating;
            return this;
        }

        public Builder setTvShowTmdbRating(final String tmdbRating) {
            this.tmdbRating = tmdbRating;
            return this;
        }

        public TvShowDataModel build() {
            return new TvShowDataModel(this);
        }
    }
}
