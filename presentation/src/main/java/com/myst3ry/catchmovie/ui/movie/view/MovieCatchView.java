package com.myst3ry.catchmovie.ui.movie.view;

import com.myst3ry.catchmovie.model.MovieDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

public interface MovieCatchView extends BaseView {

    void showMovieCatchResult(final MovieDataModel movie);
}
