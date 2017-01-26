package com.example.yenhenchia.projectpractice.ProgressBarAndDialog;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.yenhenchia.projectpractice.PropertyAnimation.PropertyAnimationActivity;
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

    private Button btnProgressDefault, btnProgressHorizontal;

    private ProgressDialog progressDefaultDialog, progressHorizontalDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_and_dialog);

        this.btnProgressDefault = (Button)findViewById(R.id.btnProgressDefaultDialog);
        this.btnProgressDefault.setOnClickListener(onDefaultClickListener);

        this.btnProgressHorizontal = (Button)findViewById(R.id.btnProgressHorizontalDialog);
        this.btnProgressHorizontal.setOnClickListener(onHorizontalClickListener);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressHorizontal);

        DoLengthWork doLengthWork = new DoLengthWork();
        doLengthWork.setHandler(staticHandler);
        doLengthWork.setProgressBar(progressBar);
//        doLengthWork.start();

        /*
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
        */
    }

    private Button.OnClickListener onDefaultClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            progressDefaultDialog = ProgressDialog.show(ProgressBarAndDialogActivity.this, "Default", "3秒關閉", true, true);

            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {

                        Thread.sleep(3000);
                    }
                    catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    finally {

                        progressDefaultDialog.dismiss();
                    }
                }
            }).start();
        }
    };

    private Button.OnClickListener onHorizontalClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            progressHorizontalDialog = new ProgressDialog(ProgressBarAndDialogActivity.this);
            progressHorizontalDialog.setTitle("Horizontal");
            progressHorizontalDialog.setMessage("Waiting...");
            progressHorizontalDialog.setIcon(android.R.drawable.ic_dialog_info);
            progressHorizontalDialog.setCancelable(false);
            progressHorizontalDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressHorizontalDialog.setProgress(0);
            progressHorizontalDialog.setMax(100);
            progressHorizontalDialog.show();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    do {
                        try {

                            Thread.sleep(100);
                        }
                        catch (InterruptedException e) {

                            e.printStackTrace();
                        }

                        staticHandler.post(new Runnable() {
                            @Override
                            public void run() {

                                int length = progressHorizontalDialog.getProgress();
                                length++;
                                progressHorizontalDialog.setProgress(length);
                            }
                        });

                        if (progressHorizontalDialog.getProgress() >= 100) {

                            break;
                        }

                    }while(true);

                    progressHorizontalDialog.dismiss();
                }
            }).start();
        }
    };
}
