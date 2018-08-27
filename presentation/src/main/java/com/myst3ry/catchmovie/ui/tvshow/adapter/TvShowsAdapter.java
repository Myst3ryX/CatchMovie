package com.myst3ry.catchmovie.ui.tvshow.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.listener.OnTvShowClickListener;
import com.myst3ry.catchmovie.listener.OnTvShowMenuClickListener;
import com.myst3ry.catchmovie.model.item.TvShowItemDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.TvShowHolder> {

    private static final int INIT_POS = 0;

    private List<TvShowItemDataModel> mTvShows;
    private final OnTvShowClickListener mListener;
    private final OnTvShowMenuClickListener mMenuListener;

    public TvShowsAdapter(final OnTvShowClickListener listener, final OnTvShowMenuClickListener menuListener) {
        this.mTvShows = new ArrayList<>();
        this.mListener = listener;
        this.mMenuListener = menuListener;
    }

    @Override
    public TvShowsAdapter.TvShowHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new TvShowHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tv_show, parent, false));
    }

    @Override
    public void onBindViewHolder(final TvShowHolder holder, final int position) {
        final TvShowItemDataModel currentTvShow = mTvShows.get(position);
        //holder.mPosterImageView.setImageResource(currentTvShow.getTvShowPoster());
        holder.mReleaseYearTextView.setText(currentTvShow.getTvShowReleaseDate());
        holder.mTitleTextView.setText(currentTvShow.getTvShowTitle());
        holder.mGenreTextView.setText(currentTvShow.getTvShowGenres().toString()); //todo here
//        holder.mRatingTextView.setText(currentTvShow.getTvShowRating());
//        holder.mTmdbRatingTextView.setText(currentTvShow.getTvShowTmdbRating());
    }

    @Override
    public int getItemCount() {
        return mTvShows.size();
    }

    public void setTvShows(final List<TvShowItemDataModel> tvShows) {
        this.mTvShows = tvShows;
        notifyDataSetChanged();
    }

    public void addTvShow(final TvShowItemDataModel tvShow) {
        mTvShows.add(INIT_POS, tvShow);
        notifyItemInserted(INIT_POS);
    }

    public void removeTvShow(final int tvShowId) {
        TvShowItemDataModel tvShow = null;
        int position = Integer.MIN_VALUE;

        for (int i = 0; i < mTvShows.size(); i++) {
            if (mTvShows.get(i).getTvShowId() == tvShowId) {
                tvShow = mTvShows.get(i);
                position = i;
                break;
            }
        }

        if (tvShow != null) {
            mTvShows.remove(tvShow);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mTvShows.size());
        }
    }

    public void clearTvShows() {
        final int size = mTvShows.size();
        mTvShows.clear();
        notifyItemRangeRemoved(INIT_POS, size);
    }

    private TvShowItemDataModel getTvShow(final int position) {
        return mTvShows.get(position);
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
        void onContextMenuClick() {
            mMenuListener.onTvShowMenuClick(getTvShow(getLayoutPosition()).getTvShowId());
        }

        TvShowHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
