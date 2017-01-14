package com.example.yenhenchia.projectpractice.NumberPicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

public class NumberPickerActivity extends AppCompatActivity {

    private Spinner spnSex;
    private TextView txtAge, txtSug;
    private NumberPicker numberPickerAge;
    private Button btnCheck;
    private String mSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);

        setTitle("NumberPicker");

        spnSex = (Spinner)findViewById(R.id.spnSex);
        txtAge = (TextView)findViewById(R.id.txtAge);
        txtAge.setText("26");

        txtSug = (TextView)findViewById(R.id.txtSug);
        numberPickerAge = (NumberPicker)findViewById(R.id.numPickerAge);
        numberPickerAge.setMinValue(0);
        numberPickerAge.setMaxValue(99);
        numberPickerAge.setValue(26);

        btnCheck = (Button)findViewById(R.id.btnCheck);

        spnSex.setOnItemSelectedListener(onItemSelectedListener);
        btnCheck.setOnClickListener(onClickListener);
        numberPickerAge.setOnValueChangedListener(onValueChangeListener);
    }

    private Spinner.OnItemSelectedListener onItemSelectedListener = new Spinner.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View v, int i, long l) {

            mSex = adapterView.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private AdapterView.OnClickListener onClickListener = new AdapterView.OnClickListener() {

        @Override
        public void onClick(View v) {

            String suggest = getString(R.string.suggest);

            suggest += (mSex + txtAge.getText().toString());

            txtSug.setText(suggest);
        }
    };

    private NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int i, int i1) {

            txtAge.setText(String.valueOf(numberPicker.getValue()));
        }
    };
}
