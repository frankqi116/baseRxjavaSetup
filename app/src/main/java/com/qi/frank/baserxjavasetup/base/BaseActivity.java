package com.qi.frank.baserxjavasetup.base;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.qi.frank.baserxjavasetup.R;
import com.qi.frank.baserxjavasetup.network.APIs;
import com.qi.frank.baserxjavasetup.network.APIsHelper;
import com.qi.frank.baserxjavasetup.utils.Global;
import com.qi.frank.baserxjavasetup.utils.ToastManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

public class BaseActivity extends AppCompatActivity implements BaseView {

    private static final String TAG = "BaseActivity";

    private final static ColorDrawable progressBackground = new ColorDrawable(android.graphics.Color.TRANSPARENT);

    private Unbinder unbinder;

    private Dialog progressLoading;

    private CompositeDisposable compositeDisposable;

    @Override
    public int getContentViewLayoutResId() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, getClass().getName());
        super.onCreate(savedInstanceState);
        createProgressLoading();

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

    protected void createProgressLoading() {
        progressLoading = new Dialog(BaseActivity.this);
        progressLoading.setCancelable(false);
        progressLoading.getWindow().setBackgroundDrawable(progressBackground);
        progressLoading.setContentView(R.layout.default_progress_dialog);
    }

    @Override
    public void showLoading() {
        progressLoading.show();
    }

    @Override
    public void hideLoading() {
        progressLoading.dismiss();
    }

    @Override
    public void onShowError(String error) {
        ToastManager.showToast(error);
        hideLoading();
    }

    @Override
    public void onTimeout() {
        hideLoading();
    }

    @Override
    public void onNetworkError() {
        ToastManager.showNetworkError();
        hideLoading();
    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void onConnectionError() {

    }
}
