package com.myst3ry.catchmovie.mapper;

import com.myst3ry.catchmovie.mapper.utils.DateUtils;
import com.myst3ry.catchmovie.model.result.TvShowResultDataModel;
import com.myst3ry.domain.model.result.TvShowResultModel;

import java.util.ArrayList;
import java.util.List;

public final class TvShowResultDataModelMapper {

    public static List<TvShowResultDataModel> transform(final List<TvShowResultModel> models) {
        final List<TvShowResultDataModel> tvShows = new ArrayList<>();
        for (final TvShowResultModel model : models) {
            tvShows.add(transform(model));
        }
        return tvShows;
    }

    public static TvShowResultDataModel transform(final TvShowResultModel model) {
        return TvShowResultDataModel.newBuilder()
                .setId(model.getId())
                .setPoster(model.getPoster())
                .setTitle(model.getTitle())
                .setReleaseDate(DateUtils.parseDateToYear(model.getReleaseDate()))
                .build();
    }
}
