package com.qi.frank.baserxjavasetup.base;

import com.wang.avi.AVLoadingIndicatorView;

public interface BaseView {

  int getContentViewLayoutResId();

  void showLoading(AVLoadingIndicatorView indicator);

  void hideLoading();

  void onShowError(String error);

  void onTimeout();

  void onNetworkError();

  boolean isNetworkConnected();

  void onConnectionError();
}
