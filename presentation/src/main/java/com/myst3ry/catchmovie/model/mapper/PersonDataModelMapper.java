package com.myst3ry.catchmovie.model.mapper;

import com.myst3ry.catchmovie.model.PersonDataModel;
import com.myst3ry.domain.model.Person;

import java.util.ArrayList;
import java.util.List;

public final class PersonDataModelMapper {

    public PersonDataModel transform(final Person person) {
        return PersonDataModel.newBuilder().build();
    }

    public List<PersonDataModel> transform(final List<Person> persons) {
        final List<PersonDataModel> actorsDataModels = new ArrayList<>();
        for (final Person person : persons) {
            actorsDataModels.add(transform(person));
        }
        return actorsDataModels;
    }
}
