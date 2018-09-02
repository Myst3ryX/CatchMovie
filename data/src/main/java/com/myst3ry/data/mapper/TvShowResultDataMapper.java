package com.myst3ry.data.mapper;

import com.myst3ry.data.mapper.utils.TvShowConvertUtils;
import com.myst3ry.data.remote.pojo.tvshow.find.TvShowResult;
import com.myst3ry.domain.model.result.TvShowResultModel;

import java.util.ArrayList;
import java.util.List;

public final class TvShowResultDataMapper {

    public static List<TvShowResultModel> transform(final List<TvShowResult> results) {
        final List<TvShowResultModel> models = new ArrayList<>();
        for (final TvShowResult result : results) {
            models.add(transform(result));
        }
        return models;
    }

    public static TvShowResultModel transform(final TvShowResult result) {
        return new TvShowResultModel(
                result.getId(),
                result.getName(),
                TvShowConvertUtils.convertPreviewImageUrl(result.getPosterPath()),
                result.getFirstAirDate()
        );
    }
}
