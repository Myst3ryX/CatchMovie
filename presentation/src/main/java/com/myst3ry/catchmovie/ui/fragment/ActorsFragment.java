package com.myst3ry.catchmovie.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.model.ActorDataModel;
import com.myst3ry.catchmovie.ui.adapter.ActorsAdapter;
import com.myst3ry.catchmovie.ui.view.ActorsView;
import com.myst3ry.catchmovie.utils.LinearSpacingItemDecoration;
import com.myst3ry.catchmovie.utils.RecyclerViewScrollListener;

import java.util.List;

import butterknife.BindView;

public final class ActorsFragment extends BaseFragment implements ActorsView {

    public static final String TAG = ActorsFragment.class.getSimpleName();

    @BindView(R.id.fab_add_actor)
    FloatingActionButton mFloatingButtonAddActor;
    @BindView(R.id.rv_actors)
    RecyclerView mActorsRecyclerView;
    @BindView(R.id.tv_empty_actors)
    TextView mEmptyActorsTextView;

    private ActorsAdapter mActorsAdapter;

    public static Fragment newInstance() {
        final ActorsFragment fragment = new ActorsFragment();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_actors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setFabListener();
        initAdapter();
        prepareRecyclerView();

        showEmptyText(); //todo ?
    }

    @Override
    public void setActors(final List<ActorDataModel> actors) {
        //mActorsAdapter.setActors(actors);
    }

    //todo implement
    private void setFabListener() {
        mFloatingButtonAddActor.setOnClickListener(v -> Toast.makeText(v.getContext(),
                getString(R.string.fab_click), Toast.LENGTH_SHORT).show());
    }

    private void initAdapter() {
        mActorsAdapter = new ActorsAdapter(this::onActorClick);
    }

    private void prepareRecyclerView() {
        mActorsRecyclerView.setAdapter(mActorsAdapter);
        mActorsRecyclerView.setWillNotDraw(false);
        mActorsRecyclerView.addOnScrollListener(new RecyclerViewScrollListener(mFloatingButtonAddActor));
        mActorsRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_half))
                .setOrientation(LinearLayoutManager.VERTICAL)
                .includeEdge(true)
                .build());
    }

    private void showEmptyText() {
        if (mActorsRecyclerView.getAdapter().getItemCount() == 0) {
            mEmptyActorsTextView.setVisibility(View.VISIBLE);
        } else {
            mEmptyActorsTextView.setVisibility(View.GONE);
        }
    }

    private void onActorClick(final long actorId) {
        //todo implement
    }
}
