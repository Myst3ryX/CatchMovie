package com.myst3ry.data.repository;

import com.myst3ry.data.local.database.dao.PersonsDAO;
import com.myst3ry.data.mapper.PersonDetailDataMapper;
import com.myst3ry.data.mapper.PersonEntityMapper;
import com.myst3ry.data.mapper.PersonItemDataMapper;
import com.myst3ry.data.mapper.PersonResultDataMapper;
import com.myst3ry.data.remote.api.ApiMapper;
import com.myst3ry.domain.model.detail.PersonDetailModel;
import com.myst3ry.domain.model.item.PersonItemModel;
import com.myst3ry.domain.model.result.PersonResultModel;
import com.myst3ry.domain.repository.PersonsRepository;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Implementation of PersonsRepository interface
 *
 * @see PersonsRepository
 */
public final class PersonsRepositoryImpl implements PersonsRepository {

    private final PersonsDAO mPersonsDao;
    private final ApiMapper mApiMapper;

    @Inject
    public PersonsRepositoryImpl(final PersonsDAO personsDao, final ApiMapper apiMapper) {
        this.mPersonsDao = personsDao;
        this.mApiMapper = apiMapper;
    }

    @Override
    public Observable<List<PersonItemModel>> getFavoritePersons() {
        return mPersonsDao.getFavoritePersons()
                .map(PersonItemDataMapper::transform)
                .toObservable();
    }

    @Override
    public Observable<PersonDetailModel> getPersonDetailsById(final int personId) {
        return mPersonsDao.getPersonById(personId).toObservable()
                .observeOn(Schedulers.computation())
                .onErrorResumeNext(throwable -> {
                    return mApiMapper.getPersonDetails(personId)
                            .map(PersonEntityMapper::transform)
                            .doOnNext(entity -> {
                                entity.setCreationDate(new Date());
                                mPersonsDao.insertPerson(entity);
                            });
                }).map(PersonDetailDataMapper::transform);
    }

    @Override
    public Observable<List<PersonResultModel>> getPopularPersons(final int page) {
        return mApiMapper.getPopularPersons(page)
                .map(PersonResultDataMapper::transform);
    }

    @Override
    public Observable<List<PersonResultModel>> searchPersonsByQuery(final String query, final int page) {
        return mApiMapper.searchPersonsByQuery(query, page)
                .map(PersonResultDataMapper::transform);
    }

    @Override
    public Disposable addPersonById(final int personId) {
        return mPersonsDao.getPersonById(personId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    entity.setFavorite(true);
                    mPersonsDao.updatePerson(entity);
                }).subscribe();
    }

    @Override
    public Disposable deletePersonById(final int personId) {
        return mPersonsDao.getPersonById(personId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    entity.setFavorite(false);
                    mPersonsDao.updatePerson(entity);
                }).subscribe();
    }
}
