package com.myst3ry.domain.model.types;

public enum MovieType {
    RECENT(0), WATCHLIST(1), FAVORITE(2);

    private static final MovieType mTypes[] = values();
    private int mType;

    MovieType(final int type) {
        this.mType = type;
    }

    public static MovieType[] getValues() {
        return mTypes;
    }

    public int getType() {
        return mType;
    }
}
