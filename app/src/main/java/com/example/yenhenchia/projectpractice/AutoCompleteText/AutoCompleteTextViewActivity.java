package com.example.yenhenchia.projectpractice.AutoCompleteText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.yenhenchia.projectpractice.R;

public class AutoCompleteTextViewActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private Button btnAutoCompAdd, btnAutoCompClear;

    private ArrayAdapter<String> mAdapterAutoCompText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);

        this.autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompTextView);
        this.mAdapterAutoCompText = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
        this.autoCompleteTextView.setAdapter(this.mAdapterAutoCompText);

        this.btnAutoCompAdd = (Button)findViewById(R.id.btnAutoCompAdd);
        this.btnAutoCompAdd.setOnClickListener(btnAddOnClickListener);

        this.btnAutoCompClear = (Button)findViewById(R.id.btnAutoCompClear);
        this.btnAutoCompClear.setOnClickListener(btnClearOnClickListener);
    }

    private Button.OnClickListener btnAddOnClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            String str = autoCompleteTextView.getText().toString();
            mAdapterAutoCompText.add(str);
            autoCompleteTextView.setText("");
        }
    };

    private Button.OnClickListener btnClearOnClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            mAdapterAutoCompText.clear();
        }
    };
}
