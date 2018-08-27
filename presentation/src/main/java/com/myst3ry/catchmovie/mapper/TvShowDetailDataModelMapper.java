package com.myst3ry.catchmovie.mapper;

import com.myst3ry.catchmovie.model.detail.TvShowDetailDataModel;
import com.myst3ry.catchmovie.model.detail.credits.PersonCreditDataModel;
import com.myst3ry.domain.model.detail.TvShowDetailModel;
import com.myst3ry.domain.model.detail.credits.PersonCreditModel;

import java.util.ArrayList;
import java.util.List;

public final class TvShowDetailDataModelMapper {

    public static List<TvShowDetailDataModel> transform(final List<TvShowDetailModel> models) {
        final List<TvShowDetailDataModel> tvShows = new ArrayList<>();
        for (final TvShowDetailModel model : models) {
            tvShows.add(transform(model));
        }
        return tvShows;
    }

    public static TvShowDetailDataModel transform(final TvShowDetailModel model) {
        return TvShowDetailDataModel.newBuilder()
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
                .setStatus(model.getStatus())
                .setProductionStatus(model.getProductionStatus())
                .setEpisodesCount(model.getEpisodesCount())
                .setSeasonsCount(model.getSeasonsCount())
                .setLanguage(model.getLanguage())
                .setNetwork(model.getNetwork())
                .setEpisodeRuntime(model.getEpisodeRuntime())
                .setRating(model.getRating())
                .setTmdbRating(model.getTmdbRating())
                .setVotesCount(model.getVotesCount())
                .setCreators(transformPersonsCredits(model.getCreators()))
                .setActors(transformPersonsCredits(model.getActors()))
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
