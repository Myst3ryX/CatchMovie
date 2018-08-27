package com.myst3ry.data.local.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.myst3ry.data.local.entity.TvShowEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface TvShowsDAO {

    @Query("SELECT * FROM TvShows WHERE type = :type")
    Flowable<List<TvShowEntity>> getTvShowsByType(final int type);

    @Query("SELECT * FROM TvShows WHERE id = :tvShowId AND type = :type")
    Flowable<TvShowEntity> getTvShow(final int tvShowId, final int type);

    @Query("SELECT * FROM TvShows WHERE id = :tvShowId")
    Flowable<TvShowEntity> getTvShowById(final int tvShowId);

    @Query("DELETE FROM TvShows WHERE id = :tvShowId")
    void deleteTvShow(final int tvShowId);

    @Query("DELETE FROM TvShows WHERE id = :tvShowId")
    void deleteTvShowById(final int tvShowId);

    @Query("DELETE FROM TvShows")
    void clearTvShows();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTvShow(final TvShowEntity tvShowEntity);

    @Update
    void updateTvShow(final TvShowEntity tvShowEntity);
}
