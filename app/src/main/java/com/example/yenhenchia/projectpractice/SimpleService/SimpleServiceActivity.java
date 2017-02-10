package com.example.yenhenchia.projectpractice.SimpleService;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.yenhenchia.projectpractice.R;

public class SimpleServiceActivity extends AppCompatActivity {

    private Button btnStartService, btnStopService, btnLinkService, btnDislinkService, btnCallServiceMethod;

    MyService myService = null;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            Log.d("ServiceDemo", "onServiceConnected() " + name.getClassName());

            myService = ((MyService.LocalBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            Log.d("ServiceDemo", "onServiceDisconnected" + name.getClassName());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_service);

        this.btnStartService = (Button) findViewById(R.id.btnStartService);
        this.btnStartService.setOnClickListener(onStartClickListener);

        this.btnStopService = (Button) findViewById(R.id.btnStopService);
        this.btnStopService.setOnClickListener(onStopClickListener);

        this.btnLinkService = (Button) findViewById(R.id.btnLinkService);
        this.btnLinkService.setOnClickListener(onLinkClickListener);

        this.btnDislinkService = (Button) findViewById(R.id.btnDislinkService);
        this.btnDislinkService.setOnClickListener(onDislinkClickListener);

        this.btnCallServiceMethod = (Button) findViewById(R.id.btnCallServiceMethod);
        this.btnCallServiceMethod.setOnClickListener(onCallMethodClickListener);
    }

    private Button.OnClickListener onStartClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            myService = null;

            Intent intent = new Intent(SimpleServiceActivity.this, MyService.class);
            startService(intent);
        }
    };

    private Button.OnClickListener onStopClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            myService = null;

            Intent intent = new Intent(SimpleServiceActivity.this, MyService.class);
            stopService(intent);
        }
    };

    private Button.OnClickListener onLinkClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            myService = null;

            Intent intent = new Intent(SimpleServiceActivity.this, MyService.class);
            bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        }
    };

    private Button.OnClickListener onDislinkClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            myService = null;

            unbindService(serviceConnection);

//            getApplicationContext().unbindService(serviceConnection);
        }
    };

    private Button.OnClickListener onCallMethodClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            if (myService != null) {

                myService.myMethod();
            }
        }
    };
}
