package com.myst3ry.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverters;

import com.myst3ry.data.local.converter.ArrayListConverter;
import com.myst3ry.data.local.converter.CastCreditListConverter;
import com.myst3ry.data.local.entity.credits.PersonCredit;

import java.util.List;

@Entity(tableName = "TVShows", primaryKeys = {"id", "type"})
public final class TvShowEntity {

    @ColumnInfo(name = "id")
    private final int mId;

    @ColumnInfo(name = "type")
    private final int mType;

    @ColumnInfo(name = "title")
    private final String mTitle;

    @ColumnInfo(name = "original_title")
    private final String mOriginalTitle;

    @ColumnInfo(name = "first_air_date")
    private final String mFirstAirDate;

    @ColumnInfo(name = "genres")
    @TypeConverters(ArrayListConverter.class)
    private final List<String> mGenres;

    @ColumnInfo(name = "poster")
    private final String mPoster;

    @ColumnInfo(name = "poster_preview")
    private final String mPosterPreview;

    @ColumnInfo(name = "posters")
    @TypeConverters(ArrayListConverter.class)
    private final List<String> mAllPosters;

    @ColumnInfo(name = "description")
    private final String mDescription;

    @ColumnInfo(name = "status")
    private final String mStatus;

    @ColumnInfo(name = "is_in_production")
    private final boolean mIsInProduction;

    @ColumnInfo(name = "episodes_count")
    private final int mEpisodesCount;

    @ColumnInfo(name = "seasons_count")
    private final int mSeasonsCount;

    @ColumnInfo(name = "language")
    private final String mLanguage;

    @ColumnInfo(name = "network")
    private final String mNetwork;

    @ColumnInfo(name = "episode_runtime")
    private final int mEpisodeRuntime;

    @ColumnInfo(name = "rating")
    private double mRating;

    @ColumnInfo(name = "tmdb_rating")
    private final double mTmdbRating;

    @ColumnInfo(name = "votes_count")
    private final int mVotesCount;

    @ColumnInfo(name = "creators")
    @TypeConverters(CastCreditListConverter.class)
    private final List<PersonCredit> mCreators;

    @ColumnInfo(name = "actors")
    @TypeConverters(CastCreditListConverter.class)
    private final List<PersonCredit> mActors;

    public TvShowEntity(int id, int type, String title, String originalTitle,
                        String firstAirDate, List<String> genres, String poster,
                        String posterPreview, List<String> allPosters, String description,
                        String status, boolean isInProduction, int episodesCount, int seasonsCount,
                        String language, String network, int episodeRuntime, double rating,
                        double tmdbRating, int votesCount, List<PersonCredit> creators, List<PersonCredit> actors) {
        this.mId = id;
        this.mType = type;
        this.mTitle = title;
        this.mOriginalTitle = originalTitle;
        this.mFirstAirDate = firstAirDate;
        this.mGenres = genres;
        this.mPoster = poster;
        this.mPosterPreview = posterPreview;
        this.mAllPosters = allPosters;
        this.mDescription = description;
        this.mStatus = status;
        this.mIsInProduction = isInProduction;
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

    public String getFirstAirDate() {
        return mFirstAirDate;
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

    public String getStatus() {
        return mStatus;
    }

    public boolean isIsInProduction() {
        return mIsInProduction;
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

    public List<PersonCredit> getCreators() {
        return mCreators;
    }

    public List<PersonCredit> getActors() {
        return mActors;
    }

    public void setRating(final double rating) {
        this.mRating = rating;
    }
}
