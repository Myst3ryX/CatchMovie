package com.myst3ry.catchmovie.ui.person.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myst3ry.catchmovie.CatchMovieApp;
import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.listener.OnPersonClickListener;
import com.myst3ry.catchmovie.model.result.PersonResultDataModel;
import com.myst3ry.catchmovie.ui.base.BaseFragment;
import com.myst3ry.catchmovie.ui.person.adapter.PersonsResultAdapter;
import com.myst3ry.catchmovie.ui.person.presenter.PersonsPopularPresenter;
import com.myst3ry.catchmovie.ui.person.view.PersonsPopularView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public final class PersonsPopularFragment extends BaseFragment implements PersonsPopularView {

    public static final String TAG = PersonsPopularFragment.class.getSimpleName();

    @BindView(R.id.rv_popular_persons_result)
    RecyclerView mPersonsResultRecyclerView;

    @Inject
    PersonsPopularPresenter mPresenter;

    private PersonsResultAdapter mPersonsResultAdapter;
    private OnPersonClickListener mPersonClickListener;

    public static Fragment newInstance() {
        final PersonsPopularFragment fragment = new PersonsPopularFragment();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((CatchMovieApp) context.getApplicationContext()).getAppComponent()
                .getPersonsSubComponent().inject(this);
        if (context instanceof OnPersonClickListener) {
            this.mPersonClickListener = (OnPersonClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_persons_popular, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);

        initAdapter();
        prepareRecyclerView();
    }

    @Override
    public void onStart() {
        super.onStart();
        getPopularPersons();
    }

    private void initAdapter() {
        mPersonsResultAdapter = new PersonsResultAdapter(mPersonClickListener);
    }

    private void prepareRecyclerView() {
        mPersonsResultRecyclerView.setAdapter(mPersonsResultAdapter);
        mPersonsResultRecyclerView.setWillNotDraw(false);
        mPersonsResultRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),
                getResources().getInteger(R.integer.grid_layout_span_count)));
    }

    private void getPopularPersons() {
        mPresenter.getPopularPersons();
    }

    @Override
    public void showPopularPersons(final List<PersonResultDataModel> persons) {
        mPersonsResultAdapter.setPersons(persons);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter.disposeAll();
    }
}
