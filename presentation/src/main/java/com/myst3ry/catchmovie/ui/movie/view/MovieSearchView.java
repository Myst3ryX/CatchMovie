package com.myst3ry.catchmovie.ui.movie.view;

import com.myst3ry.catchmovie.model.MovieDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface MovieSearchView extends BaseView {

    void showMoviesSearchResult(final List<MovieDataModel> movies);
}
