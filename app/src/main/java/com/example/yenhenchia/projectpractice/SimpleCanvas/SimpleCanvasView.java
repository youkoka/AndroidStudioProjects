package com.example.yenhenchia.projectpractice.SimpleCanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.example.yenhenchia.projectpractice.R;

/**
 * Created by yenhenchia on 2017/3/22.
 */

public class SimpleCanvasView extends View {

    private Context mContext;
    private ShapeDrawable shapeDrawable;
    private Paint paint;

    public SimpleCanvasView(Context context) {
        super(context);

        mContext = context;

        shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(0xffffff00);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.CYAN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        shapeDrawable.setBounds(10, 10, canvas.getWidth() / 2 - 10, canvas.getHeight() / 2 - 20);
        shapeDrawable.draw(canvas);

        canvas.drawOval(new RectF(canvas.getWidth() / 2 + 10, 10, canvas.getWidth() - 10, canvas.getHeight() / 2 - 20), paint);

        canvas.drawText("使用Canvas", 10, canvas.getHeight() / 2, paint);

        canvas.drawLine(canvas.getWidth() / 2, canvas.getHeight() / 2, canvas.getWidth() - 10, canvas.getHeight() / 2, paint);

        Drawable drawImg = ContextCompat.getDrawable(mContext, R.drawable.dog_0);
        drawImg.setBounds(10, canvas.getHeight() / 2 + 10, canvas.getWidth() / 2-10, canvas.getHeight() * 3/ 4);
        drawImg.draw(canvas);

        RotateDrawable rotateDrawable = (RotateDrawable)ContextCompat.getDrawable(mContext, R.drawable.rotate_drawable);
        rotateDrawable.setLevel(1000);
        rotateDrawable.setBounds(canvas.getWidth() / 2 + 30, canvas.getHeight() / 2 + 10, canvas.getWidth() + 10, canvas.getHeight() * 3/ 4);
        rotateDrawable.draw(canvas);


    }
}
