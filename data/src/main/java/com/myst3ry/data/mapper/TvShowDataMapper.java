package com.myst3ry.data.mapper;

import com.myst3ry.data.local.entity.TvShowEntity;
import com.myst3ry.data.local.entity.credits.PersonCredit;
import com.myst3ry.domain.model.detail.TvShowDetailModel;
import com.myst3ry.domain.model.detail.credits.PersonCreditModel;

import java.util.ArrayList;
import java.util.List;

public final class TvShowDataMapper {

    public static List<TvShowDetailModel> transform(final List<TvShowEntity> entities) {
        final List<TvShowDetailModel> models = new ArrayList<>();
        for (final TvShowEntity entity : entities) {
            models.add(transform(entity));
        }
        return models;
    }

    public static TvShowDetailModel transform(final TvShowEntity entity) {
        return new TvShowDetailModel(
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
                entity.getStatus(),
                entity.getProductionStatus(),
                entity.getEpisodesCount(),
                entity.getSeasonsCount(),
                entity.getLanguage(),
                entity.getNetwork(),
                entity.getEpisodeRuntime(),
                entity.getRating(),
                entity.getTmdbRating(),
                entity.getVotesCount(),
                transformPersonCredits(entity.getCreators()),
                transformPersonCredits(entity.getActors())
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
