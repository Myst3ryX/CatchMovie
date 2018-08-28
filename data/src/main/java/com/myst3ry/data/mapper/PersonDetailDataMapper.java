package com.myst3ry.data.mapper;

import com.myst3ry.data.local.entity.PersonEntity;
import com.myst3ry.data.local.entity.credits.MovieCredit;
import com.myst3ry.data.local.entity.credits.TvShowCredit;
import com.myst3ry.domain.model.detail.PersonDetailModel;
import com.myst3ry.domain.model.detail.credits.MovieCreditModel;
import com.myst3ry.domain.model.detail.credits.TvShowCreditModel;

import java.util.ArrayList;
import java.util.List;

public final class PersonDetailDataMapper {

    public static List<PersonDetailModel> transform(final List<PersonEntity> entities) {
        final List<PersonDetailModel> models = new ArrayList<>();
        for (final PersonEntity entity : entities) {
            models.add(transform(entity));
        }
        return models;
    }

    public static PersonDetailModel transform(final PersonEntity entity) {
        return new PersonDetailModel(
                entity.getId(),
                entity.getName(),
                entity.getKnownAs(),
                entity.getBirthday(),
                entity.getDeathday(),
                entity.getBiography(),
                entity.getPhoto(),
                entity.getPhotoPreview(),
                transformTvShowsCredits(entity.getTvShowsCredits()),
                transformMoviesCredits(entity.getMoviesCredits())
        );
    }

    private static List<TvShowCreditModel> transformTvShowsCredits(final List<TvShowCredit> credits) {
        final List<TvShowCreditModel> models = new ArrayList<>();
        for (final TvShowCredit credit : credits) {
            models.add(new TvShowCreditModel(credit.getId(), credit.getTitle(), credit.getPoster()));
        }
        return models;
    }

    private static List<MovieCreditModel> transformMoviesCredits(final List<MovieCredit> credits) {
        final List<MovieCreditModel> models = new ArrayList<>();
        for (final MovieCredit credit : credits) {
            models.add(new MovieCreditModel(credit.getId(), credit.getTitle(), credit.getPoster()));
        }
        return models;
    }
}
