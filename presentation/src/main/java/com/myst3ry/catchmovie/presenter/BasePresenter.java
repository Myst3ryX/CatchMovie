package com.myst3ry.catchmovie.presenter;

public abstract class BasePresenter<T> {

    protected T mView;

    public void attachView(T view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
    }
}