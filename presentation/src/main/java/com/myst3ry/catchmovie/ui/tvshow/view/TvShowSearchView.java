package com.myst3ry.catchmovie.ui.tvshow.view;

import com.myst3ry.catchmovie.model.item.TvShowItemDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface TvShowSearchView extends BaseView {

    void showTvShowsSearchResult(final List<TvShowItemDataModel> tvShows);
}

