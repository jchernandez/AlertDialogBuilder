package com.rojoxpress.alertexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.rojoxpress.alertdialogbuilder.AlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {
        AlertDialogBuilder builder = new AlertDialogBuilder(this);
        builder.setPositiveButton("accented button",null);
        builder.show();
    }
}
