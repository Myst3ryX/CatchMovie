package com.myst3ry.catchmovie.model.item;

import java.util.List;

public final class TvShowItemDataModel {

    private final int mTvShowId;
    private final int mTvShowType;
    private final String mTvShowTitle;
    private final String mTvShowPoster;
    private final String mTvShowReleaseDate;
    private final List<String> mTvShowGenres;
    private final double mTvShowRating;
    private final double mTvShowTmdbRating;

    private TvShowItemDataModel(final Builder builder) {
        this.mTvShowId = builder.id;
        this.mTvShowType = builder.type;
        this.mTvShowTitle = builder.title;
        this.mTvShowPoster = builder.poster;
        this.mTvShowReleaseDate = builder.releaseDate;
        this.mTvShowGenres = builder.genres;
        this.mTvShowRating = builder.rating;
        this.mTvShowTmdbRating = builder.tmdbRating;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getTvShowId() {
        return mTvShowId;
    }

    public int getTvShowType() {
        return mTvShowType;
    }

    public String getTvShowTitle() {
        return mTvShowTitle;
    }

    public String getTvShowPoster() {
        return mTvShowPoster;
    }

    public String getTvShowReleaseDate() {
        return mTvShowReleaseDate;
    }

    public List<String> getTvShowGenres() {
        return mTvShowGenres;
    }

    public double getTvShowRating() {
        return mTvShowRating;
    }

    public double getTvShowTmdbRating() {
        return mTvShowTmdbRating;
    }

    public static final class Builder {

        private int id;
        private int type;
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

        public Builder setType(final int type) {
            this.type = type;
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

        public TvShowItemDataModel build() {
            return new TvShowItemDataModel(this);
        }
    }
}
