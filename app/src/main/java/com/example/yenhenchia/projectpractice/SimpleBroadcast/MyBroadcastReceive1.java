package com.example.yenhenchia.projectpractice.SimpleBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by yenhenchia on 2017/2/9.
 */

public class MyBroadcastReceive1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String receive = intent.getStringExtra("string");

        Toast.makeText(context, "receive broadcast : " + receive, Toast.LENGTH_LONG).show();
    }
}
