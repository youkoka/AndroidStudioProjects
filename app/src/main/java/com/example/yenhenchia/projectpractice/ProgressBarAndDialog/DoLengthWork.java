package com.example.yenhenchia.projectpractice.ProgressBarAndDialog;

import android.os.Handler;
import android.widget.ProgressBar;

import java.util.Calendar;

/**
 * Created by HenChia on 2017/1/24.
 */

public class DoLengthWork extends Thread {

    private Handler handler;
    private ProgressBar progressBar;

    @Override
    public void run() {
        super.run();

        Calendar begin = Calendar.getInstance();

        do {

            Calendar now = Calendar.getInstance();

            final int iDiffSec = 60 * (now.get(Calendar.MINUTE) - begin.get(Calendar.MINUTE)) +
                    now.get(Calendar.SECOND) - begin.get(Calendar.SECOND);

            if (iDiffSec * 2 > 100) {

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        progressBar.setProgress(100);
                    }
                });

                break;
            }

            handler.post(new Runnable() {
                @Override
                public void run() {

                    progressBar.setProgress(iDiffSec * 2);
                }
            });

            if (iDiffSec * 4 < 100) {

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        progressBar.setSecondaryProgress(iDiffSec * 4);
                    }
                });
            }
            else {

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        progressBar.setSecondaryProgress(100);
                    }
                });
            }
        }while(true);
    }

    void setProgressBar(ProgressBar progressBar) {

        this.progressBar = progressBar;
    }

    void setHandler(Handler handler) {

        this.handler = handler;
    }
}
