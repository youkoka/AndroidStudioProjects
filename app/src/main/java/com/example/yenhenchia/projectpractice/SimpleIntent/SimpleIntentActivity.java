package com.example.yenhenchia.projectpractice.SimpleIntent;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.MainActivity;
import com.example.yenhenchia.projectpractice.R;

import java.io.File;
import java.util.ArrayList;

public class SimpleIntentActivity extends AppCompatActivity {

    private Button btnWeb, btnMp3, btnImage, btnSendData, btnReceiveData;
    private TextView txtReceive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_intent);

        this.btnWeb = (Button) findViewById(R.id.btnWeb);
        this.btnWeb.setOnClickListener(onWebClickListener);

        this.btnMp3 = (Button) findViewById(R.id.btnMp3);
        this.btnMp3.setOnClickListener(onMP3ClickListener);

        this.btnImage = (Button) findViewById(R.id.btnImg);
        this.btnImage.setOnClickListener(onImageClickListener);

        this.btnSendData = (Button) findViewById(R.id.btnSendData);
        this.btnSendData.setOnClickListener(onSendClickListener);

        this.btnReceiveData = (Button) findViewById(R.id.btnReceiveData);
        this.btnReceiveData.setOnClickListener(onReceiveClickListener);

        this.txtReceive = (TextView) findViewById(R.id.txtReceive);
    }

    private Button.OnClickListener onWebClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Uri uri = Uri.parse("http://www.google.com.tw");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private Button.OnClickListener onMP3ClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            String mp3File = Environment.getExternalStorageDirectory().getPath() +
                    File.separator + "Music" +
                    File.separator +"V6-Darling.mp3";

            File file = new File(mp3File);
            boolean isExist = file.exists();
            if (isExist) {

                intent.setDataAndType(Uri.fromFile(file), "audio/*");
                startActivity(intent);
            }
        }
    };

    private Button.OnClickListener onImageClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            String imgFile = Environment.getExternalStorageDirectory().getPath() +
                    File.separator + "DCIM" +
                    File.separator +"IMG_0346.jpg";
            File file = new File(imgFile);
            boolean isExist = file.exists();
            if (isExist) {

                intent.setDataAndType(Uri.fromFile(file), "image/*");
                startActivity(intent);
            }
        }
    };

    private Button.OnClickListener onSendClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(SimpleIntentActivity.this, SimpleIntentReceivedActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("Int", 10);
            bundle.putString("String", "test");
            bundle.putIntegerArrayList("IntAry", new ArrayList<Integer>(){{
                add(1);
                add(2);
                add(3);
            }});

            intent.putExtras(bundle);
            //! can not put list object
            intent.putExtra("StrAry", new ArrayList<String>(){{
                add("123");
                add("456");
                add("789");
            }});

            startActivity(intent);
        }
    };

    private Button.OnClickListener onReceiveClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent();
            intent.setClass(SimpleIntentActivity.this, SimpleIntentReceivedActivity.class);
            startActivityForResult(intent, SimpleIntentReceivedActivity.RECEIVE_STATE_START);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode != SimpleIntentReceivedActivity.RECEIVE_STATE_START) {

            return;
        }

        switch (resultCode) {

            case SimpleIntentReceivedActivity.RECEIVE_STATE_RECEIVE1: {

                String s = "RECEIVE_STATE_RECEIVE1 : ";

                if (data != null) {

                    Bundle bundle = data.getExtras();

                    if (bundle != null) {

                        String str = bundle.getString("String");

                        s += str;
                    }
                }

                txtReceive.setText(s);
            }
                break;
            case SimpleIntentReceivedActivity.RECEIVE_STATE_RECEIVE2: {

                String s = "RECEIVE_STATE_RECEIVE2 : ";

                if (data != null) {

                    String str = data.getStringExtra("String");
                    s += str;
                }

                txtReceive.setText(s);
            }
                break;
        }
    }
}
