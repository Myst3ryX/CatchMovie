package com.myst3ry.catchmovie.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.myst3ry.catchmovie.R;

public class CatchingHistoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catching_history, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_catch);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), getString(R.string.fab_click), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
