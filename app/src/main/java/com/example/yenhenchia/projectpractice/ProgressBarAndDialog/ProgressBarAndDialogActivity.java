package com.example.yenhenchia.projectpractice.ProgressBarAndDialog;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.yenhenchia.projectpractice.R;

import java.lang.ref.WeakReference;
import java.util.Calendar;

public class ProgressBarAndDialogActivity extends AppCompatActivity {

    private static class StaticHandler extends Handler {

        private final WeakReference<ProgressBarAndDialogActivity> mActicity;

        public StaticHandler(ProgressBarAndDialogActivity activity) {

            mActicity = new WeakReference<>(activity);
        }
    }

    public final StaticHandler staticHandler = new StaticHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_and_dialog);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressHorizontal);
        /*
        DoLengthWork doLengthWork = new DoLengthWork();
        doLengthWork.setHandler(staticHandler);
        doLengthWork.setProgressBar(progressBar);
        doLengthWork.start();
        */

        new Thread(new Runnable() {
            @Override
            public void run() {

                Calendar begin = Calendar.getInstance();

                do {

                    Calendar now = Calendar.getInstance();

                    final int iDiffSec = 60 * (now.get(Calendar.MINUTE) - begin.get(Calendar.MINUTE)) +
                            now.get(Calendar.SECOND) - begin.get(Calendar.SECOND);

                    if (iDiffSec * 2 > 100) {

                        staticHandler.post(new Runnable() {
                            @Override
                            public void run() {

                                progressBar.setProgress(100);
                            }
                        });

                        break;
                    }

                    staticHandler.post(new Runnable() {
                        @Override
                        public void run() {

                            progressBar.setProgress(iDiffSec * 2);
                        }
                    });

                    if (iDiffSec * 4 < 100) {

                        staticHandler.post(new Runnable() {
                            @Override
                            public void run() {

                                progressBar.setSecondaryProgress(iDiffSec * 4);
                            }
                        });
                    }
                    else {

                        staticHandler.post(new Runnable() {
                            @Override
                            public void run() {

                                progressBar.setSecondaryProgress(100);
                            }
                        });
                    }
                }while(true);
            }
        }).start();
    }
}
