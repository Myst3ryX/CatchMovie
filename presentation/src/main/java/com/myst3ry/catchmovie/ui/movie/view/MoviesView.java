package com.myst3ry.catchmovie.ui.movie.view;

import com.myst3ry.catchmovie.model.MovieDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface MoviesView extends BaseView {

    void setMovies(final List<MovieDataModel> movies);

    void showEmptyText();

    void hideEmptyText();
}
