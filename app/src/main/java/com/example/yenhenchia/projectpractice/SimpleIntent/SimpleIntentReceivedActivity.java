package com.example.yenhenchia.projectpractice.SimpleIntent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

import java.util.ArrayList;

public class SimpleIntentReceivedActivity extends AppCompatActivity {

    private TextView txtIntentResult;

    public final static int RECEIVE_STATE_START  = 0;
    public final static int RECEIVE_STATE_RECEIVE1  = 1;
    public final static int RECEIVE_STATE_RECEIVE2  = 2;

    private Button btnReceive1, btnReceive2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_intent_received);

        this.btnReceive1 = (Button) findViewById(R.id.bntReceiveResult1);
        this.btnReceive1.setOnClickListener(onReceive1ClickListener);

        this.btnReceive2 = (Button) findViewById(R.id.bntReceiveResult2);
        this.btnReceive2.setOnClickListener(onReceive2ClickListener);

        this.txtIntentResult = (TextView) findViewById(R.id.txtIntentResult);
        showResult();
    }

    private void showResult() {

        Intent intent = getIntent();
        String act = intent.getAction();
        String scheme = intent.getScheme();

        Bundle bundle = intent.getExtras();

        if (bundle != null && !bundle.isEmpty()) {

            int value = bundle.getInt("Int");
            String s = bundle.getString("String");

            ArrayList intArrayList = bundle.getIntegerArrayList("IntAry");

            ArrayList strArrayList = intent.getStringArrayListExtra("StrAry");

            String emptyStr = intent.getStringExtra("null");

            String str = "You receive a request of intent and data is : " + value + s + emptyStr;

            if (intArrayList != null) {

                str += intArrayList.toString();
            }

            if (strArrayList != null) {

                str += strArrayList.toString();
            }

            this.txtIntentResult.setText(str);
        }
        else if (scheme != null && scheme.equals("http")) {

            if (intent.getData() != null) {

                String str = "You receive a request of intent to show web view, data is : " + intent.getData().toString();

                this.txtIntentResult.setText(str);
            }
        }
        else if(scheme != null && scheme.equals("tel")) {

            if (intent.getData() != null) {

                String str = "You receive a request of intent to call phone, data is : " + intent.getData().toString();

                this.txtIntentResult.setText(str);
            }
        }
        else if(scheme != null && scheme.equals("file")) {

            if (act.equals("android.intent.action.VIEW")) {

                if (intent.getData() != null) {

                    String str = "You receive a request of intent to show view, data is : " + intent.getData().toString();

                    this.txtIntentResult.setText(str);
                }
            }
            else if(act.equals("android.intent.action.EDIT")) {

                if (intent.getData() != null) {

                    String str = "You receive a request of intent to edit view, data is : " + intent.getData().toString();

                    this.txtIntentResult.setText(str);
                }
            }
        }
    }

    private Button.OnClickListener onReceive1ClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent();

            Bundle bundle = new Bundle();
            bundle.putString("String", "result1");

            intent.putExtras(bundle);

            setResult(RECEIVE_STATE_RECEIVE1, intent);
            finish();
        }
    };

    private Button.OnClickListener onReceive2ClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent();
            intent.putExtra("String", "result2");

            setResult(RECEIVE_STATE_RECEIVE2, intent);
            finish();
        }
    };
}
