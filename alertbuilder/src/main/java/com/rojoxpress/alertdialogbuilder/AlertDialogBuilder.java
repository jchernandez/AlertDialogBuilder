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


public class AlertDialogBuilder extends Builder implements DialogInterface.OnClickListener {

    private int negativeTextColor;
    private int positiveTextColor;
    private int neutralTextColor;
    private String defNegativeColor = "#515151";
    private String defNeutralColor = "#515151";
    private Context context;

    public AlertDialogBuilder(Context context) {
        super(context);
        this.context =  context;
        negativeTextColor = Color.parseColor(defNegativeColor);
        neutralTextColor = Color.parseColor(defNeutralColor);
        positiveTextColor = resolveColor(context);
    }

    public AlertDialogBuilder(Context context, int theme) {
        super(context, theme);
    }

    public void setNegativeColor(int color) {
        negativeTextColor = color;
    }

    public void setNeutralColor(int color) {
        neutralTextColor = color;
    }

    public void setPositiveColor(int color) {
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

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }


    @ColorInt
    public static int resolveColor(Context context) {
        TypedValue a = new TypedValue();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            context.getTheme().resolveAttribute(android.R.attr.colorAccent, a, true);
        } else {
            context.getTheme().resolveAttribute(R.attr.colorAccent, a, true);
        }
        return a.data;
    }

}