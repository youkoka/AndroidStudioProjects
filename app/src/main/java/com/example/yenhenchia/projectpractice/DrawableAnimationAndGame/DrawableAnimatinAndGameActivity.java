package com.example.yenhenchia.projectpractice.DrawableAnimationAndGame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.MainActivity;
import com.example.yenhenchia.projectpractice.R;

import java.lang.ref.WeakReference;

public class DrawableAnimatinAndGameActivity extends AppCompatActivity {

    private ImageView imageDice;
    private Button btnRoll;
    private TextView rollResult;

    private static class staticHandler extends Handler {

        private  final WeakReference<DrawableAnimatinAndGameActivity> mActivity;

        public staticHandler(DrawableAnimatinAndGameActivity mainActivity) {

            mActivity = new WeakReference<DrawableAnimatinAndGameActivity>(mainActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            DrawableAnimatinAndGameActivity mainActivity = mActivity.get();

            if (mainActivity == null) {

                return;
            }

            int iRand = (int)(Math.random() * 6 + 1);

            String resutl = mainActivity.getString(R.string.rollResult);
            resutl += iRand;
            mainActivity.rollResult.setText(resutl);
            switch (iRand) {

                case 1: {

                    mainActivity.imageDice.setImageResource(R.drawable.dice_1);
                }
                    break;
                case 2: {

                    mainActivity.imageDice.setImageResource(R.drawable.dice_2);
                }
                    break;
                case 3: {

                    mainActivity.imageDice.setImageResource(R.drawable.dice_3);
                }
                    break;
                case 4: {

                    mainActivity.imageDice.setImageResource(R.drawable.dice_4);
                }
                    break;
                case 5: {

                    mainActivity.imageDice.setImageResource(R.drawable.dice_5);
                }
                    break;
                case 6: {

                    mainActivity.imageDice.setImageResource(R.drawable.dice_6);
                }
                    break;
            }
        }
    }

    private final staticHandler mHandler = new staticHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animatin_and_game);

        this.rollResult = (TextView)findViewById(R.id.rollResult);
        this.imageDice = (ImageView)findViewById(R.id.imageDice);
        this.btnRoll = (Button)findViewById(R.id.btnRoll);
        this.btnRoll.setOnClickListener(onClickListener);
    }

    private Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        imageDice.setImageResource(R.drawable.anim_roll_dice);
        final AnimationDrawable animationDrawable = (AnimationDrawable)imageDice.getDrawable();
        animationDrawable.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try{

                    Thread.sleep(5000);
                }
                catch (Exception e) {

                    e.printStackTrace();
                }
                finally {

                    animationDrawable.stop();

                    mHandler.sendMessage(mHandler.obtainMessage());
                }
            }
        }).start();
        /*
        Resources resources = getResources();
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(resources.getDrawable(R.drawable.dice_1), 100);
        animationDrawable.addFrame(resources.getDrawable(R.drawable.dice_2), 100);
        animationDrawable.addFrame(resources.getDrawable(R.drawable.dice_3), 100);
        animationDrawable.addFrame(resources.getDrawable(R.drawable.dice_4), 100);
        animationDrawable.addFrame(resources.getDrawable(R.drawable.dice_5), 100);
        animationDrawable.addFrame(resources.getDrawable(R.drawable.dice_6), 100);
        this.imageDice.setImageDrawable(animationDrawable);
        animationDrawable.start();
        */
        }
    };
}
