package com.myst3ry.data.mapper;

import com.myst3ry.data.local.entity.PersonEntity;
import com.myst3ry.domain.model.item.PersonItemModel;

import java.util.ArrayList;
import java.util.List;

public final class PersonItemDataMapper {

    public static List<PersonItemModel> transform(final List<PersonEntity> entities) {
        final List<PersonItemModel> models = new ArrayList<>();
        for (final PersonEntity entity : entities) {
            models.add(transform(entity));
        }
        return models;
    }

    public static PersonItemModel transform(final PersonEntity entity) {
        return new PersonItemModel(
                entity.getId(),
                entity.getName(),
                entity.getPhotoImage()
        );
    }
}
