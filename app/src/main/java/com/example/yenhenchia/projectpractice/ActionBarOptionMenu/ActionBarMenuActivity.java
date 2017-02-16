package com.example.yenhenchia.projectpractice.ActionBarOptionMenu;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.example.yenhenchia.projectpractice.R;

import java.io.File;

public class ActionBarMenuActivity extends AppCompatActivity {

    private static final int MENU_MUSIC = Menu.FIRST,
                             MENU_PALY_MUSIC = Menu.FIRST + 1,
                             MENU_STOP_PLAYING_MENU = Menu.FIRST + 2,
                             MENU_ABOUT = Menu.FIRST + 3,
                             MENU_TEXTLENGTH = Menu.FIRST + 4,
                             MENU_EXIT = Menu.FIRST + 5;

    // Storage Permissions variables
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_menu);

        verifyStoragePermissions(this);
    }

    //persmission method. Api 23+ need add this
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have read or write permission
        int writePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        SubMenu subMenu = menu.addSubMenu(0, MENU_MUSIC, 0, "背景音樂").setIcon(android.R.drawable.ic_media_ff);
        subMenu.add(0, MENU_PALY_MUSIC, 0, "播放背景音樂");
        subMenu.add(0, MENU_STOP_PLAYING_MENU, 1, "停止播放背景音樂");

        menu.add(0, MENU_TEXTLENGTH, 1, "測試字串長度測試字串長度測試字串長度測試字串長度測試字串長度測試字串長度測試字串長度測試字串長度").setIcon(android.R.drawable.ic_dialog_info);
        menu.add(0, MENU_ABOUT, 2, "關於這個程式").setIcon(android.R.drawable.ic_dialog_info);
        menu.add(0, MENU_EXIT, 3, "結束").setIcon(android.R.drawable.ic_menu_close_clear_cancel);

//        getMenuInflater().inflate(R.menu.option_menu_linear_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        item.getGroupId()

        switch (item.getItemId()) {

            case MENU_PALY_MUSIC: {

                Intent intent = new Intent(ActionBarMenuActivity.this, ActionBarMediaPlayerService.class);
                startService(intent);

                /*
                String mp3File = Environment.getExternalStorageDirectory().getPath() +
                        File.separator + "Music" +
                        File.separator +"V6-Darling.mp3";

                File file = new File(mp3File);
                if (file.exists()) {

                    Intent it = new Intent(Intent.ACTION_VIEW);
                    it.setDataAndType(Uri.fromFile(file), "audio/*");
                    startActivity(it);
                }
                */
            }
                break;
            case MENU_STOP_PLAYING_MENU: {

                Intent intent = new Intent(ActionBarMenuActivity.this, ActionBarMediaPlayerService.class);
                stopService(intent);
            }
                break;
            case MENU_ABOUT: {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setTitle("About!");
                alertDialog.setMessage("ActionBarMenuActivity Content!");
                alertDialog.setCancelable(false);

                alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alertDialog.show();
            }
                break;
            case MENU_EXIT: {

                finish();
            }
                break;
        }
        /*
        switch (item.getItemId()) {

            case R.id.menuItemPlayBackgroundMusic: {

                Log.d("onContextItemSelected", "menuItemPlayBackgroundMusic");
            }
            break;
            case R.id.menuItemStopBackgroundMusic: {

                Log.d("onContextItemSelected", "menuItemStopBackgroundMusic");
            }
            break;
            case R.id.menuItemAbort: {

                Log.d("onContextItemSelected", "menuItemAbort");
            }
            break;
            case R.id.menuItemExit: {

                Log.d("onContextItemSelected", "menuItemExit");
            }
            break;
        }
        */
        return super.onOptionsItemSelected(item);
    }
}
