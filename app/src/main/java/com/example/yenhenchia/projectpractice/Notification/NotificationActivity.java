package com.example.yenhenchia.projectpractice.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yenhenchia.projectpractice.R;
import com.example.yenhenchia.projectpractice.SimpleFragment.SimpleFragmentActivity;
import com.example.yenhenchia.projectpractice.SimpleFragment.SimpleMainFragment;

public class NotificationActivity extends AppCompatActivity {

    private Button btnNoti1, btnNoti2, btnNoti3;

    private int Noti_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btnNoti1 = (Button)findViewById(R.id.btnNoti1);
        btnNoti1.setTag("Notification 1");
        btnNoti1.setOnClickListener(onClickListener);

        btnNoti2 = (Button)findViewById(R.id.btnNoti2);
        btnNoti2.setTag("Notification 2");
        btnNoti2.setOnClickListener(onClickListener);

        btnNoti3 = (Button)findViewById(R.id.btnNoti3);
        btnNoti3.setTag("Notification 3");
        btnNoti3.setOnClickListener(onClickListener);
    }

    @Override
    protected void onDestroy() {

        ((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).cancel(Noti_ID);

        super.onDestroy();
    }

    private Button.OnClickListener onClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            String message = (String)v.getTag();

            showNotificaton(Noti_ID, message);
        }
    };

    private void showNotificaton(int notificationId, String msg) {

        Intent intent = new Intent(getApplicationContext(), SimpleFragmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Bundle bundle = new Bundle();
        bundle.putString("Message", msg);

        intent.putExtras(bundle);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification notification = new Notification.Builder(this)
                                    .setSmallIcon(android.R.drawable.btn_star_big_on)
                                    .setTicker(msg)
                                    .setContentTitle(getString(R.string.app_name))
                                    .setContentText(msg)
                                    .setContentIntent(pendingIntent).build();

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, notification);
    }
}
