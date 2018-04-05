package com.myst3ry.catchmovie.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.ui.adapter.ActorsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActorsFragment extends Fragment {

    @BindView(R.id.fab_add_actor)
    FloatingActionButton fabAddActor;
    @BindView(R.id.actors_recycler_view)
    RecyclerView actorsRecyclerView;
    @BindView(R.id.actors_empty_text)
    TextView emptyText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actors, container, false);
        ButterKnife.bind(this, view);

        fabAddActor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), getString(R.string.fab_click), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        actorsRecyclerView.setAdapter(new ActorsAdapter());
        actorsRecyclerView.setWillNotDraw(false);
        actorsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    fabAddActor.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 || (dy < 0 && fabAddActor.isShown())) {
                    fabAddActor.hide();
                }
            }
        });

        if (actorsRecyclerView.getAdapter().getItemCount() == 0) {
            emptyText.setVisibility(View.VISIBLE);
        } else {
            emptyText.setVisibility(View.GONE);
        }
    }

}
