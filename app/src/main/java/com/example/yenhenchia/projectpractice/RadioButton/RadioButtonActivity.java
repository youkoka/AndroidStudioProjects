package com.example.yenhenchia.projectpractice.RadioButton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

public class RadioButtonActivity extends AppCompatActivity {

    private RadioGroup radioGroupAge, radioGroupSex;
    private RadioButton radioButtonRange1, radioButtonRange2, radioButtonRange3;
    private Button bthCheck;
    private TextView txtSug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        radioGroupSex = (RadioGroup)findViewById(R.id.radioGroupSex);
        radioGroupAge = (RadioGroup)findViewById(R.id.radioGroupAge);

        radioButtonRange1 = (RadioButton)findViewById(R.id.radioBtnRange1);
        radioButtonRange2 = (RadioButton)findViewById(R.id.radioBtnRange2);
        radioButtonRange3 = (RadioButton)findViewById(R.id.radioBtnRange3);

        bthCheck = (Button)findViewById(R.id.btnCheck);

        txtSug = (TextView)findViewById(R.id.txtSug);

        bthCheck.setOnClickListener(onClickListener);
        radioGroupSex.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    private AdapterView.OnClickListener onClickListener = new AdapterView.OnClickListener() {

        @Override
        public void onClick(View v) {

            String suggest = getString(R.string.suggest);

            switch (radioGroupSex.getCheckedRadioButtonId()) {

                case R.id.radioBtnMale: {

                    suggest += getString(R.string.sexMale);
                }
                    break;
                case R.id.radioBtnFemale: {

                    suggest += getString(R.string.sexFemale);
                }
                    break;
            }

            switch (radioGroupAge.getCheckedRadioButtonId()) {

                case R.id.radioBtnRange1: {

                    suggest += radioButtonRange1.getText();
                }
                    break;
                case R.id.radioBtnRange2: {

                    suggest += radioButtonRange2.getText();
                }
                    break;
                case R.id.radioBtnRange3: {

                    suggest += radioButtonRange3.getText();
                }
                    break;
            }

            txtSug.setText(suggest);
        }
    };

    private RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {

            if (i == R.id.radioBtnMale) {

                radioButtonRange1.setText(getString(R.string.male_age_range1));
                radioButtonRange2.setText(getString(R.string.male_age_range2));
                radioButtonRange3.setText(getString(R.string.male_age_range3));
            }
            else {

                radioButtonRange1.setText(getString(R.string.female_age_range1));
                radioButtonRange2.setText(getString(R.string.female_age_range2));
                radioButtonRange3.setText(getString(R.string.female_age_range3));
            }
        }
    };
}
