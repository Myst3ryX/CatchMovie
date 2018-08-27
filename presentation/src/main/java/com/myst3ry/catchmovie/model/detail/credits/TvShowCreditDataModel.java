package com.myst3ry.catchmovie.model.detail.credits;

public final class TvShowCreditDataModel {

    private final int mId;
    private final String mTitle;
    private final String mPoster;

    public TvShowCreditDataModel(int id, String title, String poster) {
        this.mId = id;
        this.mTitle = title;
        this.mPoster = poster;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getPoster() {
        return mPoster;
    }
}
