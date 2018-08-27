package com.myst3ry.catchmovie.ui.movie.view;

import com.myst3ry.catchmovie.model.detail.MovieDetailDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

public interface MovieDetailView extends BaseView {

    void setMovieDetails(final MovieDetailDataModel movie);
}
