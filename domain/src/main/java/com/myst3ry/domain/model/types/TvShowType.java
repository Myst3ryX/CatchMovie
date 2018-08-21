package com.myst3ry.domain.model.types;

public enum TvShowType {
    RECENT(0), WATCHLIST(1), FAVORITE(2);

    private static final TvShowType mTypes[] = values();
    private int mType;

    TvShowType(final int type) {
        this.mType = type;
    }

    public static TvShowType[] getValues() {
        return mTypes;
    }

    public int getType() {
        return mType;
    }
}
