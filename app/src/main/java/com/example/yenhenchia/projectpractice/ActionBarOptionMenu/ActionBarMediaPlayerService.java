package com.example.yenhenchia.projectpractice.ActionBarOptionMenu;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;

import java.io.File;
import java.io.IOException;

public class ActionBarMediaPlayerService extends Service {

    private MediaPlayer mediaPlayer;

    public ActionBarMediaPlayerService() {
    }

    public class LocalBinder extends Binder {

        ActionBarMediaPlayerService getService() {

            return ActionBarMediaPlayerService.this;
        }
    }

    private LocalBinder localBinder = new LocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return localBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String mp3File = Environment.getExternalStorageDirectory().getPath() +
                File.separator + "Music" +
                File.separator +"V6-Darling.mp3";

        File file = new File(mp3File);
        boolean isExist = file.exists();
        if (isExist) {

            Uri uri = Uri.fromFile(file);
            mediaPlayer = MediaPlayer.create(this, uri);
            mediaPlayer.start();

        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mediaPlayer.stop();
    }
}
