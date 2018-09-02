package com.myst3ry.catchmovie.ui.movie.view;

import com.myst3ry.catchmovie.model.result.MovieResultDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface MoviesSearchView extends BaseView {

    void showMoviesSearchResult(final List<MovieResultDataModel> movies);

    void showEmptyText();

    void hideEmptyText();
}
