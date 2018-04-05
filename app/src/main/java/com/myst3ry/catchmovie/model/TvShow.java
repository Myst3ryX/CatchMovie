package com.myst3ry.catchmovie.model;

public class TvShow {

    public static final int RECENT = 1;
    public static final int FAVORITE = 2;
    public static final int WATCH = 3;

    private int tvShowPosterImage;

    private String tvShowReleaseYear;
    private String tvShowTitle;
    private String tvShowGenre;

    private String tvShowRating;
    private String tvShowTmdbRating;

    public int getTvShowPosterImage() {
        return tvShowPosterImage;
    }

    public void setTvShowPosterImage(int tvShowPosterImage) {
        this.tvShowPosterImage = tvShowPosterImage;
    }

    public String getTvShowReleaseYear() {
        return tvShowReleaseYear;
    }

    public void setTvShowReleaseYear(String tvShowReleaseYear) {
        this.tvShowReleaseYear = tvShowReleaseYear;
    }

    public String getTvShowTitle() {
        return tvShowTitle;
    }

    public void setTvShowTitle(String tvShowTitle) {
        this.tvShowTitle = tvShowTitle;
    }

    public String getTvShowGenre() {
        return tvShowGenre;
    }

    public void setTvShowGenre(String tvShowGenre) {
        this.tvShowGenre = tvShowGenre;
    }

    public String getTvShowRating() {
        return tvShowRating;
    }

    public void setTvShowRating(String tvShowRating) {
        this.tvShowRating = tvShowRating;
    }

    public String getTvShowTmdbRating() {
        return tvShowTmdbRating;
    }

    public void setTvShowTmdbRating(String tvShowTmdbRating) {
        this.tvShowTmdbRating = tvShowTmdbRating;
    }
}
