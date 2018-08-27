package com.myst3ry.catchmovie.mapper;

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
                .setType(model.getType())
                .setPoster(model.getPoster())
                .setTitle(model.getTitle())
                .setReleaseDate(model.getReleaseDate())
                .setGenres(model.getGenres())
                .setRating(model.getRating())
                .setTmdbRating(model.getTmdbRating())
                .build();
    }
}
