package com.qi.frank.baserxjavasetup.utils;

public class Capitalize {

    public static String capitalize(String str) {
        int strLen;
        return str != null && (strLen = str.length()) != 0 ? (new StringBuilder(strLen)).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1)).toString() : str;
    }

}
