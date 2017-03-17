package com.example.yenhenchia.projectpractice.Drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yenhenchia.projectpractice.R;

public class DrawableActivity extends AppCompatActivity {

    Button btnDrawable;
    ImageView imgView1, imgView2, imgView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);

        btnDrawable = (Button)findViewById(R.id.btnDrawable);
        btnDrawable.setOnClickListener(onDrawableClickListener);

        imgView1 = (ImageView)findViewById(R.id.imgView1);
        imgView2 = (ImageView)findViewById(R.id.imgView2);
        imgView3 = (ImageView)findViewById(R.id.imgView3);
    }

    private Button.OnClickListener onDrawableClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Drawable drawImg = ContextCompat.getDrawable(DrawableActivity.this, R.drawable.dice_6);
            imgView1.setImageDrawable(drawImg);

            TransitionDrawable transitionDrawable = (TransitionDrawable)ContextCompat.getDrawable(DrawableActivity.this, R.drawable.trans_drawable);
            imgView2.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(5000);

            GradientDrawable gradientDrawable = (GradientDrawable)ContextCompat.getDrawable(DrawableActivity.this, R.drawable.shape_drawable);
            gradientDrawable.setColor(0xffff0000);
            imgView3.setImageDrawable(gradientDrawable);
//            GradientDrawable gradientDrawable = new GradientDrawable();
//            gradientDrawable.setShape(GradientDrawable.OVAL);
//            gradientDrawable.setColor(0xffff0000);
//            imgView3.setImageDrawable(gradientDrawable);
        }
    };
}
