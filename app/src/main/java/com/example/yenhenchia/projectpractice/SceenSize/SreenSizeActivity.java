package com.example.yenhenchia.projectpractice.SceenSize;

import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;

import com.example.yenhenchia.projectpractice.R;

public class SreenSizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sreen_size);

        ConstraintLayout constraintLayout = (ConstraintLayout)findViewById(R.id.constraintLayout);
        constraintLayout.post(new Runnable() {
            @Override
            public void run() {

                Rect r = new Rect();

                Window window = getWindow();
                window.getDecorView().getWindowVisibleDisplayFrame(r);

                int statusPlusAddActionBarHeight = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();

                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

                int appWindowHeight = displayMetrics.heightPixels - statusPlusAddActionBarHeight;
            }
        });
    }
}
