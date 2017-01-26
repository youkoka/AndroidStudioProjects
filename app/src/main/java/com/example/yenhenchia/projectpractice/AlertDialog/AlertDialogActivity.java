package com.example.yenhenchia.projectpractice.AlertDialog;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.yenhenchia.projectpractice.R;

public class AlertDialogActivity extends AppCompatActivity {

    private Button btnAlertDialog, btnAlertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        this.btnAlertDialog = (Button)findViewById(R.id.btnAlertDialog);
        this.btnAlertDialog.setOnClickListener(onAlertDialogClickListener);

        this.btnAlertDialogBuilder = (Button)findViewById(R.id.btnAlertDialogBuilder);
        this.btnAlertDialogBuilder.setOnClickListener(onAlertDialogBuilderClickListener);
    }

    private Button.OnClickListener onAlertDialogClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            MyAlertDialog myAlertDialog = new MyAlertDialog(AlertDialogActivity.this);
            myAlertDialog.setTitle("AlertDialog");
            myAlertDialog.setMessage("AlertDialog sample");
            myAlertDialog.setIcon(android.R.drawable.ic_dialog_alert);
            myAlertDialog.setCancelable(false);

            myAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(AlertDialogActivity.this, "AlertDialog_Yes", Toast.LENGTH_SHORT).show();
                }
            });

            myAlertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(AlertDialogActivity.this, "AlertDialog_No", Toast.LENGTH_SHORT).show();
                }
            });

            myAlertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(AlertDialogActivity.this, "AlertDialog_Cancel", Toast.LENGTH_SHORT).show();
                }
            });

            myAlertDialog.show();
        }
    };

    private Button.OnClickListener onAlertDialogBuilderClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AlertDialogActivity.this);
            alertDialogBuilder.setTitle("AlertDialogBuilder");
            alertDialogBuilder.setMessage("AlertDialogBuilder sample");
            alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_alert);
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(AlertDialogActivity.this, "AlertDialogBuilder_Yes", Toast.LENGTH_SHORT).show();
                }
            });

            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(AlertDialogActivity.this, "AlertDialogBuilder_No", Toast.LENGTH_SHORT).show();
                }
            });

            alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(AlertDialogActivity.this, "AlertDialogBuilder_Cancel", Toast.LENGTH_SHORT).show();
                }
            });

            alertDialogBuilder.show();
        }
    };
}
