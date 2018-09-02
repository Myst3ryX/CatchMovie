package com.myst3ry.catchmovie.ui.person.view;

import com.myst3ry.catchmovie.model.result.PersonResultDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface PersonsPopularView extends BaseView {

    void showPopularPersons(final List<PersonResultDataModel> persons);
}
