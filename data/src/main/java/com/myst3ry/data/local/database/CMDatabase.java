package com.myst3ry.data.local.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.myst3ry.data.local.database.dao.MoviesDAO;
import com.myst3ry.data.local.database.dao.PersonsDAO;
import com.myst3ry.data.local.database.dao.TvShowsDAO;
import com.myst3ry.data.local.entity.MovieEntity;
import com.myst3ry.data.local.entity.PersonEntity;
import com.myst3ry.data.local.entity.TvShowEntity;

/**
 * A abstract subclass that acts as room database {@link RoomDatabase} instance.
 * Database contains next tables:
 * Movies {@link MovieEntity},
 * TvShows {@link TvShowEntity},
 * Persons {@link PersonEntity}.
 */
@Database(entities = {MovieEntity.class, TvShowEntity.class, PersonEntity.class}, version = 6)
public abstract class CMDatabase extends RoomDatabase {

    /**
     * @return generated {@link MoviesDAO} class
     */
    public abstract MoviesDAO getMoviesDao();

    /**
     * @return generated {@link TvShowsDAO} class
     */
    public abstract TvShowsDAO getTvShowsDao();

    /**
     * @return generated {@link PersonsDAO} class
     */
    public abstract PersonsDAO getPersonsDao();
}
