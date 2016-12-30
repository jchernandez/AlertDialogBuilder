package com.rojoxpress.alertdialogbuilder;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.rojoxpress.TintedProgressBar;

public class TintedProgressDialog extends AlertDialog {


    private String message;
    private String title;
    private int progressColor = 0;
    private int titleColor = 0;
    private int dividerColor = 0;

    public TintedProgressDialog(@NonNull Context context) {
        super(context);
    }

    public TintedProgressDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    public TintedProgressDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void show() {
        initProgress();
        super.show();
    }



    public static TintedProgressDialog show(Context context, String title, String message, boolean indeterminate, boolean cancelable) {
        TintedProgressDialog progressDialog = new TintedProgressDialog(context);

        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
//        progressDialog.setIndeterminate(indeterminate);
        progressDialog.setCancelable(cancelable);

        progressDialog.show();
        return progressDialog;
    }




    private void initProgress() {

        int accent = AdUtils.getAccentColorAttr();
        int primary = AdUtils.getPrimaryColorAttr();


        dividerColor = AdUtils.resolveColor(getContext(), R.attr.pb_dividerColor,
                AdUtils.resolveColor(getContext(),accent,AdUtils.defColor));
        progressColor = AdUtils.resolveColor(getContext(), R.attr.pb_progressColor,
                AdUtils.resolveColor(getContext(),accent,AdUtils.defColor));
        titleColor = AdUtils.resolveColor(getContext(), R.attr.pb_titleColor,
                accent);
        View view = View.inflate(getContext(), R.layout.view_progress_dialog, null);
        setView(view);
        TextView messageView = (TextView) view.findViewById(R.id.progress_message);
        TextView titleView = (TextView) view.findViewById(R.id.progress_title);
        TintedProgressBar progressBar = (TintedProgressBar) view.findViewById(R.id.progressbar);


        titleView.setTextColor(titleColor);
        view.findViewById(R.id.progress_divider).setBackgroundColor(dividerColor);

        if(title != null) {
            titleView.setText(title);
            view.findViewById(R.id.progress_divider).setVisibility(View.VISIBLE);
            titleView.setVisibility(View.VISIBLE);
        }
        if(message != null) {
            messageView.setText(message);
        }

        if(progressColor != 0) {
            progressBar.setTintColor(progressColor);
        }
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessage(@StringRes int stringId) {

        setMessage(getContext().getString(stringId));
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitle(@StringRes int stringId) {

        setTitle(getContext().getString(stringId));
    }


    public void setColorProgress(@ColorInt int color) {
        this.progressColor = color;
    }

    public void setTitleColor(@ColorInt int color) {
        this.titleColor = color;
    }
    public void setDividerColor(@ColorInt int color) {
        this.dividerColor = color;
    }
}
