package com.myst3ry.catchmovie.ui.person.view;

import com.myst3ry.catchmovie.model.item.PersonItemDataModel;
import com.myst3ry.catchmovie.ui.base.BaseView;

import java.util.List;

public interface PersonSearchView extends BaseView {

    void showPersonsSearchResult(final List<PersonItemDataModel> persons);
}
