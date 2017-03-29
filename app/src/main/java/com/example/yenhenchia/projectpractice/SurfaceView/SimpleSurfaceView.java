package com.example.yenhenchia.projectpractice.SurfaceView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


/**
 * Created by yenhenchia on 2017/3/24.
 */

public class SimpleSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable{

    private SurfaceHolder surfaceHolder;

    private Paint mPaintForeground, mPaintBackground;

    private static final int INT_STROCK_THICK = 5;

    private int mIntXMaxLen, mIntYMaxLen,
                mIntXCenter, mIntYCenter,
                mIntXCurLen, mIntYCurLen,
                mIntSign;

    public SimpleSurfaceView(Context context) {

        super(context);

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        setFocusable(true);

        mPaintForeground = new Paint();
        mPaintForeground.setAntiAlias(true);
        mPaintForeground.setColor(Color.RED);
        mPaintForeground.setStyle(Paint.Style.STROKE);
        mPaintForeground.setStrokeWidth((float)INT_STROCK_THICK);

        mPaintBackground = new Paint();
        mPaintBackground.setAntiAlias(true);
        mPaintBackground.setColor(Color.WHITE);
        mPaintBackground.setStyle(Paint.Style.FILL);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        mIntXMaxLen = width / 2 - 10;
        mIntYMaxLen = height / 2 - 10;

        mIntXCenter = width / 2;
        mIntYCenter = height / 2;

        mIntXCurLen = mIntXMaxLen;
        mIntYCurLen = mIntYMaxLen;

        mIntSign = -1;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void run() {

        for (int i = 0; i != 500; i++) {

//            Log.d("Animation", "run()" + i);

            Canvas canvas = null;

            try {

                canvas = surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {

                    draw(canvas);
                }
            }
            finally {

                if (canvas != null) {

                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (canvas == null) {

            return;
        }

        Log.d("Animation", "draw!");

        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), mPaintBackground);

        canvas.drawOval(new RectF((mIntXCenter - mIntXCurLen), (mIntXCenter - mIntYCurLen), (mIntXCenter + mIntXCurLen), (mIntYCenter + mIntYCurLen)), mPaintForeground);

        if (mIntXCurLen + mIntSign * INT_STROCK_THICK < 0 ||
                mIntYCurLen + mIntSign * INT_STROCK_THICK < 0) {

            mIntSign = 1;
        }
        else if(mIntXCurLen + mIntSign * INT_STROCK_THICK > mIntXMaxLen ||
                mIntYCurLen + mIntSign * INT_STROCK_THICK > mIntYMaxLen) {

            mIntSign = -1;
        }

        mIntXCurLen += mIntSign * INT_STROCK_THICK;
        mIntYCurLen += mIntSign * INT_STROCK_THICK;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.d("Animation", "onDraw!");
    }
}
