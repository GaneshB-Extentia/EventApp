package com.punehackers.eventapp.Utility;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by Chintamani.Kulkarni on 10/5/2015.
 */
public class Constants {


    public static float convertDpToPixels(float dp, Context dpToPixelsContext) {
        Resources resources = dpToPixelsContext.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }
}
