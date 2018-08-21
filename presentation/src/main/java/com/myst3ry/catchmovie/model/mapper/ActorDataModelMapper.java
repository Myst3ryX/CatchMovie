package com.myst3ry.catchmovie.model.mapper;

import com.myst3ry.catchmovie.model.ActorDataModel;
import com.myst3ry.domain.model.Actor;

import java.util.ArrayList;
import java.util.List;

public final class ActorDataModelMapper {

    public ActorDataModel transform(final Actor actor) {
        return ActorDataModel.newBuilder().build();
    }

    public List<ActorDataModel> transform(final List<Actor> actors) {
        final List<ActorDataModel> actorsDataModels = new ArrayList<>();
        for (final Actor actor : actors) {
            actorsDataModels.add(transform(actor));
        }
        return actorsDataModels;
    }
}
