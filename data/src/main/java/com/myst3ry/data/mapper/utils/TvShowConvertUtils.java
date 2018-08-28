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

    private static final String NETWORK_SEPARATOR = ", ";
    private static final int ELEM_OFFSET = 1;
    private static final int NETWORKS_MAX = 2;

    public static String convertOriginalImageUrl(final String path) {
        return TMDbApi.IMAGES_URL + TV_ORIGINAL_IMAGE_SIZE + path;
    }

    public static String convertPreviewImageUrl(final String path) {
        return TMDbApi.IMAGES_URL + TV_PREVIEW_IMAGE_SIZE + path;
    }

    public static List<String> convertGenres(final List<Genres> genresList) {
        final List<String> genres = new ArrayList<>();
        for (final Genres genre : genresList) {
            if (genre.getName() != null) {
                genres.add(genre.getName());
            }
        }
        return genres;
    }

    public static List<String> convertPosters(final List<Poster> postersList) {
        final List<String> posters = new ArrayList<>();
        for (final Poster poster : postersList) {
            if (poster.getFilePath() != null) {
                posters.add(poster.getFilePath());
            }
        }
        return posters;
    }

    public static String convertNetworks(final List<Network> networkList) {
        if (networkList == null) {
            return "";
        }

        final StringBuilder networks = new StringBuilder();
        final int size = networkList.size() > NETWORKS_MAX ? NETWORKS_MAX : networkList.size();
        for (int i = 0; i < size; i++) {
            networks.append(networkList.get(i));
            if (i != networkList.size() - ELEM_OFFSET) {
                networks.append(NETWORK_SEPARATOR);
            }
        }
        return networks.toString();
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
