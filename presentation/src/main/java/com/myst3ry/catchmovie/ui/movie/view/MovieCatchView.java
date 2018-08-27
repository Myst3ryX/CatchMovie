package com.myst3ry.catchmovie.ui.movie.view;

import com.myst3ry.catchmovie.model.item.MovieItemDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

public interface MovieCatchView extends BaseView {

    void showMovieCatchResult(final MovieItemDataModel movie);
}
