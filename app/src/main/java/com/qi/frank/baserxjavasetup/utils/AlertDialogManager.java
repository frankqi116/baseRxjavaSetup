package com.qi.frank.baserxjavasetup.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.pixelforce.sileckt.R;

public final class AlertDialogManager {

    private static final String TAG = "AlertDialogManager";

    public static void showAlert(Context context, int messageId, int btnId, boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, messageId, btnId, null, cancelable);
        builder.show();
    }

    public static void showAlert(Context context, int messageId, int btnId, DialogInterface.OnClickListener listener, boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, messageId, btnId, listener, cancelable);
        builder.show();
    }

    public static void showAlert(Context context, int messageId, int titleId, int btnId, boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, messageId, titleId, btnId, cancelable);
        builder.show();
    }

    public static void showAlert(Context context, int messageId, int titleId, int btnId, DialogInterface.OnClickListener listener, boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, messageId, titleId, btnId, listener, cancelable);
        builder.show();
    }

    public static void showAlert(Context context, String message, int nbtnId, DialogInterface.OnClickListener nlistener, boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, message, nbtnId, nlistener, cancelable);
        builder.show();
    }

    public static void showAlert(Context context, String message, int nbtnId, DialogInterface.OnClickListener nlistener,
                                 int pbtnId, DialogInterface.OnClickListener plistener, boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, message, nbtnId, nlistener, pbtnId, plistener, cancelable);
        builder.show();
    }

    public static void showAlert(Context context, String message, int titleId, int nbtnId, DialogInterface.OnClickListener nlistener,
                                 int pbtnId, DialogInterface.OnClickListener plistener, boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, message, nbtnId, nlistener, pbtnId, plistener, cancelable);
        builder.setTitle(titleId);
        builder.show();
    }

    public static void showAlert(Context context, String message, String title, int btnId, DialogInterface.OnClickListener listener, boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, message, title, btnId, listener, cancelable);
        builder.show();
    }

    public static void showAlert(Context context, int messageId, int nbtnId, DialogInterface.OnClickListener nlistener, int pbtnId, DialogInterface.OnClickListener plistener, boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, messageId, nbtnId, nlistener, pbtnId, plistener, cancelable);
        builder.show();
    }

    public static void showAlert(Context context, int messageId, int titleId, int nbtnId, DialogInterface.OnClickListener nlistener, int pbtnId, DialogInterface.OnClickListener plistener, boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, messageId, titleId, nbtnId, nlistener, pbtnId, plistener, cancelable);
        builder.show();
    }

    public static void showAlert(Context context, String message, String title,
                                 int nbtnId, DialogInterface.OnClickListener nlistener,
                                 int pbtnId, DialogInterface.OnClickListener plistener,
                                 int neutralbtnId, DialogInterface.OnClickListener neutrallistener,
                                 boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, message, title,
                nbtnId, nlistener,
                pbtnId, plistener,
                neutralbtnId, neutrallistener, cancelable);
        builder.create();
        builder.show();
    }

    public static AlertDialog.Builder createAlertBuilder(Context context) {
        return new AlertDialog.Builder(context, R.style.CustomDialogTheme);
    }

    private static AlertDialog.Builder createAlertBuilder(Context context, int messageId, int titleId, int btnId, boolean cancelable) {
        return createAlertBuilder(context, messageId, titleId, btnId, null, cancelable);
    }

    private static AlertDialog.Builder createAlertBuilder(Context context, int messageId,
                                                          int nbtnId, DialogInterface.OnClickListener nlistener,
                                                          int pbtnId, DialogInterface.OnClickListener plistener,
                                                          boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, messageId, nbtnId, nlistener, cancelable);
        builder.setPositiveButton(pbtnId, plistener);
        return builder;
    }

    private static AlertDialog.Builder createAlertBuilder(Context context, int messageId, int titleId,
                                                          int nbtnId, DialogInterface.OnClickListener nlistener,
                                                          int pbtnId, DialogInterface.OnClickListener plistener,
                                                          boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, messageId, titleId, nbtnId, nlistener, cancelable);
        builder.setPositiveButton(pbtnId, plistener);
        return builder;
    }

    private static AlertDialog.Builder createAlertBuilder(Context context, int messageId, int titleId,
                                                          int btnId, DialogInterface.OnClickListener listener,
                                                          boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, messageId, btnId, listener, cancelable);
        builder.setTitle(titleId);
        return builder;
    }

    private static AlertDialog.Builder createAlertBuilder(Context context, int messageId,
                                                          int btnId, DialogInterface.OnClickListener listener,
                                                          boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.CustomDialogTheme);
        builder.setMessage(messageId)
                .setCancelable(cancelable)
                .setNegativeButton(btnId, listener);
        return builder;
    }

    private static AlertDialog.Builder createAlertBuilder(Context context, String message,
                                                          int nbtnId, DialogInterface.OnClickListener nlistener,
                                                          int pbtnId, DialogInterface.OnClickListener plistener,
                                                          boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, message, nbtnId, nlistener, cancelable);
        builder.setPositiveButton(pbtnId, plistener);
        return builder;
    }

    private static AlertDialog.Builder createAlertBuilder(Context context, String message, String title,
                                                          int nbtnId, DialogInterface.OnClickListener nlistener,
                                                          int pbtnId, DialogInterface.OnClickListener plistener,
                                                          int neutralbtnId, DialogInterface.OnClickListener neutrallistener,
                                                          boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, message, title, nbtnId, nlistener, cancelable);
        builder.setPositiveButton(pbtnId, plistener);
        builder.setNeutralButton(neutralbtnId, neutrallistener);
        return builder;
    }

    private static AlertDialog.Builder createAlertBuilder(Context context, String message, String title,
                                                          int btnId, DialogInterface.OnClickListener listener,
                                                          boolean cancelable) {
        AlertDialog.Builder builder = createAlertBuilder(context, message, btnId, listener, cancelable);
        builder.setTitle(title);
        return builder;
    }

    private static AlertDialog.Builder createAlertBuilder(Context context, String message,
                                                          int btnId, DialogInterface.OnClickListener listener,
                                                          boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.CustomDialogTheme);
        builder.setMessage(message)
                .setCancelable(cancelable)
                .setNegativeButton(btnId, listener);
        return builder;
    }
}
