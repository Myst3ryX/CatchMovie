package com.myst3ry.catchmovie.model;

public class Actor {

    private int actorPhotoImage;
    private String actorFullName;
//    private List<Movie> actorMovies;
//    private List<TvShow> actorTvShows;

    public int getActorPhotoImage() {
        return actorPhotoImage;
    }

    public void setActorPhotoImage(int actorPhotoImage) {
        this.actorPhotoImage = actorPhotoImage;
    }

    public String getActorFullName() {
        return actorFullName;
    }

    public void setActorFullName(String actorFullName) {
        this.actorFullName = actorFullName;
    }
}
