package com.myst3ry.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.myst3ry.data.local.converter.MoviesCreditsListConverter;
import com.myst3ry.data.local.converter.TvShowsCreditsListConverter;
import com.myst3ry.data.local.entity.credits.MovieCredit;
import com.myst3ry.data.local.entity.credits.TvShowCredit;

import java.util.List;

@Entity(tableName = "Persons")
public final class PersonEntity {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private final int mId;

    @ColumnInfo(name = "name")
    private final String mName;

    @ColumnInfo(name = "known_as")
    private final String mKnownAs;

    @ColumnInfo(name = "birthday")
    private final String mBirthday;

    @ColumnInfo(name = "deathday")
    private final String mDeathday;

    @ColumnInfo(name = "biography")
    private final String mBiography;

    @ColumnInfo(name = "photo")
    private final String mPhotoImage;

    @ColumnInfo(name = "tv_show_credits")
    @TypeConverters(TvShowsCreditsListConverter.class)
    private final List<TvShowCredit> mTvShowsCredits;

    @ColumnInfo(name = "movies")
    @TypeConverters(MoviesCreditsListConverter.class)
    private final List<MovieCredit> mMoviesCredits;

    public PersonEntity(int id, String name, String knownAs, String birthday,
                        String deathday, String biography, String photoImage,
                        List<TvShowCredit> tvShowsCredits, List<MovieCredit> moviesCredits) {
        this.mId = id;
        this.mName = name;
        this.mKnownAs = knownAs;
        this.mBirthday = birthday;
        this.mDeathday = deathday;
        this.mBiography = biography;
        this.mPhotoImage = photoImage;
        this.mTvShowsCredits = tvShowsCredits;
        this.mMoviesCredits = moviesCredits;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getKnownAs() {
        return mKnownAs;
    }

    public String getBirthday() {
        return mBirthday;
    }

    public String getDeathday() {
        return mDeathday;
    }

    public String getBiography() {
        return mBiography;
    }

    public String getPhotoImage() {
        return mPhotoImage;
    }

    public List<TvShowCredit> getTvShowsCredits() {
        return mTvShowsCredits;
    }

    public List<MovieCredit> getMoviesCredits() {
        return mMoviesCredits;
    }
}
