package com.example.yenhenchia.projectpractice.CustomDialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

public class CustomDialogActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextView txtResult;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        this.btnLogin = (Button)findViewById(R.id.btnLogin);
        this.btnLogin.setOnClickListener(onLoginClickListener);

        this.txtResult = (TextView)findViewById(R.id.txtLoginResult);
    }

    private Button.OnClickListener onLoginClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            txtResult.setText("");

            dialog = new Dialog(CustomDialogActivity.this);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.custom_dialog_view);

            Button btnSubmit = (Button) dialog.findViewById(R.id.btnSubmit);
            btnSubmit.setOnClickListener(onSubmitClickListener);

            Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
            btnCancel.setOnClickListener(onCancelClickListener);

            dialog.show();
        }
    };

    private Button.OnClickListener onSubmitClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            EditText edtUserName = (EditText) dialog.findViewById(R.id.edtUserName);
            EditText edtPassword = (EditText) dialog.findViewById(R.id.edtPassword);

            String str = "";

            if (edtUserName != null && edtUserName.length() > 0) {

                str += edtUserName.getText();
            }

            str += "/";

            if (edtPassword != null && edtPassword.length() > 0) {

                str += edtPassword.getText();
            }

            txtResult.setText(str);

            dialog.cancel();
        }
    };

    private Button.OnClickListener onCancelClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            if (dialog != null) {

                dialog.dismiss();
            }
        }
    };
}
