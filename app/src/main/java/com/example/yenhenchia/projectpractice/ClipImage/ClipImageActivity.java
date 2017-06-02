package com.example.yenhenchia.projectpractice.ClipImage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

public class ClipImageActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    private Bitmap bitmap, holeBitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_image);

        imageView = (ImageView)findViewById(R.id.clipImageView);
        textView = (TextView)findViewById(R.id.clipTextView);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_0);

        holeBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);



        Canvas canvas = new Canvas(holeBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        canvas.drawBitmap(bitmap, 0, 0, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//        float radius = (float)(bitmap.getWidth() * 0.2);
        int radius = getResources().getDimensionPixelSize(R.dimen.textview_roundle);
//        float x = (float) ((bitmap.getWidth()*.5) + (radius * .5));
//        float y = (float)  ((bitmap.getHeight()*.5) + (radius * .5));

        float x = 0;
        float y = 0;
        canvas.drawCircle(100, 100, radius, paint);

        imageView.setImageBitmap(holeBitmap);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int)(radius * 2), (int)(radius * 2));
        textView.setLayoutParams(layoutParams);


        textView.setTranslationX(imageView.getX() - radius - 10);
        textView.setTranslationY(imageView.getY() - radius - 10);

    }


}
