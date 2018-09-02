package com.myst3ry.data.local.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.myst3ry.data.local.entity.MovieEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface MoviesDAO {

    @Query("SELECT * FROM Movies WHERE recent = 1 ORDER BY creation_date DESC")
    Flowable<List<MovieEntity>> getRecentMovies();

    @Query("SELECT * FROM Movies WHERE watchlist = 1 ORDER BY creation_date DESC")
    Flowable<List<MovieEntity>> getWatchlistMovies();

    @Query("SELECT * FROM Movies WHERE favorite = 1 ORDER BY creation_date DESC")
    Flowable<List<MovieEntity>> getFavoriteMovies();

    @Query("SELECT * FROM Movies WHERE id = :movieId")
    Single<MovieEntity> getMovieById(final int movieId);

    @Query("DELETE FROM Movies")
    void clearMovies();

    @Delete
    void deleteMovie(final MovieEntity movieEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(final MovieEntity movieEntity);

    @Update
    void updateMovie(final MovieEntity movieEntity);
}
