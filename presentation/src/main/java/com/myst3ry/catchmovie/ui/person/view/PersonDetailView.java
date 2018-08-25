package com.myst3ry.catchmovie.ui.person.view;

import com.myst3ry.catchmovie.model.PersonDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

public interface PersonDetailView extends BaseView {

    void setPersonDetails(final PersonDataModel person);
}
