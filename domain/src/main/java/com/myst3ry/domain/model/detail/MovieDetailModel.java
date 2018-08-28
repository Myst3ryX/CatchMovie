package com.myst3ry.domain.model.detail;

import com.myst3ry.domain.model.detail.credits.PersonCreditModel;

import java.util.List;

public final class MovieDetailModel {

    private final int mId;
    private final int mType;
    private final String mTitle;
    private final String mOriginalTitle;
    private final String mTagLine;
    private final String mReleaseDate;
    private final List<String> mGenres;
    private final String mPoster;
    private final String mPosterPreview;
    private final List<String> mAllPosters;
    private final String mDescription;
    private final int mBudget;
    private final int mRevenue;
    private final String mStatus;
    private final String mLanguage;
    private final int mRuntime;
    private final double mRating;
    private final double mTmdbRating;
    private final int mVotesCount;
    private final List<PersonCreditModel> mActors;
    private final List<PersonCreditModel> mDirectors;
    private final List<PersonCreditModel> mWriters;

    public MovieDetailModel(int id, int type, String title, String originalTitle,
                            String tagLine, String releaseDate, List<String> genres,
                            String poster, String posterPreview, List<String> allPosters,
                            String description, int budget, int revenue, String status,
                            String language, int runtime, double rating, double tmdbRating,
                            int votesCount, List<PersonCreditModel> actors,
                            List<PersonCreditModel> directors, List<PersonCreditModel> writers) {
        this.mId = id;
        this.mType = type;
        this.mTitle = title;
        this.mOriginalTitle = originalTitle;
        this.mTagLine = tagLine;
        this.mReleaseDate = releaseDate;
        this.mGenres = genres;
        this.mPoster = poster;
        this.mPosterPreview = posterPreview;
        this.mAllPosters = allPosters;
        this.mDescription = description;
        this.mBudget = budget;
        this.mRevenue = revenue;
        this.mStatus = status;
        this.mLanguage = language;
        this.mRuntime = runtime;
        this.mRating = rating;
        this.mTmdbRating = tmdbRating;
        this.mVotesCount = votesCount;
        this.mActors = actors;
        this.mDirectors = directors;
        this.mWriters = writers;
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

    public String getPoster() {
        return mPoster;
    }

    public String getPosterPreview() {
        return mPosterPreview;
    }

    public List<String> getAllPosters() {
        return mAllPosters;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getBudget() {
        return mBudget;
    }

    public int getRevenue() {
        return mRevenue;
    }

    public String getStatus() {
        return mStatus;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public int getRuntime() {
        return mRuntime;
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

    public List<PersonCreditModel> getActors() {
        return mActors;
    }

    public List<PersonCreditModel> getDirectors() {
        return mDirectors;
    }

    public List<PersonCreditModel> getWriters() {
        return mWriters;
    }
}
