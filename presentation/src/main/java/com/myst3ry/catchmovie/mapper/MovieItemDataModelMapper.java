package com.myst3ry.catchmovie.mapper;

import com.myst3ry.catchmovie.mapper.utils.ConvertUtils;
import com.myst3ry.catchmovie.mapper.utils.DateUtils;
import com.myst3ry.catchmovie.model.item.MovieItemDataModel;
import com.myst3ry.domain.model.item.MovieItemModel;

import java.util.ArrayList;
import java.util.List;

public final class MovieItemDataModelMapper {

    public static List<MovieItemDataModel> transform(final List<MovieItemModel> models) {
        final List<MovieItemDataModel> movies = new ArrayList<>();
        for (final MovieItemModel model : models) {
            movies.add(transform(model));
        }
        return movies;
    }

    public static MovieItemDataModel transform(final MovieItemModel model) {
        return MovieItemDataModel.newBuilder()
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
