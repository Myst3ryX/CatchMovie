package com.myst3ry.catchmovie.model.detail;

import com.myst3ry.catchmovie.model.detail.credits.PersonCreditDataModel;

import java.util.List;

public final class TvShowDetailDataModel {

    private final int mTvShowId;
    private final int mTvShowType;
    private final String mTvShowMainPoster;
    private final String mTvShowTitle;
    private final String mTvShowOriginalTitle;
    private final String mTvShowTagLine;
    private final String mTvShowReleaseDate;
    private final List<String> mTvShowGenres;
    private final List<String> mTvShowPosters;
    private final String mTvShowDescription;
    private final String mTvShowStatus;
    private final String mTvShowProductionStatus;
    private final int mTvShowEpisodesCount;
    private final int mTvShowSeasonsCount;
    private final String mTvShowLanguage;
    private final String mTvShowNetwork;
    private final int mTvShowEpisodeRuntime;
    private final double mTvShowRating;
    private final double mTvShowTmdbRating;
    private final int mTvShowVotesCount;
    private final List<PersonCreditDataModel> mTvShowCreators;
    private final List<PersonCreditDataModel> mTvShowActors;

    private TvShowDetailDataModel(final Builder builder) {
        this.mTvShowId = builder.id;
        this.mTvShowType = builder.type;
        this.mTvShowMainPoster = builder.mainPoster;
        this.mTvShowTitle = builder.title;
        this.mTvShowOriginalTitle = builder.originalTitle;
        this.mTvShowTagLine = builder.tagLine;
        this.mTvShowReleaseDate = builder.releaseDate;
        this.mTvShowGenres = builder.genres;
        this.mTvShowPosters = builder.posters;
        this.mTvShowDescription = builder.description;
        this.mTvShowStatus = builder.status;
        this.mTvShowProductionStatus = builder.productionStatus;
        this.mTvShowEpisodesCount = builder.episodesCount;
        this.mTvShowSeasonsCount = builder.seasonsCount;
        this.mTvShowLanguage = builder.language;
        this.mTvShowNetwork = builder.network;
        this.mTvShowEpisodeRuntime = builder.episodeRuntime;
        this.mTvShowRating = builder.rating;
        this.mTvShowTmdbRating = builder.tmdbRating;
        this.mTvShowVotesCount = builder.votesCount;
        this.mTvShowCreators = builder.creators;
        this.mTvShowActors = builder.actors;
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

    public String getTvShowPoster() {
        return mTvShowMainPoster;
    }

    public String getTvShowTitle() {
        return mTvShowTitle;
    }

    public String getTvShowOriginalTitle() {
        return mTvShowOriginalTitle;
    }

    public String getTvShowTagLine() {
        return mTvShowTagLine;
    }

    public String getTvShowReleaseDate() {
        return mTvShowReleaseDate;
    }

    public List<String> getTvShowGenres() {
        return mTvShowGenres;
    }

    public List<String> getTvShowPosters() {
        return mTvShowPosters;
    }

    public String getTvShowDescription() {
        return mTvShowDescription;
    }

    public String getTvShowStatus() {
        return mTvShowStatus;
    }

    public String getTvShowProductionStatus() {
        return mTvShowProductionStatus;
    }

    public int getTvShowEpisodesCount() {
        return mTvShowEpisodesCount;
    }

    public int getTvShowSeasonsCount() {
        return mTvShowSeasonsCount;
    }

    public String getTvShowLanguage() {
        return mTvShowLanguage;
    }

    public String getTvShowNetwork() {
        return mTvShowNetwork;
    }

    public int getTvShowEpisodeRuntime() {
        return mTvShowEpisodeRuntime;
    }

    public double getTvShowRating() {
        return mTvShowRating;
    }

    public double getTvShowTmdbRating() {
        return mTvShowTmdbRating;
    }

    public int getTvShowVotesCount() {
        return mTvShowVotesCount;
    }

    public List<PersonCreditDataModel> getTvShowCreators() {
        return mTvShowCreators;
    }

    public List<PersonCreditDataModel> getTvShowActors() {
        return mTvShowActors;
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
        private String status;
        private String productionStatus;
        private int episodesCount;
        private int seasonsCount;
        private String language;
        private String network;
        private int episodeRuntime;
        private double rating;
        private double tmdbRating;
        private int votesCount;
        private List<PersonCreditDataModel> creators;
        private List<PersonCreditDataModel> actors;

        private Builder() {

        }

        public Builder setId(final int mId) {
            this.id = mId;
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

        public Builder setStatus(final String status) {
            this.status = status;
            return this;
        }

        public Builder setProductionStatus(final String productionStatus) {
            this.productionStatus = productionStatus;
            return this;
        }

        public Builder setEpisodesCount(final int episodesCount) {
            this.episodesCount = episodesCount;
            return this;
        }

        public Builder setSeasonsCount(final int seasonsCount) {
            this.seasonsCount = seasonsCount;
            return this;
        }

        public Builder setLanguage(final String language) {
            this.language = language;
            return this;
        }

        public Builder setNetwork(final String network) {
            this.network = network;
            return this;
        }

        public Builder setEpisodeRuntime(final int episodeRuntime) {
            this.episodeRuntime = episodeRuntime;
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

        public Builder setCreators(final List<PersonCreditDataModel> creators) {
            this.creators = creators;
            return this;
        }

        public Builder setActors(final List<PersonCreditDataModel> actors) {
            this.actors = actors;
            return this;
        }

        public TvShowDetailDataModel build() {
            return new TvShowDetailDataModel(this);
        }
    }
}
