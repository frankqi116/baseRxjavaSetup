package com.qi.frank.baserxjavasetup.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public final class SelectComponentBuilder {

    private static final String TAG = "SelectComponentBuilder";

    public static void showSelectDate(Context context, View view,
                                      final DatePicker dp, final String selected_date,
                                      int pbtnId, DialogInterface.OnClickListener plistener,
                                      int nbtnId, DialogInterface.OnClickListener nlistener) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -18);
        cal.add(Calendar.DATE, -1);
        Date date = cal.getTime();
        dp.setMaxDate(date.getTime());
        if (!TextUtils.isEmpty(selected_date)) {
            try {
                Date selectedValue = Global.FORMAT_DATE.parse(selected_date);
                Calendar tmpCalender = Calendar.getInstance();
                tmpCalender.setTime(selectedValue);
                dp.updateDate(tmpCalender.get(Calendar.YEAR), tmpCalender.get(Calendar.MONTH), tmpCalender.get(Calendar.DAY_OF_MONTH));
            } catch (ParseException e) {
                Log.d(TAG, "showSelectDate() called with: ");
            }
        }
        AlertDialog.Builder builder = AlertDialogManager.createAlertBuilder(context);
        builder.setView(view);
        builder.setPositiveButton(pbtnId, plistener);
        builder.setNegativeButton(nbtnId, nlistener);
        builder.setCancelable(false);
        builder.show();
    }
}
