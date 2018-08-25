package com.myst3ry.catchmovie.ui.tvshow.view;

import com.myst3ry.catchmovie.model.TvShowDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface TvShowSearchView extends BaseView {

    void showTvShowsSearchResult(final List<TvShowDataModel> tvShows);
}

