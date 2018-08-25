package com.myst3ry.catchmovie.model;

import java.util.List;

public final class PersonDataModel {

    private final int mPersonId;
    private final int mPersonPhotoImage;
    private final String mPersonName;
    private final String mPersonBiography;
    private final List<MovieDataModel> mPersonMoviesList;
    private final List<TvShowDataModel> mPersonTvShowsList;

    private PersonDataModel(final Builder builder) {
        this.mPersonId = builder.id;
        this.mPersonPhotoImage = builder.photo;
        this.mPersonName = builder.name;
        this.mPersonBiography = builder.biography;
        this.mPersonMoviesList = builder.movies;
        this.mPersonTvShowsList = builder.tvShows;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getPersonId() {
        return mPersonId;
    }

    public int getPersonPhotoImage() {
        return mPersonPhotoImage;
    }

    public String getPersonName() {
        return mPersonName;
    }

    public String getPersonBiography() {
        return mPersonBiography;
    }

    public List<MovieDataModel> getPersonMoviesList() {
        return mPersonMoviesList;
    }

    public List<TvShowDataModel> getPersonTvShowsList() {
        return mPersonTvShowsList;
    }


    public static final class Builder {

        private int id;
        private int photo;
        private String name;
        private String biography;
        private List<MovieDataModel> movies;
        private List<TvShowDataModel> tvShows;

        private Builder() {
        }

        public Builder setPersonId(final int id) {
            this.id = id;
            return this;
        }

        public Builder setPersonPhotoImage(final int photo) {
            this.photo = photo;
            return this;
        }

        public Builder setPersonFullName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setPersonBiography(final String biography) {
            this.biography = biography;
            return this;
        }

        public Builder setPersonMoviesList(final List<MovieDataModel> movies) {
            this.movies = movies;
            return this;
        }

        public Builder setPersonTvShowsList(final List<TvShowDataModel> tvShows) {
            this.tvShows = tvShows;
            return this;
        }

        public PersonDataModel build() {
            return new PersonDataModel(this);
        }
    }
}
