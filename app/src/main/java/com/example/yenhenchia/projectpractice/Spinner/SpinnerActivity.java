package com.example.yenhenchia.projectpractice.Spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner spnSex;
    private EditText edtAge;
    private Button btnCheck;
    private TextView txtSug;
    private String mSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spnSex = (Spinner)findViewById(R.id.spnSex);
        edtAge = (EditText)findViewById(R.id.edtAge);
        btnCheck = (Button)findViewById(R.id.btnCheck);
        txtSug = (TextView)findViewById(R.id.txtSug);

        spnSex.setOnItemSelectedListener(onItemSelectedListener);
        btnCheck.setOnClickListener(onClickListener);
    }

    private AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

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
            suggest += (mSex + edtAge.getText().toString());

            txtSug.setText(suggest);
        }
    };
}
