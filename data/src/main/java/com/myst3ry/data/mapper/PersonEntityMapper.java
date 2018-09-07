package com.myst3ry.data.mapper;

import com.myst3ry.data.local.entity.PersonEntity;
import com.myst3ry.data.mapper.utils.PersonConvertUtils;
import com.myst3ry.data.remote.pojo.person.detail.PersonDetail;

/**
 * A Mapper which transforms PersonEntity from pojo to data-layer model.
 */
public final class PersonEntityMapper {

    /**
     * Transforms person model from pojo {@link PersonDetail} to data-layer model (entity) class {@link PersonEntity}.
     *
     * @param person - a person detail pojo-class received from remote
     * @return transformed person data-layer model
     */
    public static PersonEntity transform(final PersonDetail person) {
        return new PersonEntity(
                person.getId(),
                person.getName(),
                person.getKnownForDepartment(),
                person.getBirthday(),
                person.getDeathday(),
                person.getBiography(),
                PersonConvertUtils.convertOriginalImageUrl(person.getProfilePath()),
                PersonConvertUtils.convertPreviewImageUrl(person.getProfilePath()),
                PersonConvertUtils.isActor(person.getKnownForDepartment())
                        ? PersonConvertUtils.convertCastToTvShowsCredits(person.getTvShowsCredits().getPersonCast())
                        : PersonConvertUtils.convertCrewToTvShowsCredits(person.getTvShowsCredits().getPersonCrew()),
                PersonConvertUtils.isActor(person.getKnownForDepartment())
                        ? PersonConvertUtils.convertCastToMoviesCredits(person.getMoviesCredits().getPersonCast())
                        : PersonConvertUtils.convertCrewToMoviesCredits(person.getMoviesCredits().getPersonCrew()));
    }
}
