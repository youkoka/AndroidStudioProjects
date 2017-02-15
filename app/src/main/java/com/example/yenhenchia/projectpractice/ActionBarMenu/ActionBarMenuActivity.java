package com.example.yenhenchia.projectpractice.ActionBarMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.example.yenhenchia.projectpractice.R;

public class ActionBarMenuActivity extends AppCompatActivity {

    private static final int MENU_MUSIC = Menu.FIRST,
                             MENU_PALY_MUSIC = Menu.FIRST + 1,
                             MENU_STOP_PLAYING_MENU = Menu.FIRST + 2,
                             MENU_ABOUT = Menu.FIRST + 3,
                             MENU_EXIT = Menu.FIRST + 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //        menu.add(0, MENU_ABOUT, 1, "關於這個程式...").setIcon(android.R.drawable.ic_dialog_info);
        SubMenu subMenu = menu.addSubMenu(0, MENU_MUSIC, 0, "背景音樂").setIcon(android.R.drawable.ic_media_ff);
//        SubMenu subMenu = menu.addSubMenu(0, MENU_MUSIC, 0, "背景音樂");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
