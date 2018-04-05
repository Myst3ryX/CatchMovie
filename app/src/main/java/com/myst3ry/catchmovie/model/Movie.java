package com.myst3ry.catchmovie.model;

public class Movie {

    public static final int RECENT = 1;
    public static final int WATCH = 2;
    public static final int FAVORITE = 3;

    private int moviePosterImage;

    private String movieReleaseYear;
    private String movieTitle;
    private String movieGenre;

    private String movieTmdbRating;
    private String movieRating;

    public int getMoviePosterImage() {
        return moviePosterImage;
    }

    public void setMoviePosterImage(int moviePosterImage) {
        this.moviePosterImage = moviePosterImage;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieReleaseYear() {
        return movieReleaseYear;
    }

    public void setMovieReleaseYear(String movieReleaseYear) {
        this.movieReleaseYear = movieReleaseYear;
    }

    public String getMovieTmdbRating() {
        return movieTmdbRating;
    }

    public void setMovieTmdbRating(String movieTmdbRating) {
        this.movieTmdbRating = movieTmdbRating;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }
}
