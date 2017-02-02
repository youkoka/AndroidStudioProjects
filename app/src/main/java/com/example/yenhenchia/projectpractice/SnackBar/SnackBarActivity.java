package com.example.yenhenchia.projectpractice.SnackBar;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yenhenchia.projectpractice.R;

public class SnackBarActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);

        this.fab = (FloatingActionButton)findViewById(R.id.fab);
        this.fab.setOnClickListener(onClickListener);
    }

    FloatingActionButton.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Snackbar.make(v, "pressed bottom button", Snackbar.LENGTH_INDEFINITE).show();
        }
    };
}
