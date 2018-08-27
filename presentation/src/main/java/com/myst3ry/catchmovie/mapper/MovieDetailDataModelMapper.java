package com.myst3ry.catchmovie.mapper;

import com.myst3ry.catchmovie.model.detail.MovieDetailDataModel;
import com.myst3ry.catchmovie.model.detail.credits.PersonCreditDataModel;
import com.myst3ry.domain.model.detail.MovieDetailModel;
import com.myst3ry.domain.model.detail.credits.PersonCreditModel;

import java.util.ArrayList;
import java.util.List;

public final class MovieDetailDataModelMapper {

    public static List<MovieDetailDataModel> transform(final List<MovieDetailModel> models) {
        final List<MovieDetailDataModel> movies = new ArrayList<>();
        for (final MovieDetailModel model : models) {
            movies.add(transform(model));
        }
        return movies;
    }

    public static MovieDetailDataModel transform(final MovieDetailModel model) {
        return MovieDetailDataModel.newBuilder()
                .setId(model.getId())
                .setType(model.getType())
                .setMainPoster(model.getMainPoster())
                .setTitle(model.getTitle())
                .setOriginalTitle(model.getOriginalTitle())
                .setTagLine(model.getTagLine())
                .setReleaseDate(model.getReleaseDate())
                .setGenres(model.getGenres())
                .setPosters(model.getPosters())
                .setDescription(model.getDescription())
                .setBudget(model.getBudget())
                .setRevenue(model.getRevenue())
                .setStatus(model.getStatus())
                .setLanguage(model.getLanguage())
                .setRuntime(model.getRuntime())
                .setRating(model.getRating())
                .setTmdbRating(model.getTmdbRating())
                .setVotesCount(model.getVotesCount())
                .setActors(transformPersonsCredits(model.getActors()))
                .setDirectors(transformPersonsCredits(model.getDirectors()))
                .setWriters(transformPersonsCredits(model.getWriters()))
                .build();
    }

    private static List<PersonCreditDataModel> transformPersonsCredits(final List<PersonCreditModel> persons) {
        final List<PersonCreditDataModel> credits = new ArrayList<>();
        for (final PersonCreditModel person : persons) {
            credits.add(new PersonCreditDataModel(person.getId(), person.getName(), person.getCharacter(), person.getPhoto()));
        }
        return credits;
    }
}
