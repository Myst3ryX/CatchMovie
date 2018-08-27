package com.myst3ry.domain.model.item;

public final class PersonItemModel {

    private final int mId;
    private final String mName;
    private final String mPhoto;

    public PersonItemModel(int id, String name, String photo) {
        this.mId = id;
        this.mName = name;
        this.mPhoto = photo;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getPhoto() {
        return mPhoto;
    }
}
