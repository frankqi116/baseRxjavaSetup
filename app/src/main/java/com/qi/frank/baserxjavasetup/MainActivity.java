package com.qi.frank.baserxjavasetup;

import android.os.Bundle;

import com.qi.frank.baserxjavasetup.base.BaseActivity;
import com.qi.frank.baserxjavasetup.model.User;
import com.qi.frank.baserxjavasetup.network.APIsCallbackWrapper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @Override
    public int getContentViewLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getCompositeDisposable().add(createAPIs().getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new APIsCallbackWrapper<User>(this) {
                    @Override
                    protected void onSuccess(User user) {
                        // todo add business logic here
                    }
                }));
    }
}
