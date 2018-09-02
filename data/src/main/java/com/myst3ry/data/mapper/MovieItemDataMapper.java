package com.myst3ry.data.mapper;

import com.myst3ry.data.local.entity.MovieEntity;
import com.myst3ry.domain.model.item.MovieItemModel;

import java.util.ArrayList;
import java.util.List;

public final class MovieItemDataMapper {

    public static List<MovieItemModel> transform(final List<MovieEntity> entities) {
        final List<MovieItemModel> models = new ArrayList<>();
        for (final MovieEntity entity : entities) {
            models.add(transform(entity));
        }
        return models;
    }

    public static MovieItemModel transform(final MovieEntity entity) {
        return new MovieItemModel(
                entity.getId(),
                entity.getTitle(),
                entity.getPosterPreview(),
                entity.getReleaseDate(),
                entity.getGenres(),
                entity.getRating(),
                entity.getTmdbRating()
        );
    }
}
