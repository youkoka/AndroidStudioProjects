package com.example.yenhenchia.projectpractice.SurfaceView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yenhenchia.projectpractice.R;

public class SurfaceViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_surface_view);

        setContentView(new SimpleSurfaceView(this));
    }
}
