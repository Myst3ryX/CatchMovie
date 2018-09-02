package com.myst3ry.catchmovie.mapper;

import com.myst3ry.catchmovie.model.item.PersonItemDataModel;
import com.myst3ry.domain.model.item.PersonItemModel;

import java.util.ArrayList;
import java.util.List;

public final class PersonItemDataModelMapper {

    public static List<PersonItemDataModel> transform(final List<PersonItemModel> models) {
        final List<PersonItemDataModel> persons = new ArrayList<>();
        for (final PersonItemModel model : models) {
            persons.add(transform(model));
        }
        return persons;
    }

    public static PersonItemDataModel transform(final PersonItemModel model) {
        return PersonItemDataModel.newBuilder()
                .setId(model.getId())
                .setPhoto(model.getPhoto())
                .setName(model.getName())
                .setKnownAs(model.getKnownAs())
                .build();
    }
}
