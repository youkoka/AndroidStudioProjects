package com.example.yenhenchia.projectpractice.SimpleCanvas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yenhenchia.projectpractice.R;

public class SimpleCanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_simple_canvas);
        setContentView(new SimpleCanvasView(this));
    }
}
