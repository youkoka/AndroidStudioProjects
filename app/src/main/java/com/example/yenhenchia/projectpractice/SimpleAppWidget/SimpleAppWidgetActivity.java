package com.example.yenhenchia.projectpractice.SimpleAppWidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yenhenchia.projectpractice.R;

public class SimpleAppWidgetActivity extends AppWidgetProvider {

    private static final String LOG_TAG = "SimpleAppWidget";

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        Log.d(LOG_TAG, "onReceive!");
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        Log.d(LOG_TAG, "onUpdate!");
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);

        Log.d(LOG_TAG, "onDelete!");
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);

        Log.d(LOG_TAG, "onEnabled!");
    }

    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        super.onRestored(context, oldWidgetIds, newWidgetIds);

        Log.d(LOG_TAG, "onRestored!");
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);

        Log.d(LOG_TAG, "onDisabled!");
    }
}
