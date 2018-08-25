package com.myst3ry.domain.model.types;

public enum MovieType {
    RECENT, WATCHLIST, FAVORITE;

    private static final MovieType mTypes[] = values();

    public static MovieType[] getValues() {
        return mTypes;
    }
}
