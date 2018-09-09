package com.qi.frank.baserxjavasetup.base;

import android.support.v4.app.Fragment;
import android.util.Log;

public class BaseFragment extends Fragment {

    private static final String TAG = "Sileckt";

    public BaseFragment() {
        super();
        Log.d(TAG, getClass().getName());
    }

}
