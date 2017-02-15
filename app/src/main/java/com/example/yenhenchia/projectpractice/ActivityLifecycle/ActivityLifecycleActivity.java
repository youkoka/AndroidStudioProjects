package com.example.yenhenchia.projectpractice.ActivityLifecycle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yenhenchia.projectpractice.R;

public class ActivityLifecycleActivity extends AppCompatActivity {

    private static final String TAG_LOG = "Activity Lifecycle!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG_LOG, "onCreate!");

        setContentView(R.layout.activity_lifecycle);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG_LOG, "onStart!");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Log.d(TAG_LOG, "onPostCreate!");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG_LOG, "onResume!");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Log.d(TAG_LOG, "onPostResume!");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG_LOG, "onPause!");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG_LOG, "onStop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG_LOG, "onDestroy!");
    }
}
