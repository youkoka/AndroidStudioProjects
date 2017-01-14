package com.example.yenhenchia.projectpractice.PropertyAnimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

public class PropertyAnimationActivity extends AppCompatActivity {

    private Button btnRotate, btnTransparent, btnDrop;
    private Button btnScale, btnShift, btnColor;
    private TextView txtDemo;

    private LinearLayout txtLinearLayout;
    private float y, yEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        this.txtLinearLayout = (LinearLayout)findViewById(R.id.activity_property_animation);

        this.btnDrop = (Button) findViewById(R.id.btnDrop);
        this.btnDrop.setOnClickListener(btnDropOnClick);

        this.btnRotate = (Button) findViewById(R.id.btnRotate);
        this.btnRotate.setOnClickListener(btnRotateOnClick);

        this.btnTransparent = (Button) findViewById(R.id.btnTransparent);
        this.btnTransparent.setOnClickListener(btnTransparentOnClick);

        this.btnScale = (Button) findViewById(R.id.btnScale);
        this.btnScale.setOnClickListener(btnScaleOnClick);

        this.btnShift = (Button) findViewById(R.id.btnShift);
        this.btnShift.setOnClickListener(btnShiftOnClick);

        this.btnColor = (Button) findViewById(R.id.btnColor);
        this.btnColor.setOnClickListener(btnColorOnClick);

        this.txtDemo = (TextView) findViewById(R.id.txtDemo);
    }

    private Button.OnClickListener btnRotateOnClick = new Button.OnClickListener() {

        @Override
        public void onClick(View view) {

            ObjectAnimator animTxtRotate = ObjectAnimator.ofFloat(txtDemo, "rotation", 0, 360);
            animTxtRotate.setDuration(3000);
            animTxtRotate.setRepeatCount(1);
            animTxtRotate.setRepeatMode(ObjectAnimator.REVERSE);
            animTxtRotate.setInterpolator(new AccelerateDecelerateInterpolator());
            animTxtRotate.start();
        }
    };

    private Button.OnClickListener btnDropOnClick = new Button.OnClickListener() {

        @Override
        public void onClick(View view) {

            y = txtDemo.getY();
            yEnd = txtLinearLayout.getHeight() - txtDemo.getHeight();

            final ObjectAnimator animTxtDrop = ObjectAnimator.ofFloat(txtDemo, "y", y, yEnd);
            animTxtDrop.setDuration(3000);
            animTxtDrop.setRepeatMode(ObjectAnimator.REVERSE);
            animTxtDrop.setInterpolator(new BounceInterpolator());
            animTxtDrop.start();

            animTxtDrop.addListener(new ObjectAnimator.AnimatorListener() {

                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {

                    txtDemo.setY(y);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
        }
    };

    private Button.OnClickListener btnTransparentOnClick = new Button.OnClickListener() {

        @Override
        public void onClick(View view) {

            ObjectAnimator animTxtAlpah = (ObjectAnimator)AnimatorInflater.loadAnimator(PropertyAnimationActivity.this,
                    R.animator.animator_alpha);
            animTxtAlpah.setTarget(txtDemo);
            animTxtAlpah.start();
        }
    };

    private Button.OnClickListener btnScaleOnClick = new Button.OnClickListener() {

        @Override
        public void onClick(View view) {

            ValueAnimator animTxtScale = ValueAnimator.ofInt(0, 35);
            animTxtScale.setDuration(4000);
            animTxtScale.setRepeatCount(1);
            animTxtScale.setRepeatMode(ObjectAnimator.REVERSE);
            animTxtScale.setInterpolator(new LinearInterpolator());
            animTxtScale.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {

                    int value = (Integer) valueAnimator.getAnimatedValue();
                    txtDemo.setTextSize(TypedValue.COMPLEX_UNIT_SP, value + 25);
                }
            });

            animTxtScale.start();
        }
    };

    private Button.OnClickListener btnShiftOnClick = new Button.OnClickListener() {

        @Override
        public void onClick(View view) {

            float x, xEnd1, xEnd2;

            x = txtDemo.getX();

            xEnd1 = 0;

            xEnd2 = txtLinearLayout.getWidth() - txtDemo.getWidth();

            ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(txtDemo, "x", x, xEnd1);
            objectAnimator1.setDuration(2000);
            objectAnimator1.setInterpolator(new LinearInterpolator());

            ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(txtDemo, "x", xEnd1, xEnd2);
            objectAnimator2.setDuration(4000);
            objectAnimator2.setInterpolator(new LinearInterpolator());

            ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(txtDemo, "x", xEnd2, x);
            objectAnimator3.setDuration(2000);
            objectAnimator3.setInterpolator(new LinearInterpolator());

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(objectAnimator1, objectAnimator2, objectAnimator3);
            animatorSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);

                    Log.d("btnShift", "start shift");
                }
            });

            animatorSet.start();
        }
    };

    private Button.OnClickListener btnColorOnClick = new Button.OnClickListener() {

        @Override
        public void onClick(View view) {

            int iBackColorRedVal, iBackColorRedEnd;
//            final int iBackColor = ((ColorDrawable)txtLinearLayout.getBackground()).getColor();

            int color = Color.TRANSPARENT;
            Drawable background = txtLinearLayout.getRootView().getBackground();
            if (background instanceof ColorDrawable)
                color = ((ColorDrawable) background).getColor();

            final int iBackColor = color;

            iBackColorRedVal = (iBackColor & 0x00FF0000) >> 16;

            if (iBackColorRedVal > 127) {

                iBackColorRedEnd = 0;
            }
            else {

                iBackColorRedEnd = 255;
            }

            ValueAnimator animTxtColor = ValueAnimator.ofInt(iBackColorRedVal, iBackColorRedEnd);
            animTxtColor.setDuration(2000);
            animTxtColor.setInterpolator(new LinearInterpolator());
            animTxtColor.start();
            animTxtColor.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {

                    int value = (Integer) valueAnimator.getAnimatedValue();
                    txtLinearLayout.setBackgroundColor(iBackColor & 0xFF00FFFF | value << 16);
                }
            });
        }
    };
}
