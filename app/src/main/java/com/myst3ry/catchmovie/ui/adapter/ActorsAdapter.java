package com.myst3ry.catchmovie.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.model.Actor;
import com.myst3ry.catchmovie.ui.activity.ActorDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ActorHolder> {

    private List<Actor> actors = new ArrayList<>();

    public ActorsAdapter() { //stub
        for (int i = 0; i < 5; i++) {
            Actor actor = new Actor();
            actor.setActorPhotoImage(R.drawable.jordana_photo);
            actor.setActorFullName("Jordana Brewster");
            actors.add(actor);
        }
    }

    @Override
    public ActorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ActorHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_actor, parent, false));
    }

    @Override
    public void onBindViewHolder(ActorHolder holder, int position) {
        final Actor currentActor = actors.get(position);

        holder.actorPhotoImage.setImageResource(currentActor.getActorPhotoImage());
        holder.actorFullName.setText(currentActor.getActorFullName());
    }

    @Override
    public int getItemCount() {
        return actors != null ? actors.size() : 0;
    }

    private Actor getActor(int position) {
        return actors != null ? actors.get(position) : null;
    }


    public final class ActorHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.actor_photo_image)
        ImageView actorPhotoImage;
        @BindView(R.id.actor_full_name)
        TextView actorFullName;

        public ActorHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent actorDetailIntent = new Intent(context, ActorDetailActivity.class);
            Actor actorSelected = getActor(getLayoutPosition());

            if (actorSelected != null) {
                //actorDetailIntent.putExtra(ActorDetailActivity.ACTOR_EXTRA, actorSelected);
                context.startActivity(actorDetailIntent);
            }
        }
    }
}
