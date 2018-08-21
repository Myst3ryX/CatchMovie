package com.myst3ry.catchmovie.model.mapper;

import com.myst3ry.catchmovie.model.TvShowDataModel;
import com.myst3ry.domain.model.TvShow;

import java.util.ArrayList;
import java.util.List;

public final class TvShowDataModelMapper {

    public TvShowDataModel transform(final TvShow tvShow) {
        return TvShowDataModel.newBuilder().build();
    }

    public List<TvShowDataModel> transform(final List<TvShow> tvShows) {
        final List<TvShowDataModel> tvShowsDataModels = new ArrayList<>();
        for (final TvShow tvShow : tvShows) {
            tvShowsDataModels.add(transform(tvShow));
        }
        return tvShowsDataModels;
    }
}
