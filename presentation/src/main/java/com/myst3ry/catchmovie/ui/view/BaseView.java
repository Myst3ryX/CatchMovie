package com.myst3ry.catchmovie.ui.view;

public interface BaseView {

    void showToast(final String message);

    void showLongToast(final String message);

    void showProgressBar();

    void hideProgressBar();
}
