package com.example.yenhenchia.projectpractice.SimpleBroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yenhenchia.projectpractice.R;

public class SimpleBroadcastActivity extends AppCompatActivity {

    private Button btnReg, btnUnReg, btnSendReg1, btnSendReg2;

    MyBroadcastReceive2 myBroadcastReceive2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_broadcast);

        this.btnReg = (Button) findViewById(R.id.btnReg);
        this.btnReg.setOnClickListener(onReqClickListener);

        this.btnUnReg = (Button) findViewById(R.id.btnUnReg);
        this.btnUnReg.setOnClickListener(onUnreqClickListener);

        this.btnSendReg1 = (Button) findViewById(R.id.btnSendReg1);
        this.btnSendReg1.setOnClickListener(onSendReq1ClickListener);

        this.btnSendReg2 = (Button) findViewById(R.id.btnSendReg2);
        this.btnSendReg2.setOnClickListener(onSendReq2ClickListener);
    }

    private Button.OnClickListener onReqClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            IntentFilter intentFilter = new IntentFilter("com.android.MyBroadcastReceive2");
            myBroadcastReceive2 = new MyBroadcastReceive2();
            registerReceiver(myBroadcastReceive2, intentFilter);
        }
    };

    private Button.OnClickListener onUnreqClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            unregisterReceiver(myBroadcastReceive2);
        }
    };

    private Button.OnClickListener onSendReq1ClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent("com.android.MyBroadcastReceive1");
            intent.putExtra("string", "receive1");
            sendBroadcast(intent);
        }
    };

    private Button.OnClickListener onSendReq2ClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent("com.android.MyBroadcastReceive2");
            intent.putExtra("string", "receive2");
            sendBroadcast(intent);
        }
    };
}
