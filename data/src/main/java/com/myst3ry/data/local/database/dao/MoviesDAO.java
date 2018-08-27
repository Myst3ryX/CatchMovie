package com.myst3ry.data.local.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.myst3ry.data.local.entity.MovieEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface MoviesDAO {

    @Query("SELECT * FROM Movies WHERE type = :type")
    Flowable<List<MovieEntity>> getMoviesByType(final int type);

    @Query("SELECT * FROM Movies WHERE id = :movieId AND type = :type")
    Flowable<MovieEntity> getMovie(final int movieId, final int type);

    @Query("SELECT * FROM Movies WHERE id = :movieId")
    Flowable<MovieEntity> getMovieById(final int movieId);

    @Query("DELETE FROM Movies WHERE id = :movieId AND type = :type")
    void deleteMovie(final int movieId, final int type);

    @Query("DELETE FROM Movies WHERE id = :movieId")
    void deleteMovieById(final int movieId);

    @Query("DELETE FROM Movies")
    void clearMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(final MovieEntity movieEntity);

    @Update
    void updateMovie(final MovieEntity movieEntity);
}
