package com.myst3ry.data.local.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.myst3ry.data.local.entity.TvShowEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface TvShowsDAO {

    @Query("SELECT * FROM TvShows WHERE recent = 1 ORDER BY creation_date DESC")
    Flowable<List<TvShowEntity>> getRecentTvShows();

    @Query("SELECT * FROM TvShows WHERE watchlist = 1 ORDER BY creation_date DESC")
    Flowable<List<TvShowEntity>> getWatchlistTvShows();

    @Query("SELECT * FROM TvShows WHERE favorite = 1 ORDER BY creation_date DESC")
    Flowable<List<TvShowEntity>> getFavoriteTvShows();

    @Query("SELECT * FROM TvShows WHERE id = :tvShowId")
    Single<TvShowEntity> getTvShowById(final int tvShowId);

    @Query("DELETE FROM TvShows")
    void clearTvShows();

    @Delete
    void deleteTvShow(final TvShowEntity tvShowEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTvShow(final TvShowEntity tvShowEntity);

    @Update
    void updateTvShow(final TvShowEntity tvShowEntity);
}
