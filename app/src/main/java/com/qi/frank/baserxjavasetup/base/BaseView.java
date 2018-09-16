package com.qi.frank.baserxjavasetup.base;

public interface BaseView {

    int getContentViewLayoutResId();

    void showLoading();

    void hideLoading();

    void onShowError(String error);

    void onTimeout();

    void onNetworkError();

    boolean isNetworkConnected();

    void onConnectionError();
}
