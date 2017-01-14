package com.example.yenhenchia.projectpractice.ViewAnimation;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import com.example.yenhenchia.projectpractice.GridView.ImageAdapter;
import com.example.yenhenchia.projectpractice.MainActivity;
import com.example.yenhenchia.projectpractice.R;

public class ViewAnimationActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory{

    private GridView gridView;
    private ImageSwitcher imageSwitcher;
    private Integer imgAry[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

        this.imgAry = new Integer[]{
                R.mipmap.icon_cloth, R.mipmap.icon_hammer, R.mipmap.icon_scissors,
                R.mipmap.icon_cloth, R.mipmap.icon_hammer, R.mipmap.icon_scissors,
                R.mipmap.icon_cloth, R.mipmap.icon_hammer, R.mipmap.icon_scissors,
                R.mipmap.icon_cloth, R.mipmap.icon_hammer, R.mipmap.icon_scissors,
                R.mipmap.icon_cloth, R.mipmap.icon_hammer, R.mipmap.icon_scissors,
                R.mipmap.icon_cloth, R.mipmap.icon_hammer, R.mipmap.icon_scissors,
                R.mipmap.icon_cloth, R.mipmap.icon_hammer, R.mipmap.icon_scissors };

        gridView = (GridView)findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this, imgAry);
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener(onItemClickListener);

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(this);
    }

    @Override
    public View makeView() {

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundColor(Color.WHITE);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        return imageView;
    }

    private GridView.OnItemClickListener onItemClickListener = new GridView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            int iRand = (int)(Math.random()*3 + 1);

            Log.d("viewAnimation", String.valueOf(iRand));

            switch (iRand) {

                case 1: {

                    imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.anim_fade_in));
                    imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.anim_fade_out));
                }
                    break;
                case 2: {

                    imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.anim_transy_in));
                    imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.anim_transy_out));
                }
                    break;
                case 3: {

                    /*
                    imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.anim_scale_rotate_in));
                    imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.anim_scale_rotate_out));
                    */

                    ScaleAnimation scaleAnimIn = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    scaleAnimIn.setInterpolator(new LinearInterpolator());
                    scaleAnimIn.setDuration(3000);

                    RotateAnimation rotateAnimIn = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimIn.setInterpolator(new LinearInterpolator());
                    rotateAnimIn.setStartOffset(3000);
                    rotateAnimIn.setDuration(3000);

                    AnimationSet animationSetIn = new AnimationSet(false);
                    animationSetIn.addAnimation(scaleAnimIn);
                    animationSetIn.addAnimation(rotateAnimIn);
                    imageSwitcher.setInAnimation(animationSetIn);

                    ScaleAnimation scaleAnimOut = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f,
                            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    scaleAnimOut.setInterpolator(new LinearInterpolator());
                    scaleAnimOut.setDuration(3000);

                    RotateAnimation rotateAnimOut = new RotateAnimation(360, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimOut.setInterpolator(new LinearInterpolator());
                    rotateAnimOut.setStartOffset(3000);
                    rotateAnimOut.setDuration(3000);

                    AnimationSet animationSetOut = new AnimationSet(false);
                    animationSetOut.addAnimation(scaleAnimOut);
                    animationSetOut.addAnimation(rotateAnimOut);
                    imageSwitcher.setOutAnimation(animationSetOut);
                }
                    break;
            }

            imageSwitcher.setImageResource(imgAry[i]);
        }
    };
}
