package com.myst3ry.data.local.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.myst3ry.data.local.database.dao.MoviesDAO;
import com.myst3ry.data.local.database.dao.PersonsDAO;
import com.myst3ry.data.local.database.dao.TvShowsDAO;
import com.myst3ry.data.local.entity.MovieEntity;
import com.myst3ry.data.local.entity.PersonEntity;
import com.myst3ry.data.local.entity.TvShowEntity;

@Database(entities = {MovieEntity.class, TvShowEntity.class, PersonEntity.class}, version = 2)
public abstract class CMDatabase extends RoomDatabase {

    public abstract MoviesDAO getMoviesDao();

    public abstract TvShowsDAO getTvShowsDao();

    public abstract PersonsDAO getPersonsDao();
}
