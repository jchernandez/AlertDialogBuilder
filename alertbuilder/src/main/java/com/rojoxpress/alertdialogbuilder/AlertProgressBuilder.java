package com.rojoxpress.alertdialogbuilder;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.ColorInt;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rojoxpress.TintedProgressBar;

public class AlertProgressBuilder extends ProgressDialog {

    private View view;
    private String message;
    private String title;
    private int progressColor = 0;

    public AlertProgressBuilder(Context context) {
        super(context);
        initProgress();
    }

    public AlertProgressBuilder(Context context, int theme) {
        super(context, theme);
        initProgress();
    }

    private void initProgress() {
        setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                view = View.inflate(getContext(),R.layout.view_progress_dialog,null);
                setContentView(view);
                TextView messageView = (TextView) view.findViewById(R.id.progress_message);
                TextView titleView = (TextView) view.findViewById(R.id.progress_title);
                TintedProgressBar progressBar = (TintedProgressBar) view.findViewById(R.id.progressbar);

                int accentColor = AdUtils.resolveColor(getContext(),AdUtils.getAccentColorAttr(),AdUtils.defColor);

                titleView.setTextColor(accentColor);
                view.findViewById(R.id.progress_divider).setBackgroundColor(accentColor);

                if(title != null) {
                    titleView.setText(title);
                    view.findViewById(R.id.progress_divider).setVisibility(View.VISIBLE);
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
        });
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessage(@StringRes int stringId) {

        setMessage(getContext().getString(stringId));
    }

    public void setTitle(String title) {
        this.title = message;
    }

    public void setTitle(@StringRes int stringId) {

        setTitle(getContext().getString(stringId));
    }


    public void setColorProgress(@ColorInt int color) {
        this.progressColor = color;
    }
}
