package com.myst3ry.catchmovie.ui.tvshow.view;

import com.myst3ry.catchmovie.model.result.TvShowResultDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface TvShowsPopularView extends BaseView {

    void showPopularTvShows(final List<TvShowResultDataModel> tvShows);
}

