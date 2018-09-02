package com.myst3ry.catchmovie.ui.movie.view;

import com.myst3ry.catchmovie.model.result.MovieResultDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface MoviesPopularView extends BaseView {

    void showPopularMovies(final List<MovieResultDataModel> movies);
}
