package com.myst3ry.catchmovie.ui.movie.view;

import com.myst3ry.catchmovie.model.item.MovieItemDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface MoviesView extends BaseView {

    void setMovies(final List<MovieItemDataModel> movies);

    void showEmptyText();

    void hideEmptyText();
}
