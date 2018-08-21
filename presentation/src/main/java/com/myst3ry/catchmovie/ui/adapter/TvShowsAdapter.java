package com.myst3ry.catchmovie.ui.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.listener.OnTvShowClickListener;
import com.myst3ry.catchmovie.model.TvShowDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.TvShowHolder> {

    private final int mTvShowType;
    private final OnTvShowClickListener mListener;
    private List<TvShowDataModel> mTvShows;

    public TvShowsAdapter(final int tvShowType, final OnTvShowClickListener listener) {
        this.mTvShows = new ArrayList<>();
        this.mTvShowType = tvShowType;
        this.mListener = listener;
    }

    @Override
    public TvShowsAdapter.TvShowHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new TvShowHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tv_show, parent, false));
    }

    @Override
    public void onBindViewHolder(final TvShowHolder holder, final int position) {
        final TvShowDataModel currentTvShow = mTvShows.get(position);
        holder.mPosterImageView.setImageResource(currentTvShow.getTvShowPosterImage());
        holder.mReleaseYearTextView.setText(currentTvShow.getTvShowReleaseYear());
        holder.mTitleTextView.setText(currentTvShow.getTvShowTitle());
        holder.mGenreTextView.setText(currentTvShow.getTvShowGenre());
        holder.mRatingTextView.setText(currentTvShow.getTvShowRating());
        holder.mTmdbRatingTextView.setText(currentTvShow.getTvShowTmdbRating());
    }

    @Override
    public int getItemCount() {
        return mTvShows.size();
    }

    private TvShowDataModel getTvShow(final int position) {
        return mTvShows.get(position);
    }

    public void setTvShows(final List<TvShowDataModel> tvShows) {
        switch (mTvShowType) {
            case TvShowDataModel.RECENT:
                setRecentTvShowsList(tvShows);
                break;
            case TvShowDataModel.WATCH:
                setWatchTvShowsList(tvShows);
                break;
            case TvShowDataModel.FAVORITE:
                setFavoriteTvShowsList(tvShows);
                break;
            default:
                break;
        }
    }

    //todo replace
    private void setRecentTvShowsList(final List<TvShowDataModel> tvShowsRecent) {
        this.mTvShows = tvShowsRecent;
        notifyDataSetChanged();
    }

    //todo replace
    private void setWatchTvShowsList(final List<TvShowDataModel> tvShowsToWatch) {
        this.mTvShows = tvShowsToWatch;
        notifyDataSetChanged();
    }

    //todo replace
    private void setFavoriteTvShowsList(final List<TvShowDataModel> tvShowsFavorite) {
        this.mTvShows = tvShowsFavorite;
        notifyDataSetChanged();
    }

    public final class TvShowHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_show_poster_image)
        ImageView mPosterImageView;
        @BindView(R.id.tv_show_release_year)
        TextView mReleaseYearTextView;
        @BindView(R.id.tv_show_title)
        TextView mTitleTextView;
        @BindView(R.id.tv_show_genre)
        TextView mGenreTextView;
        @BindView(R.id.tv_show_rating)
        TextView mRatingTextView;
        @BindView(R.id.tmdb_rating)
        TextView mTmdbRatingTextView;

        @OnClick(R.id.tv_show_container)
        void onItemClick() {
            mListener.onTvShowClick(getTvShow(getLayoutPosition()).getTvShowId());
        }

        @OnClick(R.id.tv_show_context_menu)
        void onContextMenuClick(final View view) {
            Toast.makeText(view.getContext(), "Item " + getLayoutPosition() + " clicked!", Toast.LENGTH_SHORT).show();
        }

        TvShowHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
