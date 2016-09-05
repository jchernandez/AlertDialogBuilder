package com.rojoxpress.alertdialogbuilder;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.util.TypedValue;
import android.widget.Button;


public class AlertDialogBuilder extends Builder {

    private int negativeTextColor;
    private int positiveTextColor;
    private int neutralTextColor;
    private String defNegativeColor = "#515151";
    private Context context;

    /**
     * Creates a builder for an alert dialog that uses the default alert
     * dialog theme.
     * <p>
     * The default alert dialog theme is defined by
     * {@link android.R.attr#alertDialogTheme} within the parent
     * {@code context}'s theme.
     *
     * @param context the parent context
     */
    public AlertDialogBuilder(Context context) {
        super(context);
        this.context =  context;

        int accent,primary;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            accent = android.R.attr.colorAccent;
            primary = android.R.attr.colorPrimary;
        } else {
            accent = R.attr.colorAccent;
            primary = R.attr.colorPrimary;
        }

        negativeTextColor = Color.parseColor(defNegativeColor);
        neutralTextColor = resolveColor(context,primary);
        positiveTextColor = resolveColor(context,accent);
    }

    public AlertDialogBuilder(Context context, int theme) {
        super(context, theme);
    }

    /**
     * Set the color of the Negative button
     * @param color int color;
     */
    public void setNegativeColor(int color) {
        negativeTextColor = color;
    }

    /**
     * Set the color of the Neutral button
     * @param color int color;
     */
    public void setNeutralColor(@ColorInt int color) {
        neutralTextColor = color;
    }

    /**
     * Set the color of the Positive button
     * @param color int color;
     */
    public void setPositiveColor(@ColorInt int color) {
        positiveTextColor = color;
    }

    @Override
    public AlertDialog show() {
        AlertDialog dialog = super.show();
        Button negativeButton = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        Button positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        Button neutralButton = dialog.getButton(DialogInterface.BUTTON_NEUTRAL);
        negativeButton.setTextColor(negativeTextColor);
        positiveButton.setTextColor(positiveTextColor);
        neutralButton.setTextColor(neutralTextColor);
        return dialog;
    }


    /**
     * Resolve a color data from an attribute
     * @param context Context of the application
     * @param attr Attribute color to resolve
     * @return int resolved color.
     */
    @ColorInt
    private int resolveColor(Context context,int attr) {
        TypedValue a = new TypedValue();
        context.getTheme().resolveAttribute(attr, a, true);
        return a.data;
    }

}