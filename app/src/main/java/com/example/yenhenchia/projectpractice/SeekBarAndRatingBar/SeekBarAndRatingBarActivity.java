package com.example.yenhenchia.projectpractice.SeekBarAndRatingBar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

public class SeekBarAndRatingBarActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private SeekBar seekBar;
    private TextView txtSeekBarProgress, txtRatingValue, txtRatingProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar_and_rating_bar);

        this.seekBar = (SeekBar)findViewById(R.id.seekBar);
        this.seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);

        this.ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        this.ratingBar.setOnRatingBarChangeListener(onRatingBarChangeListener);

        this.txtRatingProgress = (TextView)findViewById(R.id.txtRatingBarProgress);
        this.txtRatingValue = (TextView)findViewById(R.id.txtRatingBarRating);
        this.txtSeekBarProgress = (TextView)findViewById(R.id.txtSeekBarProgress);
    }

    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            String str = getString(R.string.seekBar_process);
            txtSeekBarProgress.setText(str + String.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private RatingBar.OnRatingBarChangeListener onRatingBarChangeListener = new RatingBar.OnRatingBarChangeListener() {

        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            String str = getString(R.string.ratingBar_value);
            txtRatingValue.setText(str + String.valueOf(rating));

            str = getString(R.string.ratingBar_process);
            txtRatingProgress.setText(str + String.valueOf(ratingBar.getProgress()));
        }
    };
}
