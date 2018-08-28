package com.myst3ry.data.mapper;

import com.myst3ry.data.local.entity.TvShowEntity;
import com.myst3ry.data.mapper.utils.TvShowConvertUtils;
import com.myst3ry.data.remote.pojo.tvshow.detail.TvShowDetail;

public final class TvShowEntityMapper {

    private static final int TV_SHOW_INITIAL_TYPE = 0;
    private static final double TV_SHOW_INITIAL_RATING = 0.0;

    public static TvShowEntity transform(final TvShowDetail tvShow) {
        return new TvShowEntity(
                tvShow.getId(),
                TV_SHOW_INITIAL_TYPE,
                tvShow.getTitle(),
                tvShow.getOriginalTitle(),
                tvShow.getFirstAirDate(),
                TvShowConvertUtils.convertGenres(tvShow.getGenres()),
                TvShowConvertUtils.convertOriginalImageUrl(tvShow.getPosterPath()),
                TvShowConvertUtils.convertPreviewImageUrl(tvShow.getPosterPath()),
                TvShowConvertUtils.convertPosters(tvShow.getImages().getPosters()),
                tvShow.getOverview(),
                tvShow.getStatus(),
                tvShow.isInProduction(),
                tvShow.getNumberOfEpisodes(),
                tvShow.getNumberOfSeasons(),
                tvShow.getOriginalLanguage(),
                TvShowConvertUtils.convertNetworks(tvShow.getNetworks()),
                TvShowConvertUtils.convertEpisodesRuntime(tvShow.getEpisodeRunTime()),
                TV_SHOW_INITIAL_RATING,
                tvShow.getVoteAverage(),
                tvShow.getVoteCount(),
                TvShowConvertUtils.convertCreators(tvShow.getCreatedBy()),
                TvShowConvertUtils.convertCastToActorsCredits(tvShow.getCredits().getCast()));
    }
}
