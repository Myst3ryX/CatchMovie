package com.myst3ry.domain.model.detail.credits;

public final class PersonCreditModel {

    private final int mId;
    private final String mName;
    private final String mCharacter;
    private final String mPhoto;

    public PersonCreditModel(int id, String name, String character, String photo) {
        this.mId = id;
        this.mName = name;
        this.mCharacter = character;
        this.mPhoto = photo;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getCharacter() {
        return mCharacter;
    }

    public String getPhoto() {
        return mPhoto;
    }
}
