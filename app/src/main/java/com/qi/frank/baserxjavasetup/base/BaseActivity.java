package com.qi.frank.baserxjavasetup.base;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.qi.frank.baserxjavasetup.network.APIs;
import com.qi.frank.baserxjavasetup.network.APIsHelper;
import com.qi.frank.baserxjavasetup.utils.Global;
import com.qi.frank.baserxjavasetup.utils.ToastManager;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

public class BaseActivity extends AppCompatActivity implements BaseView{

    private static final String TAG = "Sileckt";

    private Unbinder unbinder;

    private AVLoadingIndicatorView avLoadingIndicatorView;

    private CompositeDisposable compositeDisposable;

    @Override
    public int getContentViewLayoutResId() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, getClass().getName());
        super.onCreate(savedInstanceState);

        setContentView(getContentViewLayoutResId());
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }

        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }

    public void onBackBtnClicked(View view) {
        Global.hideKeyboard(view);
        onBackPressed();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        touchNotEditTextHideKeyboard(event);
        return super.dispatchTouchEvent(event);
    }

    protected void touchNotEditTextHideKeyboard(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    Global.hideKeyboard(getCurrentFocus());
                }
            }
        }
    }

    public CompositeDisposable getCompositeDisposable() {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        return compositeDisposable;
    }

    public APIs createAPIs() {
        return APIsHelper.getInstance().build();
    }

    @Override
    public void showLoading(AVLoadingIndicatorView indicator) {
        if (indicator != null) {
            avLoadingIndicatorView = indicator;
            avLoadingIndicatorView.show();
        }
    }

    @Override
    public void hideLoading() {
        if (avLoadingIndicatorView != null) {
            avLoadingIndicatorView.hide();
        }
    }

    @Override
    public void onShowError(String error) {
        ToastManager.showToast(error);
    }

    @Override
    public void onTimeout() {

    }

    @Override
    public void onNetworkError() {
        ToastManager.showNetworkError();
    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void onConnectionError() {

    }
}
