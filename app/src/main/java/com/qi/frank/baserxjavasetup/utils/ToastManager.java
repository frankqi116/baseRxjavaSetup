package com.qi.frank.baserxjavasetup.utils;

import android.support.annotation.StringRes;
import android.util.Log;
import android.widget.Toast;

import com.qi.frank.baserxjavasetup.R;

public final class ToastManager {

    private static final String TAG = "ToastManager";

    public static void showNetworkError() {
        Log.d(TAG, "showNetworkError() called");
        showToast(R.string.network_error);
    }

    public static void showToast(@StringRes int resId) {
        Toast.makeText(Global.getApplicationContext(),
                resId, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(CharSequence text) {
        Toast.makeText(Global.getApplicationContext(),
                text, Toast.LENGTH_SHORT).show();
    }
}
