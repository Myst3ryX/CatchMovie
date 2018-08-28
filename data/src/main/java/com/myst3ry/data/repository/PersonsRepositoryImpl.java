package com.myst3ry.data.repository;

import com.myst3ry.data.local.database.dao.PersonsDAO;
import com.myst3ry.data.mapper.PersonItemDataMapper;
import com.myst3ry.data.remote.api.ApiMapper;
import com.myst3ry.domain.model.detail.PersonDetailModel;
import com.myst3ry.domain.model.item.PersonItemModel;
import com.myst3ry.domain.repository.PersonsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class PersonsRepositoryImpl implements PersonsRepository {

    private final PersonsDAO mPersonsDao;
    private final ApiMapper mApiMapper;

    @Inject
    public PersonsRepositoryImpl(final PersonsDAO personsDao, final ApiMapper apiMapper) {
        this.mPersonsDao = personsDao;
        this.mApiMapper = apiMapper;
    }

    @Override
    public Observable<List<PersonItemModel>> getPersons() {
        return mPersonsDao.getPersons()
                .map(PersonItemDataMapper::transform)
                .toObservable();
    }

    @Override
    public Observable<List<PersonItemModel>> searchPersonsByQuery(final String query) {
        return null; //todo api
    }

    @Override
    public Observable<PersonDetailModel> getPersonDetailsById(final int personId) {
        return null; //todo api+db
    }

    @Override
    public void addPersonToFavorites(final int personId) {
        //todo db
    }

    @Override
    public void deletePersonById(final int personId) {
        //todo db
    }
}
