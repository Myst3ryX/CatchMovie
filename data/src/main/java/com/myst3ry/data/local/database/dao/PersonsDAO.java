package com.myst3ry.data.local.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.myst3ry.data.local.entity.PersonEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface PersonsDAO {

    @Query("SELECT * FROM Persons")
    Flowable<List<PersonEntity>> getPersons();

    @Query("SELECT * FROM Persons WHERE id = :personId")
    Flowable<PersonEntity> getPersonById(final int personId);

    @Query("DELETE FROM Persons WHERE id = :personId")
    void deletePersonById(final int personId);

    @Query("DELETE FROM Persons")
    void clearPersons();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPerson(final PersonEntity personEntity);
}
