package com.myst3ry.catchmovie.mapper;

import com.myst3ry.catchmovie.mapper.utils.DateUtils;
import com.myst3ry.catchmovie.model.result.MovieResultDataModel;
import com.myst3ry.domain.model.result.MovieResultModel;

import java.util.ArrayList;
import java.util.List;

public final class MovieResultDataModelMapper {

    public static List<MovieResultDataModel> transform(final List<MovieResultModel> models) {
        final List<MovieResultDataModel> movies = new ArrayList<>();
        for (final MovieResultModel model : models) {
            movies.add(transform(model));
        }
        return movies;
    }

    public static MovieResultDataModel transform(final MovieResultModel model) {
        return MovieResultDataModel.newBuilder()
                .setId(model.getId())
                .setPoster(model.getPoster())
                .setTitle(model.getTitle())
                .setReleaseDate(DateUtils.parseDateToYear(model.getReleaseDate()))
                .build();
    }
}
