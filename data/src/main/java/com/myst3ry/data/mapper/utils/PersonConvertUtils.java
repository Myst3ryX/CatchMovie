package com.myst3ry.data.mapper.utils;

import com.myst3ry.data.local.entity.credits.MovieCredit;
import com.myst3ry.data.local.entity.credits.TvShowCredit;
import com.myst3ry.data.remote.api.TMDbApi;
import com.myst3ry.data.remote.pojo.person.detail.PersonCast;
import com.myst3ry.data.remote.pojo.person.find.KnownFor;

import java.util.ArrayList;
import java.util.List;

public final class PersonConvertUtils {

    private static final String ORIGINAL_IMAGE_SIZE = "original";
    private static final String PREVIEW_IMAGE_SIZE = "w200";

    public static String convertOriginalImageUrl(final String path) {
        return TMDbApi.IMAGES_URL + ORIGINAL_IMAGE_SIZE + path;
    }

    public static String convertPreviewImageUrl(final String path) {
        return TMDbApi.IMAGES_URL + PREVIEW_IMAGE_SIZE + path;
    }

    public static List<TvShowCredit> convertCastToTvShowsCredits(final List<PersonCast> personCastList) {
        final List<TvShowCredit> tvShowCredits = new ArrayList<>();
        for (final PersonCast cast : personCastList) {
            tvShowCredits.add(new TvShowCredit(
                    cast.getId(),
                    cast.getTitle(),
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
                    convertPreviewImageUrl(cast.getPosterPath())
            ));
        }
        return movieCredits;
    }

    public static String convertKnownForDesc(final List<KnownFor> knownForList) {
        if (knownForList == null) {
            return "";
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

    private PersonConvertUtils() {
    }
}
