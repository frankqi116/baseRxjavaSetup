package com.qi.frank.baserxjavasetup.utils;

import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;

public class FontManager {
    private static final String TAG = "FontManager";

    private static final String ROOT = "fonts/";
    private static FontManager fontManager;
    private HashMap<String, String> fontMap = new HashMap<>();
    private HashMap<String, Typeface> fontCache = new HashMap<>();

    private FontManager() {
    }

    public static FontManager getInstance() {
        if (fontManager == null) {
            fontManager = new FontManager();
        }
        return fontManager;
    }

    public void addFont(String alias, String fontName) {
        fontMap.put(alias, fontName);
    }

    public Typeface getFont(String alias) {
        String fontFilename = fontMap.get(alias);
        if (fontFilename == null) {
            Log.e("", "Font not available with name " + alias);
            return null;
        }
        if (fontCache.containsKey(alias)) {
            return fontCache.get(alias);
        } else {
            Typeface typeface = Typeface.createFromAsset(Global.getApplicationContext().getAssets(), ROOT + fontFilename);
            fontCache.put(fontFilename, typeface);
            return typeface;
        }
    }

    public static void markAsIconContainer(TextView textView, String fontName) {
        if (textView != null) {
            textView.setTypeface(getInstance().getFont(fontName));
        } else {
            Log.d(TAG, "markAsIconContainer() called with: textView is null");
        }
    }
}
