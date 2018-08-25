package com.myst3ry.catchmovie.ui.person.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myst3ry.catchmovie.CatchMovieApp;
import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.model.PersonDataModel;
import com.myst3ry.catchmovie.ui.base.BaseFragment;
import com.myst3ry.catchmovie.ui.person.presenter.PersonSearchPresenter;
import com.myst3ry.catchmovie.ui.person.view.PersonSearchView;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public final class PersonSearchFragment extends BaseFragment implements PersonSearchView {

    public static final String TAG = PersonSearchFragment.class.getSimpleName();

    @Inject
    PersonSearchPresenter mPresenter;

    public static Fragment newInstance() {
        final PersonSearchFragment fragment = new PersonSearchFragment();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((CatchMovieApp) context.getApplicationContext()).getAppComponent()
                .getPersonsSubComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_person_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        Objects.requireNonNull(getActivity()).setTitle(getString(R.string.app_title_search_person));
    }

    @Override
    public void showPersonsSearchResult(final List<PersonDataModel> persons) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
        mPresenter.disposeAll();
    }
}
