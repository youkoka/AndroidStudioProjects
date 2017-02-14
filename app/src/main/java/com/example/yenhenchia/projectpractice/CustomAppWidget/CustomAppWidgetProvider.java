package com.example.yenhenchia.projectpractice.CustomAppWidget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.RemoteViews;

import com.example.yenhenchia.projectpractice.R;

/**
 * Created by yenhenchia on 2017/2/13.
 */

public class CustomAppWidgetProvider extends AppWidgetProvider {

    private static final String TAG_LOG = "CustomAPPWidgetProvider";

    private static AlarmManager mAlarmManager;
    private static PendingIntent mPendingIntent;

    static void SaveAlarmManager(AlarmManager alarmManager, PendingIntent pendingIntent) {

        mAlarmManager = alarmManager;
        mPendingIntent = pendingIntent;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (!intent.getAction().equals("com.android.MY_OWN_WIDGET_UPDATE")) {

            return;
        }

        Log.d(TAG_LOG, "onReceive!");

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

        ComponentName thisAppWidget = new ComponentName(context.getPackageName(), CustomAppWidgetProvider.class.getName());

        int appWidgetIds[] = appWidgetManager.getAppWidgetIds(thisAppWidget);

        onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        Log.d(TAG_LOG, "onUpdate!");

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.custom_app_widget_layout);
        remoteViews.setTextViewText(R.id.txvCustomAppWidget, "This is update CustomAppWidget");
        ComponentName componentName = new ComponentName(context, CustomAppWidgetProvider.class);
        appWidgetManager.updateAppWidget(componentName, remoteViews);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);

        Log.d(TAG_LOG, "onDeleted!");

        mAlarmManager.cancel(mPendingIntent);
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);

        Log.d(TAG_LOG, "onEnabled!");
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
