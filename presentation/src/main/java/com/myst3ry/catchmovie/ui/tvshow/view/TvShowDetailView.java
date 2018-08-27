package com.myst3ry.catchmovie.ui.tvshow.view;

import com.myst3ry.catchmovie.model.detail.TvShowDetailDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

public interface TvShowDetailView extends BaseView {

    void setTvShowDetails(final TvShowDetailDataModel tvShow);
}