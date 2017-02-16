package com.example.yenhenchia.projectpractice.ActionBarMenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        SubMenu subMenu = menu.addSubMenu(0, MENU_MUSIC, 0, "背景音樂").setIcon(android.R.drawable.ic_media_ff);
        subMenu.add(0, MENU_PALY_MUSIC, 0, "播放背景音樂");
        subMenu.add(0, MENU_STOP_PLAYING_MENU, 1, "停止播放背景音樂");

        menu.add(0, MENU_TEXTLENGTH, 1, "測試字串長度測試字串長度測試字串長度測試字串長度測試字串長度測試字串長度測試字串長度測試字串長度").setIcon(android.R.drawable.ic_dialog_info);
        menu.add(0, MENU_ABOUT, 2, "關於這個程式").setIcon(android.R.drawable.ic_dialog_info);
        menu.add(0, MENU_EXIT, 3, "結束").setIcon(android.R.drawable.ic_menu_close_clear_cancel);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        item.getGroupId()

        switch (item.getItemId()) {

            case MENU_PALY_MUSIC: {

//                Intent intent = new Intent(ActionBarMenuActivity.this, ActionBarMediaPlayerService.class);
//                startService(intent);

                String mp3File = Environment.getExternalStorageDirectory().getPath() +
                        File.separator + "Music" +
                        File.separator +"9.BONJOUR!.mp3";
                File file = new File(mp3File);
                if (file.exists()) {

                    Intent it = new Intent(Intent.ACTION_VIEW);
                    it.setDataAndType(Uri.fromFile(file), "audio/*");
                    startActivity(it);
                }
            }
                break;
            case MENU_STOP_PLAYING_MENU: {

                Intent intent = new Intent(ActionBarMenuActivity.this, ActionBarMediaPlayerService.class);
                stopService(intent);
            }
                break;
            case MENU_EXIT: {

                finish();
            }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
