package com.example.yenhenchia.projectpractice.ScrollViewAndCheckBox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

public class ScrollViewAndCheckBoxActivity extends AppCompatActivity {

    private CheckBox chkBox1, chkBox2, chkBox3, chkBox4, chkBox5, chkBox6, chkBox7,
            chkBox8, chkBox9, chkBox10, chkBox11, chkBox12, chkBox13, chkBox14, chkBox15, chkBox16,
            chkBox17, chkBox18, chkBox19, chkBox20;

    private Button btnCheck;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_and_check_box);

        chkBox1 = (CheckBox)findViewById(R.id.chkBox1);
        chkBox2 = (CheckBox)findViewById(R.id.chkBox2);
        chkBox3 = (CheckBox)findViewById(R.id.chkBox3);
        chkBox4 = (CheckBox)findViewById(R.id.chkBox4);
        chkBox5 = (CheckBox)findViewById(R.id.chkBox5);
        chkBox6 = (CheckBox)findViewById(R.id.chkBox6);
        chkBox7 = (CheckBox)findViewById(R.id.chkBox7);
        chkBox8 = (CheckBox)findViewById(R.id.chkBox8);
        chkBox9 = (CheckBox)findViewById(R.id.chkBox9);
        chkBox10 = (CheckBox)findViewById(R.id.chkBox10);
        chkBox11 = (CheckBox)findViewById(R.id.chkBox11);
        chkBox12 = (CheckBox)findViewById(R.id.chkBox12);
        chkBox13 = (CheckBox)findViewById(R.id.chkBox13);
        chkBox14 = (CheckBox)findViewById(R.id.chkBox14);
        chkBox15 = (CheckBox)findViewById(R.id.chkBox15);
        chkBox16 = (CheckBox)findViewById(R.id.chkBox16);
        chkBox17 = (CheckBox)findViewById(R.id.chkBox17);
        chkBox18 = (CheckBox)findViewById(R.id.chkBox18);
        chkBox19 = (CheckBox)findViewById(R.id.chkBox19);
        chkBox20 = (CheckBox)findViewById(R.id.chkBox20);

        btnCheck = (Button)findViewById(R.id.btnCheck);
        txtResult = (TextView)findViewById(R.id.txtResult);

        btnCheck.setOnClickListener(onClickListener);
    }

    private Button.OnClickListener onClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            String result = getString(R.string.result);

            if (chkBox1.isChecked()) {

                result += "1,";
            }
            if (chkBox2.isChecked()) {

                result += "2,";
            }
            if (chkBox3.isChecked()) {

                result += "3,";
            }
            if (chkBox4.isChecked()) {

                result += "4,";
            }
            if (chkBox5.isChecked()) {

                result += "5,";
            }
            if (chkBox6.isChecked()) {

                result += "6,";
            }
            if (chkBox7.isChecked()) {

                result += "7,";
            }
            if (chkBox8.isChecked()) {

                result += "8,";
            }
            if (chkBox9.isChecked()) {

                result += "9,";
            }
            if (chkBox10.isChecked()) {

                result += "10,";
            }
            if (chkBox11.isChecked()) {

                result += "11,";
            }
            if (chkBox12.isChecked()) {

                result += "12,";
            }
            if (chkBox13.isChecked()) {

                result += "13,";
            }
            if (chkBox14.isChecked()) {

                result += "14,";
            }
            if (chkBox15.isChecked()) {

                result += "15,";
            }
            if (chkBox16.isChecked()) {

                result += "16,";
            }
            if (chkBox17.isChecked()) {

                result += "17,";
            }
            if (chkBox18.isChecked()) {

                result += "18,";
            }
            if (chkBox19.isChecked()) {

                result += "19,";
            }
            if (chkBox20.isChecked()) {

                result += "20";
            }

            txtResult.setText(result);
        }
    };
}
