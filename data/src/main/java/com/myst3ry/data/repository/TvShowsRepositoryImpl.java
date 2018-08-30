package com.myst3ry.data.repository;

import com.myst3ry.data.local.database.dao.TvShowsDAO;
import com.myst3ry.data.mapper.TvShowItemDataMapper;
import com.myst3ry.data.mapper.TvShowResultDataMapper;
import com.myst3ry.data.remote.api.ApiMapper;
import com.myst3ry.domain.model.detail.TvShowDetailModel;
import com.myst3ry.domain.model.item.TvShowItemModel;
import com.myst3ry.domain.model.result.TvShowResultModel;
import com.myst3ry.domain.repository.TvShowsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public final class TvShowsRepositoryImpl implements TvShowsRepository {

    private final TvShowsDAO mTvShowsDao;
    private final ApiMapper mApiMapper;

    @Inject
    public TvShowsRepositoryImpl(final TvShowsDAO tvShowsDao, final ApiMapper apiMapper) {
        this.mTvShowsDao = tvShowsDao;
        this.mApiMapper = apiMapper;
    }

    @Override
    public Observable<List<TvShowItemModel>> getTvShows(final int type) {
        return mTvShowsDao.getTvShowsByType(type)
                .map(TvShowItemDataMapper::transform)
                .toObservable();
    }

    @Override
    public Observable<TvShowDetailModel> getTvShowDetailsById(final int tvShowId) {
        return null; //todo api+db
    }

    @Override
    public Observable<List<TvShowResultModel>> getPopularTvShows() {
        return mApiMapper.getPopularTvShows(1)
                .map(TvShowResultDataMapper::transform);
    }

    @Override
    public Observable<List<TvShowResultModel>> searchTvShowsByQuery(final String query) {
        return mApiMapper.searchTvShowsByQuery(query, 1)
                .map(TvShowResultDataMapper::transform);
    }

    @Override
    public void setTvShowRating(final int tvShowId, final double rating) {
        mTvShowsDao.getTvShowById(tvShowId)
                .toObservable()
                .observeOn(Schedulers.computation())
                .doOnNext(movie -> movie.setRating(rating))
                .subscribe();
    }

    @Override
    public void addTvShowToWatchlist(final int tvShowId) {
        //todo db
    }

    @Override
    public void addTvShowToFavorites(final int tvShowId) {
        //todo db
    }

    @Override
    public void deleteTvShowById(final int tvShowId, final int type) {
        //todo db
    }
}
