package com.myst3ry.data.local.entity.credits;

public final class TvShowCredit {

    private final int mId;
    private final String mTitle;
    private final String mPoster;

    public TvShowCredit(int id, String title, String poster) {
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
