package com.myst3ry.data.local.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.myst3ry.data.local.entity.PersonEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface PersonsDAO {

    @Query("SELECT * FROM Persons WHERE favorite = 1 ORDER BY creation_date DESC")
    Flowable<List<PersonEntity>> getFavoritePersons();

    @Query("SELECT * FROM Persons WHERE id = :personId")
    Single<PersonEntity> getPersonById(final int personId);

    @Query("DELETE FROM Persons WHERE id = :personId")
    void deletePersonById(final int personId);

    @Query("DELETE FROM Persons")
    void clearPersons();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPerson(final PersonEntity personEntity);

    @Update
    void updatePerson(final PersonEntity movieEntity);
}
