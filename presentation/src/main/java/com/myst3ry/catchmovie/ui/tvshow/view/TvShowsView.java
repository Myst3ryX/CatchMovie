package com.myst3ry.catchmovie.ui.tvshow.view;

import com.myst3ry.catchmovie.model.TvShowDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface TvShowsView extends BaseView {

    void setTvShows(final List<TvShowDataModel> tvShows);

    void showEmptyText();

    void hideEmptyText();
}
