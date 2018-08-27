package com.myst3ry.data.mapper;

import com.myst3ry.data.local.entity.TvShowEntity;
import com.myst3ry.domain.model.item.TvShowItemModel;

import java.util.ArrayList;
import java.util.List;

public final class TvShowItemDataMapper {

    public static List<TvShowItemModel> transform(final List<TvShowEntity> entities) {
        final List<TvShowItemModel> models = new ArrayList<>();
        for (final TvShowEntity entity : entities) {
            models.add(transform(entity));
        }
        return models;
    }

    public static TvShowItemModel transform(final TvShowEntity entity) {
        return new TvShowItemModel(
                entity.getId(),
                entity.getType(),
                entity.getTitle(),
                entity.getMainPoster(),
                entity.getReleaseDate(),
                entity.getGenres(),
                entity.getRating(),
                entity.getTmdbRating()
        );
    }
}
