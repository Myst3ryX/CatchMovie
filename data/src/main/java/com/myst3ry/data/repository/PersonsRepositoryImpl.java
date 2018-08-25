package com.myst3ry.data.repository;

import com.myst3ry.data.repository.datasource.LocalDataSource;
import com.myst3ry.data.repository.datasource.RemoteDataSource;
import com.myst3ry.domain.model.Person;
import com.myst3ry.domain.repository.PersonsRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class PersonsRepositoryImpl implements PersonsRepository {

    private final LocalDataSource mLocalDataSource;
    private final RemoteDataSource mRemoteDataSource;

    @Inject
    public PersonsRepositoryImpl(final LocalDataSource localDataSource,
                                 final RemoteDataSource remoteDataSource) {
        this.mLocalDataSource = localDataSource;
        this.mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<Person>> getFavoriteActors() {
        return Observable.just(new ArrayList<>());
    }

    @Override
    public Observable<List<Person>> searchPersonsByQuery(String query) {
        return null;
    }

    @Override
    public Observable<Person> getPersonDetailsById(int personId) {
        return null;
    }

    @Override
    public void addPersonToFavorites(int personId) {

    }

    @Override
    public void deletePersonById(int personId) {

    }
}
