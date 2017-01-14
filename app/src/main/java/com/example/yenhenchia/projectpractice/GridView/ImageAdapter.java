package com.example.yenhenchia.projectpractice.GridView;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by yenhenchia on 2017/1/6.
 */

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private Integer imageAry[];

    public ImageAdapter(Context content, Integer imageAry[]) {

        this.context = content;
        this.imageAry = imageAry;
    }

    @Override
    public int getCount() {
        return imageAry.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView imgView;

        if (view == null) {

            imgView = new ImageView(this.context);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);

            imgView.setLayoutParams(layoutParams);
            imgView.setScaleType(ImageView.ScaleType.CENTER);
            imgView.setPadding(10, 10, 10, 10);
        }
        else {

            imgView = (ImageView)view;
        }

        imgView.setImageResource(this.imageAry[i]);

        return imgView;
    }
}
