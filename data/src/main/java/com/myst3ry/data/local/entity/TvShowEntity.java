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

    @ColumnInfo(name = "status")
    private final String mStatus;

    @ColumnInfo(name = "production_status")
    private final String mProductionStatus;

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
    private final double mRating;

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
                        String tagLine, String releaseDate, List<String> genres,
                        String mainPoster, List<String> posters, String description,
                        String status, String productionStatus, int episodesCount, int seasonsCount,
                        String language, String network, int episodeRuntime, double rating, double tmdbRating,
                        int votesCount, List<PersonCredit> creators, List<PersonCredit> actors) {
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

    public List<PersonCredit> getCreators() {
        return mCreators;
    }

    public List<PersonCredit> getActors() {
        return mActors;
    }
}
