package com.myst3ry.data.mapper;

import com.myst3ry.data.local.entity.MovieEntity;
import com.myst3ry.data.mapper.utils.MovieConvertUtils;
import com.myst3ry.data.remote.pojo.movie.detail.MovieDetail;

public final class MovieEntityMapper {

    private static final int MOVIE_INITIAL_TYPE = 0;
    private static final double MOVIE_INITIAL_RATING = 0.0;

    public static MovieEntity transform(final MovieDetail movie) {
        return new MovieEntity(
                movie.getId(),
                MOVIE_INITIAL_TYPE,
                movie.getTitle(),
                movie.getOriginalTitle(),
                movie.getTagline(),
                movie.getReleaseDate(),
                MovieConvertUtils.convertGenres(movie.getGenres()),
                MovieConvertUtils.convertOriginalImageUrl(movie.getPosterPath()),
                MovieConvertUtils.convertPreviewImageUrl(movie.getPosterPath()),
                MovieConvertUtils.convertPosters(movie.getImages().getPosters()),
                movie.getOverview(),
                movie.getBudget(),
                movie.getRevenue(),
                movie.getStatus(),
                MovieConvertUtils.convertLanguages(movie.getSpokenLanguages()),
                movie.getRuntime(),
                MOVIE_INITIAL_RATING,
                movie.getVoteAverage(),
                movie.getVoteCount(),
                MovieConvertUtils.convertCastToActorsCredits(movie.getCredits().getCast()),
                MovieConvertUtils.convertCrewToDirectorsCredits(movie.getCredits().getCrew()),
                MovieConvertUtils.convertCrewToWritersCredits(movie.getCredits().getCrew()));
    }
}
