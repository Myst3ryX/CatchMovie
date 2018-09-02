package com.myst3ry.catchmovie.mapper;

import com.myst3ry.catchmovie.model.result.PersonResultDataModel;
import com.myst3ry.domain.model.result.PersonResultModel;

import java.util.ArrayList;
import java.util.List;

public final class PersonResultDataModelMapper {

    public static List<PersonResultDataModel> transform(final List<PersonResultModel> models) {
        final List<PersonResultDataModel> persons = new ArrayList<>();
        for (final PersonResultModel model : models) {
            persons.add(transform(model));
        }
        return persons;
    }

    public static PersonResultDataModel transform(final PersonResultModel model) {
        return PersonResultDataModel.newBuilder()
                .setId(model.getId())
                .setPhoto(model.getPhoto())
                .setName(model.getName())
                .setKnownFor(model.getKnownFor())
                .build();
    }
}
