package com.myst3ry.data.mapper.utils;

import com.myst3ry.data.local.entity.credits.MovieCredit;
import com.myst3ry.data.local.entity.credits.TvShowCredit;
import com.myst3ry.data.remote.api.TMDbApi;
import com.myst3ry.data.remote.pojo.person.detail.PersonCast;
import com.myst3ry.data.remote.pojo.person.detail.PersonCrew;
import com.myst3ry.data.remote.pojo.person.find.KnownFor;

import java.util.ArrayList;
import java.util.List;

public final class PersonConvertUtils {

    private static final String ORIGINAL_IMAGE_SIZE = "original";
    private static final String PREVIEW_IMAGE_SIZE = "w200";

    private static final String ACTING_DEPARTMENT = "Acting";

    public static String convertOriginalImageUrl(final String path) {
        if (path != null) {
            return TMDbApi.IMAGES_URL + ORIGINAL_IMAGE_SIZE + path;
        }
        return null;
    }

    public static String convertPreviewImageUrl(final String path) {
        if (path != null) {
            return TMDbApi.IMAGES_URL + PREVIEW_IMAGE_SIZE + path;
        }
        return null;
    }

    public static List<TvShowCredit> convertCastToTvShowsCredits(final List<PersonCast> personCastList) {
        final List<TvShowCredit> tvShowCredits = new ArrayList<>();
        for (final PersonCast cast : personCastList) {
            tvShowCredits.add(new TvShowCredit(
                    cast.getId(),
                    cast.getTitle(),
                    cast.getCharacter(),
                    convertPreviewImageUrl(cast.getPosterPath())
            ));
        }
        return tvShowCredits;
    }

    public static List<TvShowCredit> convertCrewToTvShowsCredits(final List<PersonCrew> personCrewList) {
        final List<TvShowCredit> tvShowCredits = new ArrayList<>();
        for (final PersonCrew cast : personCrewList) {
            tvShowCredits.add(new TvShowCredit(
                    cast.getId(),
                    cast.getTitle(),
                    cast.getJob(),
                    convertPreviewImageUrl(cast.getPosterPath())
            ));
        }
        return tvShowCredits;
    }

    public static List<MovieCredit> convertCastToMoviesCredits(final List<PersonCast> personCastList) {
        final List<MovieCredit> movieCredits = new ArrayList<>();
        for (final PersonCast cast : personCastList) {
            movieCredits.add(new MovieCredit(
                    cast.getId(),
                    cast.getTitle(),
                    cast.getCharacter(),
                    convertPreviewImageUrl(cast.getPosterPath())
            ));
        }
        return movieCredits;
    }

    public static List<MovieCredit> convertCrewToMoviesCredits(final List<PersonCrew> personCrewList) {
        final List<MovieCredit> movieCredits = new ArrayList<>();
        for (final PersonCrew cast : personCrewList) {
            movieCredits.add(new MovieCredit(
                    cast.getId(),
                    cast.getTitle(),
                    cast.getJob(),
                    convertPreviewImageUrl(cast.getPosterPath())
            ));
        }
        return movieCredits;
    }

    public static String convertKnownForDesc(final List<KnownFor> knownForList) {
        if (knownForList == null) {
            return null;
        }

        int knownForIndex = 0;
        double popularity = 0;

        for (int i = 0; i < knownForList.size(); i++) {
            final KnownFor knownForItem = knownForList.get(i);
            if (knownForItem.getPopularity() > popularity) {
                popularity = knownForItem.getPopularity();
                knownForIndex = i;
            }
        }

        return knownForList.get(knownForIndex).getTitle();
    }

    public static boolean isActor(final String knownForDepartment) {
        return knownForDepartment.equalsIgnoreCase(ACTING_DEPARTMENT);
    }

    private PersonConvertUtils() {
    }
}
