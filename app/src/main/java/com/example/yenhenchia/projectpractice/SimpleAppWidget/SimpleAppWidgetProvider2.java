package com.example.yenhenchia.projectpractice.SimpleAppWidget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import android.util.Log;

/**
 * Created by yenhenchia on 2017/2/15.
 */

public class SimpleAppWidgetProvider2 extends AppWidgetProvider {

    private static final String TAG_LOG = "SimpleAppWidget2";

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (!intent.getAction().equals("com.android.SIMPLE_APP_WIDGET_2")) {

            return;
        }

        Log.d(TAG_LOG, "onReceive!");

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

        ComponentName componentName = new ComponentName(context, SimpleAppWidgetProvider2.class.getName());

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

        Log.d(TAG_LOG, "onRestored!");

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 10);
        setAlarm(context, calendar);
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

    private void setAlarm(Context context, Calendar calendar) {

        Log.d(TAG_LOG, "setAlarm!");

        Intent intent = new Intent("com.android.SIMPLE_APP_WIDGET_2");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
}
