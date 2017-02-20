package com.rojoxpress.alertexample;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

import com.rojoxpress.alertdialogbuilder.AlertDialogBuilder;
import com.rojoxpress.alertdialogbuilder.TintedProgressDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {

        switch (view.getId()) {
            case R.id.progress_horizontal: {
                final TintedProgressDialog progress = new TintedProgressDialog(this);
                progress.setProgressStyle(TintedProgressDialog.STYLE_HORIZONTAL);
                progress.setMessage("Horizontal progress");
                progress.setColorProgress(Color.LTGRAY);
                progress.setTitle("title");
                progress.show();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(progress.getProgress() < 100) {
                            progress.setProgress(progress.getProgress() +1);
                            handler.postDelayed(this, 500);
                        } else {
                            progress.dismiss();
                        }
                    }
                }, 500);
            }break;


            case R.id.progress_button: {
                TintedProgressDialog builder = new TintedProgressDialog(this);
                builder.setMessage("message");
                builder.setTitle("title");
                builder.setColorProgress(ContextCompat.getColor(this,R.color.colorPrimaryDark));
                builder.setTitleColor(ContextCompat.getColor(this, R.color.colorAccent));
                builder.show();
            }break;

            case R.id.array_button:{
                AlertDialogBuilder builder = new AlertDialogBuilder(this);
                builder.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.days)),null);
                builder.show();

            }break;

            case R.id.show_button: {
                AlertDialogBuilder.showAlert(this, "Title", "Message", "Positive", "Negative","Neutral", null);
            }break;

            default:{
                AlertDialogBuilder builder = new AlertDialogBuilder(this);
                builder.setMessage("Alert custom buttons example");
                builder.setPositiveButton("Positive", null);
                builder.setNegativeButton("Negative", null);
                builder.setNeutralButton("Neutral", null);

                if (view.getId() != R.id.themed_button) {
                    builder.setPositiveColor(ContextCompat.getColor(this, R.color.colorAccent));
                    builder.setNegativeColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
                    builder.setNeutralColor(Color.BLACK);
                }
                builder.show();
            }
        }
    }
}
