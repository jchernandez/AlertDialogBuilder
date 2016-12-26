package com.rojoxpress.alertexample;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rojoxpress.alertdialogbuilder.AlertDialogBuilder;
import com.rojoxpress.alertdialogbuilder.AlertProgressBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {

        if(view.getId() == R.id.progress_button) {
            AlertProgressBuilder builder = new AlertProgressBuilder(this);
            builder.setMessage("message");
            builder.setTitle("title");
            builder.setColorProgress(ContextCompat.getColor(this,R.color.colorPrimaryDark));
            builder.setTitleColor(ContextCompat.getColor(this, R.color.colorAccent));
            builder.setDividerColor(Color.GREEN);
            builder.show();
//            AlertProgressBuilder progressBuilder = AlertProgressBuilder.show(this,null, "message", true, false);
        } else {

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
