package com.qi.frank.baserxjavasetup.utils;

import android.text.TextUtils;
import android.view.View;

import com.annimon.stream.Stream;

public final class TextValueUtils {

    public static boolean isNotEmptyAndN_A(String text) {
        if (!TextUtils.isEmpty(text) && !text.equals("N/A")) {
            return true;
        } else {
            return false;
        }
    }

    public static int showByNotEmptyAndN_A(String text) {
        if (!TextUtils.isEmpty(text) && !text.equals("N/A")) {
            return View.VISIBLE;
        } else {
            return View.GONE;
        }
    }

    public static String splitString(String string) {
        String[] strings = string.split("_");
        StringBuilder str = new StringBuilder();
        Stream.of(strings).forEach(value -> str.append(Capitalize.capitalize(value)).append(" "));
        return str.toString();
    }
}
