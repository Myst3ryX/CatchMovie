package com.myst3ry.catchmovie.ui.view;

import com.myst3ry.catchmovie.model.ActorDataModel;

import java.util.List;

public interface ActorsView extends BaseView {

    void setActors(final List<ActorDataModel> actors);
}
