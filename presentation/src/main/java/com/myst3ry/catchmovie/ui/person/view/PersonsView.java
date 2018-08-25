package com.myst3ry.catchmovie.ui.person.view;

import com.myst3ry.catchmovie.model.PersonDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface PersonsView extends BaseView {

    void setPersons(final List<PersonDataModel> persons);

    void showEmptyText();

    void hideEmptyText();
}
