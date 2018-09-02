package com.myst3ry.data.mapper;

import com.myst3ry.data.mapper.utils.PersonConvertUtils;
import com.myst3ry.data.remote.pojo.person.find.PersonResult;
import com.myst3ry.domain.model.result.PersonResultModel;

import java.util.ArrayList;
import java.util.List;

public final class PersonResultDataMapper {

    public static List<PersonResultModel> transform(final List<PersonResult> results) {
        final List<PersonResultModel> models = new ArrayList<>();
        for (final PersonResult result : results) {
            models.add(transform(result));
        }
        return models;
    }

    public static PersonResultModel transform(final PersonResult result) {
        return new PersonResultModel(
                result.getId(),
                result.getName(),
                PersonConvertUtils.convertKnownForDesc(result.getKnownFor()),
                PersonConvertUtils.convertPreviewImageUrl(result.getProfilePath())
        );
    }
}
