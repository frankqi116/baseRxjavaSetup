package com.qi.frank.baserxjavasetup.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseFragment extends Fragment implements BaseFragmentView  {

    private static final String TAG = "BaseFragment";

    private Unbinder unbinder;

    public BaseFragment() {
        super();
        Log.d(TAG, getClass().getName());
    }

    @Override
    public int getContentViewLayoutResId() {
        return 0;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                getContentViewLayoutResId(), container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }

        super.onDestroyView();
    }

}
