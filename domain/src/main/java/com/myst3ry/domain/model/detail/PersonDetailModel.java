package com.myst3ry.domain.model.detail;

import com.myst3ry.domain.model.detail.credits.MovieCreditModel;
import com.myst3ry.domain.model.detail.credits.TvShowCreditModel;

import java.util.List;

public final class PersonDetailModel {

    private final int mId;
    private final String mName;
    private final String mKnownAs;
    private final String mBirthday;
    private final String mDeathday;
    private final String mBiography;
    private final String mPhoto;
    private final List<TvShowCreditModel> mTvShowsCredits;
    private final List<MovieCreditModel> mMoviesCredits;

    public PersonDetailModel(int id, String name, String knownAs, String birthday,
                             String deathday, String biography, String photo,
                             List<TvShowCreditModel> tvShowsCredits, List<MovieCreditModel> moviesCredits) {
        this.mId = id;
        this.mName = name;
        this.mKnownAs = knownAs;
        this.mBirthday = birthday;
        this.mDeathday = deathday;
        this.mBiography = biography;
        this.mPhoto = photo;
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

    public String getPhoto() {
        return mPhoto;
    }

    public List<TvShowCreditModel> getTvShowsCredits() {
        return mTvShowsCredits;
    }

    public List<MovieCreditModel> getMoviesCredits() {
        return mMoviesCredits;
    }
}
