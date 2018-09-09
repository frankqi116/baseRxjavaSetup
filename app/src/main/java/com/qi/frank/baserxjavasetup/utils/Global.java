package com.qi.frank.baserxjavasetup.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.qi.frank.baserxjavasetup.R;
import com.qi.frank.baserxjavasetup.model.User;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Global {

    private static Context applicationContext;
    private static SharedPreferences defaultSharedPreferences;

    private static final String ID = "id";
    private static final String TOKEN = "token";

    private static final String LAT = "latitude";
    private static final String LON = "longitude";

    public static final String DEVICE_TYPE = "Android";
    private static final String DEVICE_TOKEN = "device_token";

    public static final String WEB_VIEW_URL = "url";
    public static final String URL_TERMS_CONDITIONS = "/terms-and-conditions";
    public static final String URL_PRIVACY_POLICY = "/privacy";
    public static final String URL_ABOUT_SILECKT = "/about-us";

    public static final SimpleDateFormat FORMAT_DATE =
            new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    private static User USER;

    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static void init(Context context) {
        applicationContext = context;
        defaultSharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(applicationContext);
    }

    public static void hideKeyboard(View currentFocus) {
        if (currentFocus != null) {
            currentFocus.clearFocus();
            InputMethodManager imm = (InputMethodManager) applicationContext
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }

    public static void showKeyboard(View currentFocus) {
        if (currentFocus != null) {
            InputMethodManager imm = (InputMethodManager) applicationContext
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
            }
        }
    }

    public static boolean isConnective() {
        ConnectivityManager cm = (ConnectivityManager) applicationContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return false;
        }
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static void askForInternet(final Context context) {
        AlertDialogManager.showAlert(context, R.string.network_hint,
                R.string.cancel, null, R.string.settings, (dialog, which) -> {
                    dialog.dismiss();
                    Intent i = new Intent(Settings.ACTION_WIFI_SETTINGS);
                    context.startActivity(i);
                }, false);
    }

    public static void setUser(User u) {
        USER = new User(u);
        defaultSharedPreferences.edit().putString(ID, u.getId()).apply();
        defaultSharedPreferences.edit().putString(TOKEN, u.getAccess_token()).apply();
    }

    public static void removeUser() {
        defaultSharedPreferences.edit().remove(ID).apply();
        defaultSharedPreferences.edit().remove(TOKEN).apply();
    }

    private static void asGuest() {
        USER = new User();
        USER.setId("-1");
    }

    public static User getUser() {
        if (USER == null) {
            asGuest();
        }
        return USER;
    }

    public static boolean currentUserIsGuest() {
        return (USER != null && USER.getId().equals("-1"));
    }

    public static String getID() {
        return defaultSharedPreferences.getString(ID, null);
    }

    public static String getTOKEN() {
        return defaultSharedPreferences.getString(TOKEN, null);
    }

    public static void setDeviceToken(String token) {
        defaultSharedPreferences.edit().putString(DEVICE_TOKEN, token).apply();
    }

    public static String getDeviceToken() {
        return defaultSharedPreferences.getString(DEVICE_TOKEN, null);
    }

    public static void deleteDeviceToken() {
        defaultSharedPreferences.edit().remove(DEVICE_TOKEN).apply();
    }

    public static void setLocation(String lat, String lon) {
        defaultSharedPreferences.edit().putString(LAT, lat).apply();
        defaultSharedPreferences.edit().putString(LON, lon).apply();
    }

    public static String getLAT() {
        return defaultSharedPreferences.getString(LAT, null);
    }

    public static String getLON() {
        return defaultSharedPreferences.getString(LON, null);
    }

    public static boolean currentUserPresent() {
        return (getID() != null && getTOKEN() != null);
    }
}
