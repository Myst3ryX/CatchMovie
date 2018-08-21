package com.myst3ry.catchmovie.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.listener.OnActorClickListener;
import com.myst3ry.catchmovie.model.ActorDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ActorHolder> {

    private static final int INIT_POS = 0;

    private List<ActorDataModel> mActors;
    private final OnActorClickListener mListener;

    public ActorsAdapter(final OnActorClickListener listener) {
        this.mActors = new ArrayList<>();
        this.mListener = listener;
    }

    @Override
    public ActorHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new ActorHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_actor, parent, false));
    }

    @Override
    public void onBindViewHolder(final ActorHolder holder, final int position) {
        final ActorDataModel currentActor = mActors.get(position);
        holder.mActorPhotoImageView.setImageResource(currentActor.getActorPhotoImage());
        holder.mActorFullNameTextView.setText(currentActor.getActorFullName());
    }

    @Override
    public int getItemCount() {
        return mActors.size();
    }

    public void setActors(final List<ActorDataModel> actors) {
        this.mActors = actors;
        notifyDataSetChanged();
    }

    public void addActor(final ActorDataModel actor) {
        mActors.add(INIT_POS, actor);
        notifyItemInserted(INIT_POS);
    }

    public void removeActor(final int actorId) {
        ActorDataModel actor = null;
        int position = Integer.MIN_VALUE;

        for (int i = 0; i < mActors.size(); i++) {
            if (mActors.get(i).getActorId() == actorId) {
                actor = mActors.get(i);
                position = i;
                break;
            }
        }

        if (actor != null) {
            mActors.remove(actor);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mActors.size());
        }
    }

    public void clearActors() {
        final int size = mActors.size();
        mActors.clear();
        notifyItemRangeRemoved(INIT_POS, size);
    }

    private ActorDataModel getActor(final int position) {
        return mActors.get(position);
    }

    public final class ActorHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.actor_photo_image)
        ImageView mActorPhotoImageView;
        @BindView(R.id.actor_full_name)
        TextView mActorFullNameTextView;

        @OnClick(R.id.actor_container)
        void onClick() {
            mListener.onActorClick(getActor(getLayoutPosition()).getActorId());
        }

        ActorHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
