package com.myst3ry.catchmovie.ui.tvshow.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.myst3ry.catchmovie.BuildConfig;
import com.myst3ry.catchmovie.CatchMovieApp;
import com.myst3ry.catchmovie.CatchMovieGlideModule;
import com.myst3ry.catchmovie.GlideApp;
import com.myst3ry.catchmovie.LinearSpacingItemDecoration;
import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.listener.OnPersonClickListener;
import com.myst3ry.catchmovie.model.detail.TvShowDetailDataModel;
import com.myst3ry.catchmovie.ui.base.BaseFragment;
import com.myst3ry.catchmovie.ui.person.adapter.PersonCreditsAdapter;
import com.myst3ry.catchmovie.ui.tvshow.presenter.TvShowDetailPresenter;
import com.myst3ry.catchmovie.ui.tvshow.view.TvShowDetailView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public final class TvShowDetailFragment extends BaseFragment implements TvShowDetailView {

    public static final String TAG = TvShowDetailFragment.class.getSimpleName();

    private static final String ARG_TV_SHOW_ID = BuildConfig.APPLICATION_ID + "ARG.TV_SHOW_ID";

    @BindView(R.id.detail_tv_show_poster)
    ImageView mTvShowPoster;
    @BindView(R.id.detail_tv_show_title)
    TextView mTvShowTitle;
    @BindView(R.id.detail_tv_show_release_date)
    TextView mTvShowReleaseDate;
    @BindView(R.id.detail_tv_show_status)
    TextView mTvShowStatus;
    @BindView(R.id.detail_tv_show_info)
    TextView mTvShowInfo;
    @BindView(R.id.detail_tv_show_network_info)
    TextView mTvShowNetworkInfo;
    @BindView(R.id.detail_tv_show_rating)
    TextView mTvShowRating;
    @BindView(R.id.detail_tv_show_tmdb_rating)
    TextView mTvShowTmdbRating;
    @BindView(R.id.detail_tv_show_overview)
    TextView mTvShowOverview;

    @BindView(R.id.detail_tv_show_overview_title)
    TextView mTvShowOverviewTitle;
    @BindView(R.id.detail_tv_show_creators_title)
    TextView mTvShowCreatorsTitle;
    @BindView(R.id.detail_tv_show_cast_title)
    TextView mTvShowCastTitle;

    @BindViews({R.id.detail_tv_show_genre_one, R.id.detail_tv_show_genre_two, R.id.detail_tv_show_genre_three,
            R.id.detail_tv_show_genre_four})
    List<TextView> mTvShowGenres;

    @BindView(R.id.detail_tv_show_watchlist_btn)
    ImageView mTvShowWatchlistBtn;
    @BindView(R.id.detail_tv_show_favorite_btn)
    ImageView mTvShowFavoriteBtn;

    @BindView(R.id.rv_detail_tv_show_creators)
    RecyclerView mCreatorsRecyclerView;
    @BindView(R.id.rv_detail_tv_show_cast)
    RecyclerView mCastRecyclerView;

    @Inject
    TvShowDetailPresenter mPresenter;

    private PersonCreditsAdapter mCreatorCreditsAdapter;
    private PersonCreditsAdapter mCastCreditsAdapter;
    private OnPersonClickListener mPersonClickListener;

    private int mTvShowId;
    private boolean mWatchlist, mFavorite;

    public static Fragment newInstance(final int tvShowId) {
        final TvShowDetailFragment fragment = new TvShowDetailFragment();
        final Bundle args = new Bundle();
        args.putInt(ARG_TV_SHOW_ID, tvShowId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initOnPersonClickListener(context);
        ((CatchMovieApp) context.getApplicationContext()).getAppComponent()
                .getTvShowsSubComponent().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTvShowId = getArguments().getInt(ARG_TV_SHOW_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv_show_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);

        initAdapters();
        prepareRecyclerViews();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mTvShowId != 0) {
            getTvShowDetails();
        }
    }

    private void initOnPersonClickListener(final Context context) {
        if (context instanceof OnPersonClickListener) {
            this.mPersonClickListener = (OnPersonClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
    }

    private void initAdapters() {
        mCreatorCreditsAdapter = new PersonCreditsAdapter(mPersonClickListener);
        mCastCreditsAdapter = new PersonCreditsAdapter(mPersonClickListener);
    }

    private void prepareRecyclerViews() {
        mCreatorsRecyclerView.setAdapter(mCreatorCreditsAdapter);
        mCreatorsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        mCreatorsRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_half))
                .setOrientation(LinearLayoutManager.HORIZONTAL)
                .includeEdge(false)
                .build());

        mCastRecyclerView.setAdapter(mCastCreditsAdapter);
        mCastRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        mCastRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_half))
                .setOrientation(LinearLayoutManager.HORIZONTAL)
                .includeEdge(false)
                .build());
    }

    private void getTvShowDetails() {
        mPresenter.getTvShowDetails(mTvShowId);
    }

    @Override
    public void setTvShowDetails(final TvShowDetailDataModel tvShow) {
        this.loadTvShowPoster(tvShow.getTvShowPoster(), tvShow.getTvShowPosterPreview());
        this.setTvShowGenres(tvShow.getTvShowGenres());
        this.setWatchlistStatus(tvShow.isTvShowWatchlist());
        this.setFavoriteStatus(tvShow.isTvShowFavorite());

        mTvShowTitle.setText(tvShow.getTvShowTitle());
        mTvShowReleaseDate.setText(tvShow.getTvShowReleaseDate());
        mTvShowStatus.setText(tvShow.getTvShowStatus());
        mTvShowInfo.setText(tvShow.getTvShowInfo());
        mTvShowNetworkInfo.setText(tvShow.getTvShowNetworkInfo());
        mTvShowRating.setText(tvShow.getTvShowRating());
        mTvShowTmdbRating.setText(tvShow.getTvShowTmdbRating());

        if (!tvShow.getTvShowDescription().isEmpty()) {
            mTvShowOverview.setText(tvShow.getTvShowDescription());
            mTvShowOverviewTitle.setVisibility(View.VISIBLE);
        }

        if (!tvShow.getTvShowCreators().isEmpty()) {
            mCreatorCreditsAdapter.setPersons(tvShow.getTvShowCreators());
            mTvShowCreatorsTitle.setVisibility(View.VISIBLE);
        }

        if (!tvShow.getTvShowActors().isEmpty()) {
            mCastCreditsAdapter.setPersons(tvShow.getTvShowActors());
            mTvShowCastTitle.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setWatchlistStatus(final boolean isWatchlist) {
        this.mWatchlist = isWatchlist;
        mTvShowWatchlistBtn.setImageResource(isWatchlist ? R.drawable.ic_watchlist_checked_24dp
                : R.drawable.ic_watchlist_unchecked_24dp);
    }

    @Override
    public void setFavoriteStatus(final boolean isFavorite) {
        this.mFavorite = isFavorite;
        mTvShowFavoriteBtn.setImageResource(isFavorite ? R.drawable.ic_favorite_checked_24dp
                : R.drawable.ic_favorite_unchecked_24dp);
    }

    @OnClick(R.id.detail_tv_show_watchlist_btn)
    void onWatchlistBtnClick() {
        this.performWatchlistClick();
    }

    @OnClick(R.id.detail_tv_show_favorite_btn)
    void onFavoriteBtnClick() {
        this.performFavoriteClick();
    }

    @OnClick({R.id.detail_tv_show_rating_logo, R.id.detail_tv_show_rating})
    void onRatingClick() {
        this.performRatingClick();
    }

    private void performWatchlistClick() {
        if (!mWatchlist) {
            mPresenter.addToWatchlist(mTvShowId);
        } else {
            mPresenter.deleteFromWatchlist(mTvShowId);
        }
    }

    private void performFavoriteClick() {
        if (!mFavorite) {
            mPresenter.addToFavorites(mTvShowId);
        } else {
            mPresenter.deleteFromFavorites(mTvShowId);
        }
    }

    private void performRatingClick() {
        final double rating = 7.5; //todo stub
        mPresenter.setTvShowRating(mTvShowId, rating);
    }

    private void loadTvShowPoster(final String posterUrl, final String previewPosterUrl) {
        GlideApp.with(this)
                .load(posterUrl)
                .thumbnail(GlideApp.with(this).load(previewPosterUrl))
                .centerInside()
                .transition(DrawableTransitionOptions.withCrossFade(CatchMovieGlideModule.CROSS_FADE_DURATION))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(mTvShowPoster);
    }

    private void setTvShowGenres(final List<String> genres) {
        if (genres != null) {
            final int size = genres.size() > mTvShowGenres.size() ? mTvShowGenres.size() : genres.size();
            for (int i = 0; i < size; i++) {
                mTvShowGenres.get(i).setText(genres.get(i));
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter.disposeAll();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPersonClickListener = null;
    }
}
