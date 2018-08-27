package com.myst3ry.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverters;

import com.myst3ry.data.local.converter.ArrayListConverter;
import com.myst3ry.data.local.converter.CastCreditListConverter;
import com.myst3ry.data.local.entity.credits.PersonCredit;

import java.util.List;

@Entity(tableName = "Movies", primaryKeys = {"id", "type"})
public final class MovieEntity {

    @ColumnInfo(name = "id")
    private final int mId;

    @ColumnInfo(name = "type")
    private final int mType;

    @ColumnInfo(name = "title")
    private final String mTitle;

    @ColumnInfo(name = "original_title")
    private final String mOriginalTitle;

    @ColumnInfo(name = "tagline")
    private final String mTagLine;

    @ColumnInfo(name = "release_date")
    private final String mReleaseDate;

    @ColumnInfo(name = "genres")
    @TypeConverters(ArrayListConverter.class)
    private final List<String> mGenres;

    @ColumnInfo(name = "main_poster")
    private final String mMainPoster;

    @ColumnInfo(name = "posters")
    @TypeConverters(ArrayListConverter.class)
    private final List<String> mPosters;

    @ColumnInfo(name = "description")
    private final String mDescription;

    @ColumnInfo(name = "budget")
    private final int mBudget;

    @ColumnInfo(name = "revenue")
    private final int mRevenue;

    @ColumnInfo(name = "status")
    private final String mStatus;

    @ColumnInfo(name = "language")
    private final String mLanguage;

    @ColumnInfo(name = "runtime")
    private final int mRuntime;

    @ColumnInfo(name = "rating")
    private final double mRating;

    @ColumnInfo(name = "tmdb_rating")
    private final double mTmdbRating;

    @ColumnInfo(name = "votes_count")
    private final int mVotesCount;

    @ColumnInfo(name = "actors")
    @TypeConverters(CastCreditListConverter.class)
    private final List<PersonCredit> mActors;

    @ColumnInfo(name = "directors")
    @TypeConverters(CastCreditListConverter.class)
    private final List<PersonCredit> mDirectors;

    @ColumnInfo(name = "writers")
    @TypeConverters(CastCreditListConverter.class)
    private final List<PersonCredit> mWriters;

    public MovieEntity(int id, int type, String title, String originalTitle,
                       String tagLine, String releaseDate, List<String> genres,
                       String mainPoster, List<String> posters, String description,
                       int budget, int revenue, String status, String language,
                       int runtime, double rating, double tmdbRating, int votesCount,
                       List<PersonCredit> actors, List<PersonCredit> directors, List<PersonCredit> writers) {
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

    public String getMainPoster() {
        return mMainPoster;
    }

    public List<String> getPosters() {
        return mPosters;
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

    public List<PersonCredit> getActors() {
        return mActors;
    }

    public List<PersonCredit> getDirectors() {
        return mDirectors;
    }

    public List<PersonCredit> getWriters() {
        return mWriters;
    }
}
