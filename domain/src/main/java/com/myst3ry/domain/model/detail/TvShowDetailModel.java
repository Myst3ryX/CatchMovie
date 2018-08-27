package com.myst3ry.domain.model.detail;

import com.myst3ry.domain.model.detail.credits.PersonCreditModel;

import java.util.List;

public final class TvShowDetailModel {

    private final int mId;
    private final int mType;
    private final String mTitle;
    private final String mOriginalTitle;
    private final String mTagLine;
    private final String mReleaseDate;
    private final List<String> mGenres;
    private final String mMainPoster;
    private final List<String> mPosters;
    private final String mDescription;
    private final String mStatus;
    private final String mProductionStatus;
    private final int mEpisodesCount;
    private final int mSeasonsCount;
    private final String mLanguage;
    private final String mNetwork;
    private final int mEpisodeRuntime;
    private final double mRating;
    private final double mTmdbRating;
    private final int mVotesCount;
    private final List<PersonCreditModel> mCreators;
    private final List<PersonCreditModel> mActors;

    public TvShowDetailModel(int id, int type, String title, String originalTitle,
                             String tagLine, String releaseDate, List<String> genres,
                             String mainPoster, List<String> posters, String description,
                             String status, String productionStatus, int episodesCount, int seasonsCount,
                             String language, String network, int episodeRuntime, double rating, double tmdbRating,
                             int votesCount, List<PersonCreditModel> creators, List<PersonCreditModel> actors) {
        this.mId = id;
        this.mType = type;
        this.mTitle = title;
        this.mOriginalTitle = originalTitle;
        this.mTagLine = tagLine;
        this.mReleaseDate = releaseDate;
        this.mGenres = genres;
        this.mMainPoster = mainPoster;
        this.mPosters = posters;
        this.mDescription = description;
        this.mStatus = status;
        this.mProductionStatus = productionStatus;
        this.mEpisodesCount = episodesCount;
        this.mSeasonsCount = seasonsCount;
        this.mLanguage = language;
        this.mNetwork = network;
        this.mEpisodeRuntime = episodeRuntime;
        this.mRating = rating;
        this.mTmdbRating = tmdbRating;
        this.mVotesCount = votesCount;
        this.mCreators = creators;
        this.mActors = actors;
    }

    public int getId() {
        return mId;
    }

    public int getType() {
        return mType;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public String getTagLine() {
        return mTagLine;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public List<String> getGenres() {
        return mGenres;
    }

    public String getMainPoster() {
        return mMainPoster;
    }

    public List<String> getPosters() {
        return mPosters;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getStatus() {
        return mStatus;
    }

    public String getProductionStatus() {
        return mProductionStatus;
    }

    public int getEpisodesCount() {
        return mEpisodesCount;
    }

    public int getSeasonsCount() {
        return mSeasonsCount;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public String getNetwork() {
        return mNetwork;
    }

    public int getEpisodeRuntime() {
        return mEpisodeRuntime;
    }

    public double getRating() {
        return mRating;
    }

    public double getTmdbRating() {
        return mTmdbRating;
    }

    public int getVotesCount() {
        return mVotesCount;
    }

    public List<PersonCreditModel> getCreators() {
        return mCreators;
    }

    public List<PersonCreditModel> getActors() {
        return mActors;
    }
}
