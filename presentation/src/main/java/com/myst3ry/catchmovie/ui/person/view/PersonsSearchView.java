package com.myst3ry.catchmovie.ui.person.view;

import com.myst3ry.catchmovie.model.result.PersonResultDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface PersonsSearchView extends BaseView {

    void showPersonsSearchResult(final List<PersonResultDataModel> persons);

    void showEmptyText();

    void hideEmptyText();
}
