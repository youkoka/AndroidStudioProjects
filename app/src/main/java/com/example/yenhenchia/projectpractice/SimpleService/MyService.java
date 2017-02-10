package com.example.yenhenchia.projectpractice.SimpleService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String LOG_TAG = "ServiceDemo";

    public class LocalBinder extends Binder {

        MyService getService() {

            return MyService.this;
        }
    }

    private LocalBinder localBinder = new LocalBinder();

    public MyService() {
    }

    public void myMethod() {

        Log.d(LOG_TAG, "myMethod()");
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        Log.d(LOG_TAG, "onBind!");

        return localBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(LOG_TAG, "onCreate!");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(LOG_TAG, "onStartCommand!");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(LOG_TAG, "onDestroy!");
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Log.d(LOG_TAG, "onUnbind!");

        return super.onUnbind(intent);
    }
}
