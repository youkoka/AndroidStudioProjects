package com.example.yenhenchia.projectpractice.GridView;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import com.example.yenhenchia.projectpractice.R;

public class GridViewActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory{

    private GridView gridView;
    private ImageSwitcher imageSwitcher;
    private Integer imgAry[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

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
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_fade_out));
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

            imageSwitcher.setImageResource(imgAry[i]);
        }
    };
}
