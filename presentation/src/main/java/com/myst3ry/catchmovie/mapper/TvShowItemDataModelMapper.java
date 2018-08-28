package com.myst3ry.catchmovie.mapper;

import com.myst3ry.catchmovie.mapper.utils.ConvertUtils;
import com.myst3ry.catchmovie.mapper.utils.DateUtils;
import com.myst3ry.catchmovie.model.item.TvShowItemDataModel;
import com.myst3ry.domain.model.item.TvShowItemModel;

import java.util.ArrayList;
import java.util.List;

public final class TvShowItemDataModelMapper {

    public static List<TvShowItemDataModel> transform(final List<TvShowItemModel> models) {
        final List<TvShowItemDataModel> tvShows = new ArrayList<>();
        for (final TvShowItemModel model : models) {
            tvShows.add(transform(model));
        }
        return tvShows;
    }

    public static TvShowItemDataModel transform(final TvShowItemModel model) {
        return TvShowItemDataModel.newBuilder()
                .setId(model.getId())
                .setPoster(model.getPoster())
                .setTitle(model.getTitle())
                .setReleaseDate(DateUtils.parseDateToYear(model.getReleaseDate()))
                .setGenres(ConvertUtils.convertGenresToString(model.getGenres()))
                .setRating(ConvertUtils.convertRating(model.getRating()))
                .setTmdbRating(ConvertUtils.convertTmdbRating(model.getTmdbRating()))
                .build();
    }
}
