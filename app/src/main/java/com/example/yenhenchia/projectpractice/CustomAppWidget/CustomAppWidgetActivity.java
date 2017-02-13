package com.example.yenhenchia.projectpractice.CustomAppWidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yenhenchia.projectpractice.R;

public class CustomAppWidgetActivity extends AppCompatActivity {

    int mAppWidgetId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_app_widget);

        Intent itIn = getIntent();
        Bundle bundle = itIn.getExtras();

        if (bundle != null) {

            mAppWidgetId = bundle.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {

            finish();
        }

        Intent inOut = new Intent("com.android.MY_OWN_WIDGET_UPDATE");

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, inOut, 0);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 5);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 20 * 1000, pendingIntent);

        CustomAppWidgetProvider.SaveAlarmManager(alarmManager, pendingIntent);

        Intent itAppWidgetConfigResult = new Intent();

        itAppWidgetConfigResult.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);

        setResult(RESULT_OK, itAppWidgetConfigResult);

        finish();
    }
}
