package com.myst3ry.data.mapper;

import com.myst3ry.data.mapper.utils.MovieConvertUtils;
import com.myst3ry.data.remote.pojo.movie.find.MovieResult;
import com.myst3ry.domain.model.result.MovieResultModel;

import java.util.ArrayList;
import java.util.List;

public final class MovieResultDataMapper {

    public static List<MovieResultModel> transform(final List<MovieResult> results) {
        final List<MovieResultModel> models = new ArrayList<>();
        for (final MovieResult result : results) {
            models.add(transform(result));
        }
        return models;
    }

    public static MovieResultModel transform(final MovieResult result) {
        return new MovieResultModel(
                result.getId(),
                result.getTitle(),
                MovieConvertUtils.convertPreviewImageUrl(result.getPosterPath()),
                result.getReleaseDate()
        );
    }
}
