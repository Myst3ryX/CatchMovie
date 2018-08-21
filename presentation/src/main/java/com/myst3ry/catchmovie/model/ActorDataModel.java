package com.myst3ry.catchmovie.model;

import java.util.List;

public final class ActorDataModel {

    private final long mActorId;
    private final int mActorPhotoImage;
    private final String mActorFullName;
    private final String mActorBiography;
    private final List<MovieDataModel> mActorMoviesList;
    private final List<TvShowDataModel> mActorTvShowsList;

    private ActorDataModel(final Builder builder) {
        this.mActorId = builder.id;
        this.mActorPhotoImage = builder.photo;
        this.mActorFullName = builder.name;
        this.mActorBiography = builder.biography;
        this.mActorMoviesList = builder.movies;
        this.mActorTvShowsList = builder.tvShows;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public long getActorId() {
        return mActorId;
    }

    public int getActorPhotoImage() {
        return mActorPhotoImage;
    }

    public String getActorFullName() {
        return mActorFullName;
    }

    public String getActorBiography() {
        return mActorBiography;
    }

    public List<MovieDataModel> getActorMoviesList() {
        return mActorMoviesList;
    }

    public List<TvShowDataModel> getActorTvShowsList() {
        return mActorTvShowsList;
    }


    public static final class Builder {

        private long id;
        private int photo;
        private String name;
        private String biography;
        private List<MovieDataModel> movies;
        private List<TvShowDataModel> tvShows;

        private Builder() {
        }

        public Builder setActorId(final long id) {
            this.id = id;
            return this;
        }

        public Builder setActorPhotoImage(final int photo) {
            this.photo = photo;
            return this;
        }

        public Builder setActorFullName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setActorBiography(final String biography) {
            this.biography = biography;
            return this;
        }

        public Builder setActorMoviesList(final List<MovieDataModel> movies) {
            this.movies = movies;
            return this;
        }

        public Builder setActorTvShowsList(final List<TvShowDataModel> tvShows) {
            this.tvShows = tvShows;
            return this;
        }

        public ActorDataModel build() {
            return new ActorDataModel(this);
        }
    }
}
