package com.myst3ry.data.remote.pojo.person.find;

import com.google.gson.annotations.SerializedName;

public final class PersonResult {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("popularity")
    private double mPopularity;

    @SerializedName("profile_path")
    private String mProfilePath;

    @SerializedName("adult")
    private boolean mAdult;

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public String getProfilePath() {
        return mProfilePath;
    }

    public boolean isAdult() {
        return mAdult;
    }
}