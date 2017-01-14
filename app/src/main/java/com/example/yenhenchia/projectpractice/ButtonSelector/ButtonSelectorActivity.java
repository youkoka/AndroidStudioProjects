package com.example.yenhenchia.projectpractice.ButtonSelector;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.yenhenchia.projectpractice.R;

public class ButtonSelectorActivity extends AppCompatActivity {

    private Button btnSelector1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_selector);

        this.btnSelector1 = (Button)findViewById(R.id.btnSelector1);

        if(Build.VERSION.SDK_INT >= 21) {

            this.btnSelector1.setBackgroundResource(R.drawable.ripple);
        }
        else {

            this.btnSelector1.setBackgroundResource(R.drawable.buttonselector);
        }
    }
}
