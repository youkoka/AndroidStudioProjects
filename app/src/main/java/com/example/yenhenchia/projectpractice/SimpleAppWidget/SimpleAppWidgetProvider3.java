package com.example.yenhenchia.projectpractice.SimpleAppWidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import com.example.yenhenchia.projectpractice.R;

/**
 * Created by yenhenchia on 2017/2/15.
 */

public class SimpleAppWidgetProvider3 extends AppWidgetProvider {

    private static final String TAG_LOG = "SimpleAppWidget3";

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (!intent.getAction().equals("com.android.SIMPLE_APP_WIDGET_3")) {

            return;
        }

        Log.d(TAG_LOG, "onReceive!");

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ComponentName componentName = new ComponentName(context, SimpleAppWidgetProvider3.class.getName());
        int appWidgetIds[] = appWidgetManager.getAppWidgetIds(componentName);

        onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        Log.d(TAG_LOG, "onUpdate!");
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);

        Log.d(TAG_LOG, "onDeleted!");
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);

        Log.d(TAG_LOG, "onEnabled!");

        Intent intent = new Intent("com.android.SIMPLE_APP_WIDGET_3");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.activity_simple_app_widget_3);
        remoteViews.setOnClickPendingIntent(R.id.btnAppWidget, pendingIntent);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ComponentName componentName = new ComponentName(context, SimpleAppWidgetProvider3.class.getName());
        appWidgetManager.updateAppWidget(componentName, remoteViews);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);

        Log.d(TAG_LOG, "onDisabled!");
    }

    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        super.onRestored(context, oldWidgetIds, newWidgetIds);

        Log.d(TAG_LOG, "onRestored!");
    }
}
