package com.myst3ry.catchmovie.ui.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<T extends BaseView> {

    protected T mView;
    protected CompositeDisposable mDisposables = new CompositeDisposable();

    public void attachView(T view) {
        this.mView = view;
    }

    protected void addDisposable(final Disposable disposable) {
        if (disposable != null) {
            mDisposables.add(disposable);
        }
    }

    public void disposeAll() {
        if (!mDisposables.isDisposed()) {
            mDisposables.dispose();
        }
    }

    public void detachView() {
        this.mView = null;
    }
}