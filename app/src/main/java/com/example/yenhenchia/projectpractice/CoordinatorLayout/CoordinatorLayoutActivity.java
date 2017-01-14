package com.example.yenhenchia.projectpractice.CoordinatorLayout;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.yenhenchia.projectpractice.R;

public class CoordinatorLayoutActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);

        fabAdd = (FloatingActionButton)findViewById(R.id.fabAdd);

        fabAdd.setOnClickListener(onClickListener);
    }

    private FloatingActionButton.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Toast.makeText(view.getContext(), "click", Toast.LENGTH_SHORT).show();
        }
    };
}
