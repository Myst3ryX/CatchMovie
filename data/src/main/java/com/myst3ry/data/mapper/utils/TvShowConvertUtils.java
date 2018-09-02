package com.myst3ry.data.mapper.utils;

import com.myst3ry.data.local.entity.credits.PersonCredit;
import com.myst3ry.data.remote.api.TMDbApi;
import com.myst3ry.data.remote.pojo.tvshow.detail.Cast;
import com.myst3ry.data.remote.pojo.tvshow.detail.Creator;
import com.myst3ry.data.remote.pojo.tvshow.detail.Genres;
import com.myst3ry.data.remote.pojo.tvshow.detail.Network;
import com.myst3ry.data.remote.pojo.tvshow.detail.Poster;

import java.util.ArrayList;
import java.util.List;

public final class TvShowConvertUtils {

    private static final String TV_ORIGINAL_IMAGE_SIZE = "original";
    private static final String TV_PREVIEW_IMAGE_SIZE = "w200";

    private static final String JOB_CREATOR = "Creator";

    private static final int ELEM_OFFSET = 1;
    private static final int NETWORKS_MAX = 2;
    private static final int GENRES_MAX = 3;

    public static String convertOriginalImageUrl(final String path) {
        if (path != null) {
            return TMDbApi.IMAGES_URL + TV_ORIGINAL_IMAGE_SIZE + path;
        }
        return null;
    }

    public static String convertPreviewImageUrl(final String path) {
        if (path != null) {
            return TMDbApi.IMAGES_URL + TV_PREVIEW_IMAGE_SIZE + path;
        }
        return null;
    }

    public static List<String> convertGenres(final List<Genres> genresList) {
        final int size = genresList.size() > GENRES_MAX ? GENRES_MAX : genresList.size();
        final List<String> genres = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            if (genresList.get(i).getName() != null) {
                genres.add(genresList.get(i).getName());
            }
        }
        return genres;
    }

    public static List<String> convertPosters(final List<Poster> postersList) {
        final List<String> posters = new ArrayList<>();
        for (final Poster poster : postersList) {
            if (poster.getFilePath() != null) {
                posters.add(convertOriginalImageUrl(poster.getFilePath()));
            }
        }
        return posters;
    }

    public static String convertNetworks(final List<Network> networkList) {
        if (networkList != null) {
            final StringBuilder networks = new StringBuilder();
            final int size = networkList.size() > NETWORKS_MAX ? NETWORKS_MAX : networkList.size();
            for (int i = 0; i < size; i++) {
                networks.append(networkList.get(i).getName());
                if (i != networkList.size() - ELEM_OFFSET) {
                    networks.append(", ");
                }
            }
            return networks.toString();
        }
        return null;
    }

    public static int convertEpisodesRuntime(final List<Integer> episodesRuntime) {
        int averageRuntime = 0;
        for (int runtime : episodesRuntime) {
            averageRuntime += runtime;
        }
        return averageRuntime / episodesRuntime.size();
    }

    public static List<PersonCredit> convertCreators(final List<Creator> creatorList) {
        final List<PersonCredit> creators = new ArrayList<>();
        for (final Creator creator : creatorList) {
            creators.add(new PersonCredit(
                    creator.getId(),
                    creator.getName(),
                    JOB_CREATOR,
                    convertPreviewImageUrl(creator.getProfilePath())
            ));
        }
        return creators;
    }

    public static List<PersonCredit> convertCastToActorsCredits(final List<Cast> castList) {
        final List<PersonCredit> actorsCredits = new ArrayList<>();
        for (final Cast cast : castList) {
            actorsCredits.add(new PersonCredit(
                    cast.getId(),
                    cast.getName(),
                    cast.getCharacter(),
                    convertPreviewImageUrl(cast.getProfilePath())
            ));
        }
        return actorsCredits;
    }

    private TvShowConvertUtils() {
    }
}
