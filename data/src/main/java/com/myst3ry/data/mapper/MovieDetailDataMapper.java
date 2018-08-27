package com.myst3ry.data.mapper;

import com.myst3ry.data.local.entity.MovieEntity;
import com.myst3ry.data.local.entity.credits.PersonCredit;
import com.myst3ry.domain.model.detail.MovieDetailModel;
import com.myst3ry.domain.model.detail.credits.PersonCreditModel;

import java.util.ArrayList;
import java.util.List;

public final class MovieDetailDataMapper {

    public static List<MovieDetailModel> transform(final List<MovieEntity> entities) {
        final List<MovieDetailModel> models = new ArrayList<>();
        for (final MovieEntity entity : entities) {
            models.add(transform(entity));
        }
        return models;
    }

    public static MovieDetailModel transform(final MovieEntity entity) {
        return new MovieDetailModel(
                entity.getId(),
                entity.getType(),
                entity.getTitle(),
                entity.getOriginalTitle(),
                entity.getTagLine(),
                entity.getReleaseDate(),
                entity.getGenres(),
                entity.getMainPoster(),
                entity.getPosters(),
                entity.getDescription(),
                entity.getBudget(),
                entity.getRevenue(),
                entity.getStatus(),
                entity.getLanguage(),
                entity.getRuntime(),
                entity.getRating(),
                entity.getTmdbRating(),
                entity.getVotesCount(),
                transformPersonCredits(entity.getActors()),
                transformPersonCredits(entity.getDirectors()),
                transformPersonCredits(entity.getWriters())
        );
    }

    private static List<PersonCreditModel> transformPersonCredits(final List<PersonCredit> credits) {
        final List<PersonCreditModel> models = new ArrayList<>();
        for (final PersonCredit credit : credits) {
            models.add(new PersonCreditModel(credit.getId(), credit.getName(), credit.getCharacter(), credit.getPhoto()));
        }
        return models;
    }
}
