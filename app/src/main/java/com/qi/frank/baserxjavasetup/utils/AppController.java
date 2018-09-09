package com.qi.frank.baserxjavasetup.utils;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.qi.frank.baserxjavasetup.BuildConfig;

public class AppController extends MultiDexApplication {

    private static final String TAG = "AppController";

    private FontManager fontManager;

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        if (BuildConfig.DEBUG) {

        } else {
            // Fabric.with(this, new Crashlytics());
        }
        Global.init(getApplicationContext());

        fontManager = FontManager.getInstance();
        // add your custom fonts here with your own custom name.
        fontManager.addFont("faFont", "fontawesome.ttf");
        fontManager.addFont("imFont", "icomoon.ttf");
        fontManager.addFont("maFont", "materialIcons.ttf");
    }

    public AppController() {
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static synchronized AppController getInstance() {
        if (mInstance == null) {
            mInstance = new AppController();
        }
        return mInstance;
    }

}
