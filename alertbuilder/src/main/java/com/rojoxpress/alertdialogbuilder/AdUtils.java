package com.rojoxpress.alertdialogbuilder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.util.TypedValue;

/**
 * Created by rojo on 20/12/16.
 */

public class AdUtils {


    public static int  defColor = Color.parseColor("#00897B");


    /**
     * Resolve a color data from an attribute
     * @param context Context of the application
     * @param attr Attribute color to resolve
     * @param defColor Default color in case of error
     * @return int resolved color.
     */
    @ColorInt
    public static int resolveColor(Context context,int attr, @ColorInt int defColor) {
        TypedValue a = new TypedValue();
        context.getTheme().resolveAttribute(attr, a, true);
        if(a.data == 0) {
            return defColor;
        } else {
            return a.data;
        }
    }
}
