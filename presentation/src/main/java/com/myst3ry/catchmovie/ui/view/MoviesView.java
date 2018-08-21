package com.myst3ry.catchmovie.ui.view;

import com.myst3ry.catchmovie.model.MovieDataModel;

import java.util.List;

public interface MoviesView extends BaseView {

    void setMovies(final List<MovieDataModel> movies);
}
