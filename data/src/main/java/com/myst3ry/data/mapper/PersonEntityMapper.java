package com.myst3ry.data.mapper;

import com.myst3ry.data.local.entity.PersonEntity;
import com.myst3ry.data.mapper.utils.PersonConvertUtils;
import com.myst3ry.data.remote.pojo.person.detail.PersonDetail;

public final class PersonEntityMapper {

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
                PersonConvertUtils.convertCastToTvShowsCredits(person.getTvShowsCredits().getPersonCast()),
                PersonConvertUtils.convertCastToMoviesCredits(person.getMoviesCredits().getPersonCast()));
    }
}
