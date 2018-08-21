package com.myst3ry.catchmovie.ui.view;

import com.myst3ry.catchmovie.model.TvShowDataModel;

import java.util.List;

public interface TvShowsView extends BaseView {

    void setTvShows(final List<TvShowDataModel> tvShows);
}
