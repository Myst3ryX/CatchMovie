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
import com.myst3ry.catchmovie.model.TvShow;
import com.myst3ry.catchmovie.ui.activity.TvShowDetailActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.TvShowHolder> {

    private int tvShowType;
    private List<TvShow> tvShows = new ArrayList<>();

    public TvShowsAdapter(int tvShowType) {
        this.tvShowType = tvShowType;
        initAdapter();
    }

    @Override
    public TvShowsAdapter.TvShowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TvShowHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv_show, parent, false));
    }

    @Override
    public void onBindViewHolder(TvShowHolder holder, int position) {
        final TvShow currentTvShow = tvShows.get(position);

        holder.tvShowPosterImage.setImageResource(currentTvShow.getTvShowPosterImage());
        holder.tvShowContextMenuImage.setImageResource(R.drawable.ic_menu);
        holder.tvShowReleaseYear.setText(currentTvShow.getTvShowReleaseYear());
        holder.tvShowTitle.setText(currentTvShow.getTvShowTitle());
        holder.tvShowGenre.setText(currentTvShow.getTvShowGenre());
        holder.rateStarImage.setImageResource(R.drawable.ic_star_border);
        holder.tvShowRating.setText(currentTvShow.getTvShowRating());
        holder.tmdbLogoImage.setImageResource(R.drawable.tmdb_logo_stacked);
        holder.tmdbRating.setText(currentTvShow.getTvShowTmdbRating());
    }

    @Override
    public int getItemCount() {
        return tvShows != null ? tvShows.size() : 0;
    }

    private TvShow getTvShow(int position) {
        return tvShows != null ? tvShows.get(position) : null;
    }

    private void initAdapter() {
        switch (tvShowType) {
            case TvShow.RECENT:
                setRecentTvShowsList();
                break;
            case TvShow.WATCH:
                setWatchTvShowsList();
                break;
            case TvShow.FAVORITE:
                //setFavoriteTvShowsList();
                break;
            default:
                break;
        }
    }

    private void setRecentTvShowsList() { //stub recent tv shows
        tvShows.clear();
        tvShows.addAll(Arrays.asList(fillList(10)));
    }

    private void setWatchTvShowsList() { //stub watchlist tv shows
        tvShows.clear();
        tvShows.addAll(Arrays.asList(fillList(1)));
    }

    private void setFavoriteTvShowsList() { //stub favorite tv shows
        tvShows.clear();
        tvShows.addAll(Arrays.asList(fillList(3)));
    }

    private TvShow[] fillList(int size) {
        TvShow[] tvShowsArr = new TvShow[size];
        for (int i = 0; i < size; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setTvShowPosterImage(R.drawable.star_wars_poster);
            tvShow.setTvShowReleaseYear("NONE");
            tvShow.setTvShowTitle("NO NAME");
            tvShow.setTvShowGenre("NO DATA");
            tvShow.setTvShowRating("0/0");
            tvShow.setTvShowTmdbRating("0.0");
            tvShowsArr[i] = tvShow;
        }
        return tvShowsArr;
    }


    public final class TvShowHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tv_show_poster_image)
        ImageView tvShowPosterImage;
        @BindView(R.id.tv_show_context_menu_image)
        ImageView tvShowContextMenuImage;
        @BindView(R.id.tv_show_release_year)
        TextView tvShowReleaseYear;
        @BindView(R.id.tv_show_title)
        TextView tvShowTitle;
        @BindView(R.id.tv_show_genre)
        TextView tvShowGenre;
        @BindView(R.id.rate_star_image)
        ImageView rateStarImage;
        @BindView(R.id.tv_show_rating)
        TextView tvShowRating;
        @BindView(R.id.tmdb_logo_image)
        ImageView tmdbLogoImage;
        @BindView(R.id.tmdb_rating)
        TextView tmdbRating;

        public TvShowHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent tvShowDetailIntent = new Intent(context, TvShowDetailActivity.class);
            TvShow tvShowSelected = getTvShow(getLayoutPosition());

            if (tvShowSelected != null) {
                //tvShowDetailIntent.putExtra(TvShowDetailActivity.TV_SHOW_EXTRA, tvShowSelected);
                context.startActivity(tvShowDetailIntent);
            }
        }
    }
}
