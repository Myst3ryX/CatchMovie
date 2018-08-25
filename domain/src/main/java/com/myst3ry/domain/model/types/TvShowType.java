package com.myst3ry.domain.model.types;

public enum TvShowType {
    RECENT, WATCHLIST, FAVORITE;

    private static final TvShowType mTypes[] = values();

    public static TvShowType[] getValues() {
        return mTypes;
    }
}
