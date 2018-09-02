package com.myst3ry.data.mapper.utils;

import com.myst3ry.data.local.entity.credits.PersonCredit;
import com.myst3ry.data.remote.api.TMDbApi;
import com.myst3ry.data.remote.pojo.movie.detail.Cast;
import com.myst3ry.data.remote.pojo.movie.detail.Crew;
import com.myst3ry.data.remote.pojo.movie.detail.Genres;
import com.myst3ry.data.remote.pojo.movie.detail.Poster;
import com.myst3ry.data.remote.pojo.movie.detail.SpokenLanguage;

import java.util.ArrayList;
import java.util.List;

public final class MovieConvertUtils {

    private static final String ORIGINAL_IMAGE_SIZE = "original";
    private static final String PREVIEW_IMAGE_SIZE = "w200";

    private static final String JOB_DIRECTOR = "Director";
    private static final String JOB_WRITER = "Writer";

    private static final int FIRST_SPOKEN_LANGUAGE = 0;
    private static final int GENRES_MAX = 3;

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

    public static String convertLanguages(final List<SpokenLanguage> languagesList) {
        if (languagesList != null && !languagesList.isEmpty()) {
            return languagesList.get(FIRST_SPOKEN_LANGUAGE).getName();
        }
        return null;
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

    public static List<PersonCredit> convertCrewToDirectorsCredits(final List<Crew> crewList) {
        final List<PersonCredit> directorsCredits = new ArrayList<>();
        for (final Crew crew : crewList) {
            if (crew.getJob().equalsIgnoreCase(JOB_DIRECTOR)) {
                directorsCredits.add(new PersonCredit(
                        crew.getId(),
                        crew.getName(),
                        crew.getJob(),
                        convertPreviewImageUrl(crew.getProfilePath())
                ));
            }
        }
        return directorsCredits;
    }

    public static List<PersonCredit> convertCrewToWritersCredits(final List<Crew> crewList) {
        final List<PersonCredit> writersCredits = new ArrayList<>();
        for (final Crew crew : crewList) {
            if (crew.getJob().equalsIgnoreCase(JOB_WRITER)) {
                writersCredits.add(new PersonCredit(
                        crew.getId(),
                        crew.getName(),
                        crew.getJob(),
                        convertPreviewImageUrl(crew.getProfilePath())
                ));
            }
        }
        return writersCredits;
    }

    private MovieConvertUtils() {
    }
}
