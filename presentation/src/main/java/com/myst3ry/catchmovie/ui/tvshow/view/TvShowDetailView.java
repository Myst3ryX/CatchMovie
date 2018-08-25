package com.myst3ry.catchmovie.ui.tvshow.view;

import com.myst3ry.catchmovie.model.TvShowDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface TvShowDetailView extends BaseView {

    void setTvShowDetails(final TvShowDataModel tvShow);

    void setTvShowPosters(final List<String> posters);
}