package com.myst3ry.catchmovie.model.detail;

import com.myst3ry.catchmovie.model.detail.credits.PersonCreditDataModel;

import java.util.List;

public final class MovieDetailDataModel {

    private final int mMovieId;
    private final int mMovieType;
    private final String mMovieMainPoster;
    private final String mMovieTitle;
    private final String mMovieOriginalTitle;
    private final String mMovieTagLine;
    private final String mMovieReleaseDate;
    private final List<String> mMovieGenres;
    private final List<String> mMoviePosters;
    private final String mMovieDescription;
    private final int mMovieBudget;
    private final int mMovieRevenue;
    private final String mMovieStatus;
    private final String mMovieLanguage;
    private final int mMovieRuntime;
    private final double mMovieRating;
    private final double mMovieTmdbRating;
    private final int mMovieVotesCount;
    private final List<PersonCreditDataModel> mMovieActors;
    private final List<PersonCreditDataModel> mMovieDirectors;
    private final List<PersonCreditDataModel> mMovieWriters;

    private MovieDetailDataModel(final Builder builder) {
        this.mMovieId = builder.id;
        this.mMovieType = builder.type;
        this.mMovieMainPoster = builder.mainPoster;
        this.mMovieTitle = builder.title;
        this.mMovieOriginalTitle = builder.originalTitle;
        this.mMovieTagLine = builder.tagLine;
        this.mMovieReleaseDate = builder.releaseDate;
        this.mMovieGenres = builder.genres;
        this.mMoviePosters = builder.posters;
        this.mMovieDescription = builder.description;
        this.mMovieBudget = builder.budget;
        this.mMovieRevenue = builder.revenue;
        this.mMovieStatus = builder.status;
        this.mMovieLanguage = builder.language;
        this.mMovieRuntime = builder.runtime;
        this.mMovieRating = builder.rating;
        this.mMovieTmdbRating = builder.tmdbRating;
        this.mMovieVotesCount = builder.votesCount;
        this.mMovieActors = builder.actors;
        this.mMovieDirectors = builder.directors;
        this.mMovieWriters = builder.writers;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getMovieId() {
        return mMovieId;
    }

    public int getMovieType() {
        return mMovieType;
    }

    public String getMoviePoster() {
        return mMovieMainPoster;
    }

    public String getMovieTitle() {
        return mMovieTitle;
    }

    public String getMovieOriginalTitle() {
        return mMovieOriginalTitle;
    }

    public String getMovieTagLine() {
        return mMovieTagLine;
    }

    public String getMovieReleaseDate() {
        return mMovieReleaseDate;
    }

    public List<String> getMovieGenres() {
        return mMovieGenres;
    }

    public List<String> getMoviePosters() {
        return mMoviePosters;
    }

    public String getMovieDescription() {
        return mMovieDescription;
    }

    public int getMovieBudget() {
        return mMovieBudget;
    }

    public int getMovieRevenue() {
        return mMovieRevenue;
    }

    public String getMovieStatus() {
        return mMovieStatus;
    }

    public String getMovieLanguage() {
        return mMovieLanguage;
    }

    public int getMovieRuntime() {
        return mMovieRuntime;
    }

    public double getMovieRating() {
        return mMovieRating;
    }

    public double getMovieTmdbRating() {
        return mMovieTmdbRating;
    }

    public int getMovieVotesCount() {
        return mMovieVotesCount;
    }

    public List<PersonCreditDataModel> getMovieActors() {
        return mMovieActors;
    }

    public List<PersonCreditDataModel> getMovieDirectors() {
        return mMovieDirectors;
    }

    public List<PersonCreditDataModel> getMovieWriters() {
        return mMovieWriters;
    }

    public static final class Builder {

        private int id;
        private int type;
        private String mainPoster;
        private String title;
        private String originalTitle;
        private String tagLine;
        private String releaseDate;
        private List<String> genres;
        private List<String> posters;
        private String description;
        private int budget;
        private int revenue;
        private String status;
        private String language;
        private int runtime;
        private double rating;
        private double tmdbRating;
        private int votesCount;
        private List<PersonCreditDataModel> actors;
        private List<PersonCreditDataModel> directors;
        private List<PersonCreditDataModel> writers;

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

        public Builder setMainPoster(final String mainPoster) {
            this.mainPoster = mainPoster;
            return this;
        }

        public Builder setTitle(final String title) {
            this.title = title;
            return this;
        }

        public Builder setOriginalTitle(final String originalTitle) {
            this.originalTitle = originalTitle;
            return this;
        }

        public Builder setTagLine(final String tagLine) {
            this.tagLine = tagLine;
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

        public Builder setPosters(final List<String> posters) {
            this.posters = posters;
            return this;
        }

        public Builder setDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder setBudget(final int budget) {
            this.budget = budget;
            return this;
        }

        public Builder setRevenue(final int revenue) {
            this.revenue = revenue;
            return this;
        }

        public Builder setStatus(final String status) {
            this.status = status;
            return this;
        }

        public Builder setLanguage(final String language) {
            this.language = language;
            return this;
        }

        public Builder setRuntime(final int runtime) {
            this.runtime = runtime;
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

        public Builder setVotesCount(final int votesCount) {
            this.votesCount = votesCount;
            return this;
        }

        public Builder setActors(final List<PersonCreditDataModel> actors) {
            this.actors = actors;
            return this;
        }

        public Builder setDirectors(final List<PersonCreditDataModel> directors) {
            this.directors = directors;
            return this;
        }

        public Builder setWriters(final List<PersonCreditDataModel> writers) {
            this.writers = writers;
            return this;
        }

        public MovieDetailDataModel build() {
            return new MovieDetailDataModel(this);
        }
    }
}
