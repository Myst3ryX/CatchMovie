package com.myst3ry.data.repository;

import com.myst3ry.data.local.database.dao.TvShowsDAO;
import com.myst3ry.data.mapper.TvShowItemDataMapper;
import com.myst3ry.data.remote.api.ApiMapper;
import com.myst3ry.domain.model.detail.TvShowDetailModel;
import com.myst3ry.domain.model.item.TvShowItemModel;
import com.myst3ry.domain.repository.TvShowsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

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
    public Observable<List<TvShowItemModel>> searchTvShowsByQuery(final String query) {
        return null; //todo api
    }

    @Override
    public Observable<TvShowDetailModel> getTvShowDetailsById(final int tvShowId) {
        return null; //todo api+db
    }

    @Override
    public Observable<TvShowItemModel> catchTvShowWithParams(final Object... params) {
        return null; //todo api + save recent
    }

    @Override
    public void setTvShowRating(final int tvShowId, final double rating) {
        //todo db
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
