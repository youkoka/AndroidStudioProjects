package com.example.yenhenchia.projectpractice.SimpleIntent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

public class SimpleIntentReceivedActivity extends AppCompatActivity {

    private TextView txtIntentResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_intent_received);

        this.txtIntentResult = (TextView) findViewById(R.id.txtIntentResult);
        showResult();
    }

    private void showResult() {

        Intent intent = getIntent();
        String act = intent.getAction();
        String scheme = intent.getScheme();

        if (scheme.equals("http")) {

            String str = "You receive a request of intent to show web view, data is : " + intent.getData().toString();

            this.txtIntentResult.setText(str);
        }
        else if(scheme.equals("tel")) {

            String str = "You receive a request of intent to call phone, data is : " + intent.getData().toString();

            this.txtIntentResult.setText(str);
        }
        else if(scheme.equals("file")) {

            if (act.equals("android.intent.action.VIEW")) {

                String str = "You receive a request of intent to show view, data is : " + intent.getData().toString();

                this.txtIntentResult.setText(str);
            }
            else if(act.equals("android.intent.action.EDIT")) {

                String str = "You receive a request of intent to edit view, data is : " + intent.getData().toString();

                this.txtIntentResult.setText(str);
            }
        }
    }
}
