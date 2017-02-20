package com.rojoxpress.alertdialogbuilder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Button;


public class AlertDialogBuilder extends Builder {

    private int negativeTextColor;
    private int positiveTextColor;
    private int neutralTextColor;
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
        init();
    }

    public AlertDialogBuilder(Context context, int theme) {
        super(context, theme);
        init();
    }


    public void init() {
        int accent = AdUtils.getAccentColorAttr();
        int primary = AdUtils.getPrimaryColorAttr();

        String defNegativeColor = "#515151";
        negativeTextColor = Color.parseColor(defNegativeColor);

        positiveTextColor = AdUtils.resolveColor(context, R.attr.ad_positiveColor,
                AdUtils.resolveColor(context,accent,AdUtils.defColor));
        neutralTextColor = AdUtils.resolveColor(context, R.attr.ad_neutralColor,
                AdUtils.resolveColor(context,primary,AdUtils.defColor));
        negativeTextColor = AdUtils.resolveColor(context, R.attr.ad_negativeColor,
                negativeTextColor);
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


    public static AlertDialog showAlert(Context context, @StringRes int title, @StringRes int message,
                                        @StringRes int positiveButton, @StringRes int negativeButton,
                                        @StringRes int neutralButton,
                                        DialogInterface.OnClickListener onClickListener) {
        return showAlert(context, context.getString(title),
                context.getString(message),
                context.getString(positiveButton),
                context.getString(negativeButton),
                context.getString(neutralButton),
                onClickListener);
    }

    public static AlertDialog showAlert(Context context, CharSequence title,
                                               CharSequence message, CharSequence positiveButton,
                                               CharSequence negativeButton, CharSequence neutralButton,
                                               DialogInterface.OnClickListener onClickListener) {

        AlertDialogBuilder builder = new AlertDialogBuilder(context);


        if(title != null) {
            builder.setTitle(title);
        }

        if(message != null) {
            builder.setMessage(message);
        }

        if(positiveButton != null) {
            builder.setPositiveButton(positiveButton, onClickListener);
        }

        if(negativeButton != null) {
            builder.setNegativeButton(negativeButton, onClickListener);
        }

        if (neutralButton != null) {
            builder.setNeutralButton(neutralButton, onClickListener);
        }


        return builder.show();
    }

}